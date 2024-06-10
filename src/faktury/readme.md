### Ariel Michalik Wzorce projektowe 2
2. Ponieważ tym sposobem konstruktor będzie mieć mniej pól, a im mniej pól w kontruktorze tym mniejsza potrzeba na wykorzystywanie wzorca Builder, 
tak samo w metodach dzięki temu możemy ograniczyć liczbę argumentów
3. STRATEGIA
```java
package faktury.rabaty;

import faktury.rabatlosowy.LosowyRabat;

public interface ObliczCenePoRabacie {
	LosowyRabat losowyRabat = new LosowyRabat();
	double rabat = losowyRabat.losujRabat();
	double obliczCenePoRabacie(double cena);
}


public class ObliczCenePoRabacieKwotowym implements ObliczCenePoRabacie{
    @Override
    public double obliczCenePoRabacie(double cena) {
        return cena - rabat;
    }

}
public class ObliczCenePoRabacieProcentowym implements ObliczCenePoRabacie {

    @Override
    public double obliczCenePoRabacie(double cena) {
        return cena*(1-rabat);
    }

}
```
4. SINGLETON

```java
package faktury.dokumenty;

import faktury.rabaty.ObliczCenePoRabacie;

public class Konfiguracja {
    //implement as singleton
    private static Konfiguracja instance;
    private ObliczCenePoRabacie konfiguracjaObliczaniaCeny;
    private WydrukFaktury konfiguracjaWydrukuFaktury;
    private Faktura faktura;
    private Konfiguracja(){}

    public static Konfiguracja getInstance(){
        synchronized (Konfiguracja.class){
            if(instance == null){
                instance = new Konfiguracja();
            }
        }
        return instance;
    }

    public void setKonfiguracjaObliczaniaCeny(ObliczCenePoRabacie konfiguracjaObliczaniaCeny) {
        this.konfiguracjaObliczaniaCeny = konfiguracjaObliczaniaCeny;
    }

    public void setKonfiguracjaWydrukuFaktury(WydrukFaktury konfiguracjaWydrukuFaktury) {
        this.konfiguracjaWydrukuFaktury = konfiguracjaWydrukuFaktury;
    }

    public double getObliczanieRabatu(double cenaPrzedRabatem){
        return konfiguracjaObliczaniaCeny.obliczCenePoRabacie(cenaPrzedRabatem);
    }


    public void getWydrukujFakture() {
        konfiguracjaWydrukuFaktury.setFaktura(faktura);
        konfiguracjaWydrukuFaktury.drukujFakture();
    }

    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }
}

```

> Faktura

```java
package faktury.dokumenty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import faktury.magazyn.Kategoria;
import faktury.magazyn.KontenerTowar;


public class Faktura {
    private Konfiguracja konfiguracja;
    private KontenerTowar kontener;

    Date dataSprzedazy;
    String kontrahent;
    ArrayList<Pozycja> pozycje;
    double suma;
    public Faktura(Date dataSprzedazy,String kontrahent)
    {
        this.dataSprzedazy=dataSprzedazy;
        this.kontrahent=kontrahent;
        pozycje=new ArrayList<Pozycja>();
        suma=0;
    }


    public void dodajPozycje(Kategoria kategoria, double ilosc)
    {
        double suma = kontener.getCena();

        pozycje.add(new Pozycja(kategoria,ilosc));
        this.przeliczSume();
    }


    public double getSuma()
    {
        return suma;
    }
    public Date getDataSprzedazy()
    {
        return dataSprzedazy;
    }

    //jak sie zmieni cos na fakturze to trzeba wywolac te metode
    private void przeliczSume()
    {
        Iterator<Pozycja> iteratorPozycji=pozycje.iterator();
        Pozycja pozycja;
        suma=0;
        while(iteratorPozycji.hasNext())
        {
            pozycja = iteratorPozycji.next();
            double wartosc = pozycja.getWartosc();
            suma+= konfiguracja.getObliczanieRabatu(wartosc);
        }
    }
    public Iterator<Pozycja> getIteratorPozycji()
    {
        return pozycje.iterator();
    }
    public String getKontrahent()
    {
        return this.kontrahent;
    }


    public void setKonfiguracja(Konfiguracja konfiguracja) {
        this.konfiguracja = konfiguracja;
    }

    public void setKontener(KontenerTowar kontener) {
        this.kontener = kontener;
    }
}

```

5. FASADA, Template Method

```java
package faktury.dokumenty;

import java.util.Iterator;


//this is facade and base for template method
public abstract class WydrukFaktury {
    Faktura faktura;

    public final void drukujFakture()
    {
        drukujRozdzielnik();

        drukujNaglowek();
        drukujPozycje();
        drukujStopke();

        drukujRozdzielnik();


    }

    abstract void drukujNaglowek();
    void drukujPozycje() {

        Iterator<Pozycja> iteratorPozycji=faktura.getIteratorPozycji();
        while(iteratorPozycji.hasNext())
        {
            Pozycja pozycja=iteratorPozycji.next();
            System.out.println("Towar: "+pozycja.getNazwa()+" Ilosc: "+pozycja.getIlosc()+" Wartosc:" + pozycja.getWartosc());
        }
    }
    abstract void drukujStopke();

    void drukujRozdzielnik(){
        System.out.println("=====================================================");
    }

    void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }
}




public class SzalonyWydrukFaktury extends KlasycznyWydrukFaktury {


    @Override
    void drukujNaglowek() {
        System.out.println(String.format("Twoja faktura z dnia %s: jest już gotowa :)\nSpecjalnie przygotowana dla %s"
                ,faktura.dataSprzedazy.toString(), faktura.getKontrahent().toString()));

    }

}



public class KlasycznyWydrukFaktury  extends WydrukFaktury{

    @Override
    void drukujNaglowek(){
        System.out.println("FA z dnia: "+ faktura.getDataSprzedazy().toString() + "dla: "+ faktura.getKontrahent().toString());
    }

    @Override
    void drukujStopke() {
        System.out.println("Na kwote: "+faktura.getSuma());
    }
}

```
 6. ADAPTER

```java
public interface AdapterKonfiguracja {
    void setFaktura(Faktura f);

}


public class AdapterKonfiguracjaImp implements AdapterKonfiguracja {
    private Konfiguracja konfiguracja;
    private KontenerTowar kontener;
    public AdapterKonfiguracjaImp(Konfiguracja konfiguracja, KontenerTowar kontener) {
        this.konfiguracja = konfiguracja;
        this.kontener = kontener;
    }


    @Override
    public void setFaktura(Faktura f) {
        konfiguracja.setFaktura(f);
        f.setKonfiguracja(konfiguracja);
        f.setKontener(kontener);
    }


}

```

7. Composite

```java
public interface Towar {
        double getCena();
        String getNazwa();
        String getKategoria();


}
abstract public class Kategoria implements Towar{
    private double cena;
    private String nazwa;

    public Kategoria(double cena, String nazwa)
    {
        this.cena=cena;
        this.nazwa=nazwa;
    }

    @Override
    public double getCena() {
        return cena;
    }

    @Override
    public String getNazwa() {
        return nazwa;
    }

    @Override
    public String getKategoria() {
        return "podstawowa";
    }
}



public class KontenerTowar extends Kategoria {
    protected List<Towar> children = new ArrayList<>();
    public KontenerTowar(Towar... components){
        super(0, "item");
        add(components);
    }

    public void add(Towar component){
        children.add(component);
    }

    public void add(Towar... components){
        //add all elements from components given as ArrayList converted to list into children
        children.addAll(Arrays.asList(components));
    }

    public void addMultiple(Towar component, int count){
        while(count > 0){
            children.add(component);
            count--;
        }
    }

    public void remove(Towar component){
        children.remove(component);
    }

    public void remove(Towar... components){
        children.removeAll(Arrays.asList(components));
    }


    public void clear(){
        //erase all elements from the list
        children.clear();
    }


    public void displayContents() {
        for (Towar k : children) {
            System.out.println(k);
        }
    }


    @Override
    public double getCena(){
        if(children.size() == 0){
            return 0;
        }
        double suma = 0;
        for(Towar child: children){
            suma += child.getCena();
        }
        return suma;
    }


}



public class Jedzenie extends Kategoria{
    public Jedzenie(double cena, String nazwa) {
        super(cena, nazwa);
    }

    @Override
    public String getKategoria() {
        return "Jedzenie";
    }
}
public class Sport extends Kategoria{
    public Sport(double cena, String nazwa) {
        super(cena, nazwa);
    }

    @Override
    public String getKategoria() {
        return "Sport";
    }
}
public class Wypoczynek extends Kategoria{
    public Wypoczynek(double cena, String nazwa) {
        super(cena, nazwa);
    }

    @Override
    public String getKategoria() {
        return "Wypoczynek";
    }
}


```

> UI
```java
public class Ui {

	public static void main(String[] args) {
		Calendar teraz=Calendar.getInstance();

		//Tworzymy towary
		Kategoria t1=new Jedzenie(5,"marchewka");
		Kategoria t2=new Sport(1500,"kajak");
        Kategoria t3=new Wypoczynek(10000, "Wycieczka do Chin");

        KontenerTowar kontener = new KontenerTowar();
        kontener.addMultiple(t1, 3);
		kontener.addMultiple(t2, 5);
		kontener.add(t3);


		//I przykladowa fakture
		Faktura f=new Faktura(teraz.getTime(),"Fido");


		Konfiguracja konfiguracja = Konfiguracja.getInstance();
		konfiguracja.setKonfiguracjaObliczaniaCeny(new ObliczCenePoRabacieKwotowym());
		konfiguracja.setKonfiguracjaWydrukuFaktury(new SzalonyWydrukFaktury());
		AdapterKonfiguracjaImp adapter = new AdapterKonfiguracjaImp(konfiguracja, kontener);
		adapter.setFaktura(f);

        //to ma być robione przez kontener
		f.dodajPozycje(t1,3);
		f.dodajPozycje(t2, 5);
        f.dodajPozycje(t3, 1);

		konfiguracja.getWydrukujFakture();



	}


}
```


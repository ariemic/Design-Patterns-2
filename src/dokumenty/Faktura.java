package dokumenty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import magazyn.Towar;
import rabaty.ObliczCenePoRabacie;
import rabaty.ObliczCenePoRabacieKwotowym;


public class Faktura {
	private Konfiguracja konfiguracja;

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


	public void dodajPozycje(Towar towar, double ilosc)
	{
		pozycje.add(new Pozycja(towar,ilosc));
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

	private void setKonfiguracja(Konfiguracja konfiguracja){
		this.konfiguracja = konfiguracja;

	}

	public void setKonfiguracjaObliczaniaCeny(ObliczCenePoRabacie konfiguracjaObliczaniaCeny) {
		Konfiguracja konfiguracja = Konfiguracja.getInstance();
		konfiguracja.setKonfiguracjaObliczaniaCeny(konfiguracjaObliczaniaCeny); //ustawianie konfiguracji rabatu
		this.setKonfiguracja(konfiguracja);
	}
}

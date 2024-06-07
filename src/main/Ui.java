package main;

import dokumenty.Faktura;
import dokumenty.Konfiguracja;
import dokumenty.Pozycja;
import magazyn.Towar;
import rabatlosowy.LosowyRabat;
import rabaty.ObliczCenePoRabacie;
import rabaty.ObliczCenePoRabacieKwotowym;

import java.util.Calendar;
import java.util.Iterator;


public class Ui {

	public static void main(String[] args) {
		Calendar teraz=Calendar.getInstance();
		
		//Tworzymy towary
		Towar t1=new Towar(10,"buty");
		Towar t2=new Towar(2,"skarpety");

		//TEST ZEWN. rabatu
		LosowyRabat lr=new LosowyRabat();
		double rabat = lr.losujRabat();
		System.out.println(rabat);

		//I przykladowa fakture
		Faktura f=new Faktura(teraz.getTime(),"Fido");
		f.setRabat(rabat);
		Konfiguracja konfiguracja = Konfiguracja.getInstance();
		konfiguracja.setCena(new ObliczCenePoRabacieKwotowym());
		f.setKonfiguracja(konfiguracja);

		f.dodajPozycje(t1,3);
		f.dodajPozycje(t2, 5);

		wypiszFakture(f);


	}
	private static void wypiszFakture(Faktura faktura)
	{
		System.out.println("=====================================================");
		System.out.println("FA z dnia: "+faktura.getDataSprzedazy().toString());
		System.out.println("Wystawiona dla: "+faktura.getKontrahent());
		System.out.println("Na kwote: "+faktura.getSuma());
		Iterator<Pozycja> iteratorPozycji=faktura.getIteratorPozycji();
		while(iteratorPozycji.hasNext())
		{
			Pozycja pozycja=iteratorPozycji.next();
			System.out.println("Towar: "+pozycja.getNazwa()+" Ilosc: "+pozycja.getIlosc()+" Wartosc:" + pozycja.getWartosc());
		}
		System.out.println("=====================================================");
	}

}

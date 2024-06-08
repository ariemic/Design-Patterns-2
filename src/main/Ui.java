package main;

import dokumenty.Faktura;
import dokumenty.Konfiguracja;
import dokumenty.Pozycja;
import dokumenty.WydrukFaktury;
import magazyn.Towar;
import rabatlosowy.LosowyRabat;
import rabaty.ObliczCenePoRabacieKwotowym;

import java.util.Calendar;
import java.util.Iterator;


public class Ui {

	public static void main(String[] args) {
		Calendar teraz=Calendar.getInstance();
		
		//Tworzymy towary
		Towar t1=new Towar(10,"buty");
		Towar t2=new Towar(2,"skarpety");

		//todo TEST ZEWN. rabatu -> trzeba to przenieść do konfiguracji, tak aby klient nie mógł sam losować rabatu
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

		WydrukFaktury wydrukFaktury = new WydrukFaktury();
		wydrukFaktury.drukujFakture(f);


	}


}

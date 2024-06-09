package main;

import dokumenty.*;
import magazyn.*;
import rabaty.ObliczCenePoRabacieKwotowym;
import java.util.Calendar;


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

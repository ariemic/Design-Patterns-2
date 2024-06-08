package main;

import dokumenty.*;
import magazyn.Towar;
import rabaty.ObliczCenePoRabacieKwotowym;
import java.util.Calendar;


public class Ui {

	public static void main(String[] args) {
		Calendar teraz=Calendar.getInstance();
		
		//Tworzymy towary
		Towar t1=new Towar(10,"buty");
		Towar t2=new Towar(2,"skarpety");

		//I przykladowa fakture
		Faktura f=new Faktura(teraz.getTime(),"Fido");


		Konfiguracja konfiguracja = Konfiguracja.getInstance();
		konfiguracja.setKonfiguracjaObliczaniaCeny(new ObliczCenePoRabacieKwotowym());
		konfiguracja.setKonfiguracjaWydrukuFaktury(new SzalonyWydrukFaktury());
		AdapterKonfiguracjaImp adapter = new AdapterKonfiguracjaImp(konfiguracja);
		adapter.setFaktura(f);
		f.dodajPozycje(t1,3);
		f.dodajPozycje(t2, 5);

		konfiguracja.getWydrukujFakture();



	}


}

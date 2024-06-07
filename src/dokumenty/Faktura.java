package dokumenty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import magazyn.Towar;
import rabaty.ObliczCenePoRabacie;


public class Faktura {
	private Konfiguracja konfiguracja;
	private double rabat=0;

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
			suma+= konfiguracja.getObliczanieRabatu(wartosc, rabat);
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

	public void setKonfiguracja(Konfiguracja konfiguracja){
		this.konfiguracja = konfiguracja;
	}

	public void setRabat(double rabat){
		this.rabat = rabat;
	}
	
}

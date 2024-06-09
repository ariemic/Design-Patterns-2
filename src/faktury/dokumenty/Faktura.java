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

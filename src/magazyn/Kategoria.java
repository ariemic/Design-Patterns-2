package magazyn;

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

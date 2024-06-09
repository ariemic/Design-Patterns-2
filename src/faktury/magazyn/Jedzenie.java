package faktury.magazyn;

public class Jedzenie extends Kategoria{
    public Jedzenie(double cena, String nazwa) {
        super(cena, nazwa);
    }

    @Override
    public String getKategoria() {
        return "Jedzenie";
    }
}

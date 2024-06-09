package magazyn;

public class Wypoczynek extends Kategoria{
    public Wypoczynek(double cena, String nazwa) {
        super(cena, nazwa);
    }

    @Override
    public String getKategoria() {
        return "Wypoczynek";
    }
}

package faktury.magazyn;

public class Sport extends Kategoria{
    public Sport(double cena, String nazwa) {
        super(cena, nazwa);
    }

    @Override
    public String getKategoria() {
        return "Sport";
    }
}

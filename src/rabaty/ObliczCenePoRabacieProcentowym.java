package rabaty;

public class ObliczCenePoRabacieProcentowym implements ObliczCenePoRabacie {
    @Override
    public double obliczCenePoRabacie(double cena) {
        return cena*rabat;
    }
}

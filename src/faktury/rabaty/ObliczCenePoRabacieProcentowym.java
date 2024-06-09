package faktury.rabaty;

public class ObliczCenePoRabacieProcentowym implements ObliczCenePoRabacie {

    @Override
    public double obliczCenePoRabacie(double cena) {
        return cena*(1-rabat);
    }

}

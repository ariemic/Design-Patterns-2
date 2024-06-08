package rabaty;

import rabatlosowy.LosowyRabat;

public class ObliczCenePoRabacieKwotowym implements ObliczCenePoRabacie{

    @Override
    public double obliczCenePoRabacie(double cena) {
        return cena - rabat;
    }
}

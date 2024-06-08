package rabaty;

import rabatlosowy.LosowyRabat;

public interface ObliczCenePoRabacie {
	LosowyRabat losowyRabat = new LosowyRabat();
	double obliczCenePoRabacie(double cena, double rabat);
}

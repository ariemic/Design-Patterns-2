package faktury.rabaty;

import faktury.rabatlosowy.LosowyRabat;

public interface ObliczCenePoRabacie {
	LosowyRabat losowyRabat = new LosowyRabat();
	double rabat = losowyRabat.losujRabat();
	double obliczCenePoRabacie(double cena);
}

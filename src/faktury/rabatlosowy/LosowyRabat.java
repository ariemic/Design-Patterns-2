package faktury.rabatlosowy;

import java.util.Random;

public class LosowyRabat {
    public LosowyRabat() {
    }

    public double losujRabat() {
        Random rnd = new Random();
        double val = rnd.nextDouble();
        return val * 0.3;
    }
}

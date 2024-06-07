package dokumenty;

import rabaty.ObliczCenePoRabacie;

public class Konfiguracja {
    //implement as singleton
    private static Konfiguracja instance;
    private ObliczCenePoRabacie cena;
    private Konfiguracja(){}

    public static Konfiguracja getInstance(){
        synchronized (Konfiguracja.class){
            if(instance == null){
                instance = new Konfiguracja();
            }
        }
        return instance;
    }

    public void setCena(ObliczCenePoRabacie cena) {
        this.cena = cena;
    }

    public double getObliczanieRabatu(double cenaPrzedRabatem){
        return cena.obliczCenePoRabacie(cenaPrzedRabatem);
    }

}

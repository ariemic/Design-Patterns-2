package dokumenty;

import rabaty.ObliczCenePoRabacie;

public class Konfiguracja {
    //implement as singleton
    private static Konfiguracja instance;
    private ObliczCenePoRabacie konfiguracjaObliczaniaCeny;
    private Konfiguracja(){}

    public static Konfiguracja getInstance(){
        synchronized (Konfiguracja.class){
            if(instance == null){
                instance = new Konfiguracja();
            }
        }
        return instance;
    }

    public void setKonfiguracjaObliczaniaCeny(ObliczCenePoRabacie konfiguracjaObliczaniaCeny) {
        this.konfiguracjaObliczaniaCeny = konfiguracjaObliczaniaCeny;
    }

    public double getObliczanieRabatu(double cenaPrzedRabatem){
        return konfiguracjaObliczaniaCeny.obliczCenePoRabacie(cenaPrzedRabatem);
    }

}

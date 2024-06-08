package dokumenty;

import rabaty.ObliczCenePoRabacie;

public class Konfiguracja {
    //implement as singleton
    private static Konfiguracja instance;
    private ObliczCenePoRabacie konfiguracjaObliczaniaCeny;
    private WydrukFaktury konfiguracjaWydrukuFaktury;
    private Faktura faktura;
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

    public void setKonfiguracjaWydrukuFaktury(WydrukFaktury konfiguracjaWydrukuFaktury) {
        this.konfiguracjaWydrukuFaktury = konfiguracjaWydrukuFaktury;
    }

    public double getObliczanieRabatu(double cenaPrzedRabatem){
        return konfiguracjaObliczaniaCeny.obliczCenePoRabacie(cenaPrzedRabatem);
    }


    public void getWydrukujFakture() {
        konfiguracjaWydrukuFaktury.setFaktura(faktura);
        konfiguracjaWydrukuFaktury.drukujFakture();
    }

    public void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }
}

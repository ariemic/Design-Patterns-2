package dokumenty;

import java.util.Iterator;


//this is facade and base for template method
public abstract class WydrukFaktury {
    Faktura faktura;

    public final void drukujFakture()
    {
        drukujRozdzielnik();

        drukujNaglowek();
        drukujPozycje();
        drukujStopke();

        drukujRozdzielnik();


    }

    abstract void drukujNaglowek();
    void drukujPozycje() {

        Iterator<Pozycja> iteratorPozycji=faktura.getIteratorPozycji();
        while(iteratorPozycji.hasNext())
        {
            Pozycja pozycja=iteratorPozycji.next();
            System.out.println("Towar: "+pozycja.getNazwa()+" Ilosc: "+pozycja.getIlosc()+" Wartosc:" + pozycja.getWartosc());
        }
    }
    abstract void drukujStopke();

    void drukujRozdzielnik(){
        System.out.println("=====================================================");
    }

    void setFaktura(Faktura faktura) {
        this.faktura = faktura;
    }
}




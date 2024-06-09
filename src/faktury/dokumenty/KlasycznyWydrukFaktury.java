package faktury.dokumenty;

public class KlasycznyWydrukFaktury  extends WydrukFaktury{

    @Override
    void drukujNaglowek(){
        System.out.println("FA z dnia: "+ faktura.getDataSprzedazy().toString() + "dla: "+ faktura.getKontrahent().toString());
    }

    @Override
    void drukujStopke() {
        System.out.println("Na kwote: "+faktura.getSuma());
    }
}

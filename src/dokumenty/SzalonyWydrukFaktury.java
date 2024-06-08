package dokumenty;

public class SzalonyWydrukFaktury extends KlasycznyWydrukFaktury {


    @Override
    void drukujNaglowek() {
        System.out.println(String.format("Twoja faktura z dnia %s: jest już gotowa :)\nSpecjalnie przygotowana dla %s"
                ,faktura.dataSprzedazy.toString(), faktura.getKontrahent().toString()));

    }

}

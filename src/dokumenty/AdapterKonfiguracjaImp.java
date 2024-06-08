package dokumenty;

public class AdapterKonfiguracjaImp implements AdapterKonfiguracja {
    private Konfiguracja konfiguracja;
    public AdapterKonfiguracjaImp(Konfiguracja konfiguracja) {
        this.konfiguracja = konfiguracja;
    }


    @Override
    public void setFaktura(Faktura f) {
        konfiguracja.setFaktura(f);
        f.setKonfiguracja(konfiguracja);
    }


}

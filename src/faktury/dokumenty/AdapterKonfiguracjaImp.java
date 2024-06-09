package faktury.dokumenty;

import faktury.magazyn.KontenerTowar;

public class AdapterKonfiguracjaImp implements AdapterKonfiguracja {
    private Konfiguracja konfiguracja;
    private KontenerTowar kontener;
    public AdapterKonfiguracjaImp(Konfiguracja konfiguracja, KontenerTowar kontener) {
        this.konfiguracja = konfiguracja;
        this.kontener = kontener;
    }


    @Override
    public void setFaktura(Faktura f) {
        konfiguracja.setFaktura(f);
        f.setKonfiguracja(konfiguracja);
        f.setKontener(kontener);
    }


}

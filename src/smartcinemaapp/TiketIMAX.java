package smartcinemaapp;

public class TiketIMAX extends Tiket implements DapatDiskon, DapatCashback {
    private String tipeStudio;

    public TiketIMAX(String namaPemesan, String judulFilm, double hargaDasar, String tipeStudio) {
        super(namaPemesan, judulFilm, hargaDasar);
        this.tipeStudio = tipeStudio;
    }

    public String getTipeStudio() { return tipeStudio; }

    @Override
    public double hitungTotalHarga() {
        return getHargaDasar() + 40000;
    }

    @Override
    public void cetakStrukSpesifik() {
        System.out.println("-> Struk IMAX: Cetak digital barcode khusus studio " + tipeStudio);
    }

    @Override
    public void terapkanDiskon(double persentase) {
        double potongan = hitungTotalHarga() * (persentase / 100);
        System.out.printf("-> [Diskon IMAX] Promo IMAX diskon %.0f%% sebesar Rp%.2f\n", persentase, potongan);
    }

    @Override
    public void klaimCashback() {
        System.out.println("-> [Cashback IMAX] Selamat! Anda mendapatkan saldo cashback e-wallet Rp15.000.");
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[IMAX]    Pemesan: %-12s | Film: %-15s | Studio: %-10s | Total: Rp%.2f\n",
                getNamaPemesan(), getJudulFilm(), tipeStudio, hitungTotalHarga());
    }
}
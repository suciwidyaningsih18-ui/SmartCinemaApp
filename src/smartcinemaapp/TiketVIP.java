package smartcinemaapp;

public class TiketVIP extends Tiket implements DapatDiskon {
    private String fasilitasSnack;

    public TiketVIP(String namaPemesan, String judulFilm, double hargaDasar, String fasilitasSnack) {
        super(namaPemesan, judulFilm, hargaDasar);
        this.fasilitasSnack = fasilitasSnack;
    }

    public String getFasilitasSnack() { return fasilitasSnack; }

    @Override
    public double hitungTotalHarga() {
        return getHargaDasar() + 25000;
    }

    @Override
    public void cetakStrukSpesifik() {
        System.out.println("-> Struk VIP: Cetak eksklusif dengan kupon snack: " + fasilitasSnack);
    }

    @Override
    public void terapkanDiskon(double persentase) {
        double potongan = hitungTotalHarga() * (persentase / 100);
        System.out.printf("-> [Diskon VIP] Potongan member %.0f%% sebesar Rp%.2f\n", persentase, potongan);
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[VIP]     Pemesan: %-12s | Film: %-15s | Snack: %-10s | Total: Rp%.2f\n",
                getNamaPemesan(), getJudulFilm(), fasilitasSnack, hitungTotalHarga());
    }
}
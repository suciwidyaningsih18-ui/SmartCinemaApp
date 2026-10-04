package smartcinemaapp;

public class TiketVIP extends Tiket {
    private String fasilitasSnack;

    // Constructor dengan Keyword super
    public TiketVIP(String namaPemesan, String judulFilm, double hargaDasar, String fasilitasSnack) {
        super(namaPemesan, judulFilm, hargaDasar);
        this.fasilitasSnack = fasilitasSnack;
    }

    public String getFasilitasSnack() {
        return fasilitasSnack;
    }

    public void setFasilitasSnack(String fasilitasSnack) {
        this.fasilitasSnack = fasilitasSnack;
    }

    
    public double hitungTotalHarga() {
        // Tiket VIP ada tambahan biaya layanan dan snack Rp 25.000
        return getHargaDasar() + 25000;
    }

    public void tampilkanInfo() {
        System.out.printf("[VIP]     Pemesan: %-12s | Film: %-15s | Snack: %-10s | Total Biaya: Rp%.2f\n",
                getNamaPemesan(), getJudulFilm(), fasilitasSnack, hitungTotalHarga());
    }
}

package smartcinemaapp;

public class TiketReguler extends Tiket {
    private String nomorKursi;

    public TiketReguler(String namaPemesan, String judulFilm, double hargaDasar, String nomorKursi) {
        super(namaPemesan, judulFilm, hargaDasar);
        this.nomorKursi = nomorKursi;
    }

    public String getNomorKursi() {
        return nomorKursi;
    }

    public void setNomorKursi(String nomorKursi) {
        this.nomorKursi = nomorKursi;
    }


    @Override
    public double hitungTotalHarga() {
       
        return getHargaDasar() + 5000;
    }

    @Override
    public void tampilkanInfo() {
        System.out.printf("[REGULER] Pemesan: %-12s | Film: %-15s | Kursi: %-4s | Total Biaya: Rp%.2f\n",
                getNamaPemesan(), getJudulFilm(), nomorKursi, hitungTotalHarga());
    }
}
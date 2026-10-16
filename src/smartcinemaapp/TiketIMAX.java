package smartcinemaapp;

public class TiketIMAX extends Tiket {
    private String tipeStudio;

    public TiketIMAX(String namaPemesan, String judulFilm, double hargaDasar, String tipeStudio) {
        super(namaPemesan, judulFilm, hargaDasar);
        this.tipeStudio = tipeStudio;
    }
    public String getTipeStudio() {
        return tipeStudio;
    }

    public void setTipeStudio(String TipeStudio) {
        this.tipeStudio = tipeStudio;
    }
    @Override
    public double hitungTotalHarga() {
        return getHargaDasar() + 40000;
    }
    @Override
    public void tampilkanInfo() {
        System.out.printf("[IMAX]    Pemesan: %-12s | Film: %-15s | Studio: %-12s | Total Biaya: Rp%.2f\n",
                getNamaPemesan(), getJudulFilm(), tipeStudio, hitungTotalHarga());
    }
}
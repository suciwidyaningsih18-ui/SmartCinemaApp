package smartcinemaapp;

public class Tiket {
    private String namaPemesan;
    private String judulFilm;
    private double hargaDasar;

    private static int totalTiketDibuat = 0;

    public Tiket(String namaPemesan, String judulFilm, double hargaDasar) {
        this.namaPemesan = namaPemesan;
        this.judulFilm = judulFilm;
        this.hargaDasar = hargaDasar;
        totalTiketDibuat++; 
    }

    public String getNamaPemesan() {
        return namaPemesan;
    }

    public void setNamaPemesan(String namaPemesan) {
        this.namaPemesan = namaPemesan;
    }

    public String getJudulFilm() {
        return judulFilm;
    }

    public void setJudulFilm(String judulFilm) {
        this.judulFilm = judulFilm;
    }

    public double getHargaDasar() {
        return hargaDasar;
    }

    public void setHargaDasar(double hargaDasar) {
        this.hargaDasar = hargaDasar;
    }

    public static int getTotalTiketDibuat() {
        return totalTiketDibuat;
    }

    public double hitungTotalHarga() {
        return hargaDasar;
    }

    public void tampilkanInfo() {
        System.out.printf("Pemesan : %s | Film: %s | Harga Dasar: Rp%.2f\n", 
                          namaPemesan, judulFilm, hargaDasar);
    }

    public boolean cariTiket(String nama) {
        return this.namaPemesan.equalsIgnoreCase(nama);
    }

    public boolean cariTiket(String judul, boolean searchByFilm) {
        if (searchByFilm) {
            return this.judulFilm.equalsIgnoreCase(judul);
        }
        return false;
    }
}

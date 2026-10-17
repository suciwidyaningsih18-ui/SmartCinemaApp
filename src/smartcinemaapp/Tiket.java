package smartcinemaapp;

public abstract class Tiket {
    private String namaPemesan;
    private String judulFilm;
    private double hargaDasar;

    public static int totalTiketDibuat = 0;

    public Tiket(String namaPemesan, String judulFilm, double hargaDasar) {
        this.namaPemesan = namaPemesan;
        this.judulFilm = judulFilm;
        this.hargaDasar = hargaDasar;
        totalTiketDibuat++; 
    }
    
    public String getNamaPemesan() {
        return namaPemesan;
    }
    
    public String getJudulFilm() {
        return judulFilm;
    }
    
    public double getHargaDasar() {
        return hargaDasar;
    }
    
    public void tampilkanInfo() {
        System.out.printf("Pemesan: %-12s | Film: %-15s | Harga Dasar: Rp%.2f\n", namaPemesan, judulFilm, hargaDasar);
    }
    
    public abstract double hitungTotalHarga();
    public abstract void cetakStrukSpesifik();
}
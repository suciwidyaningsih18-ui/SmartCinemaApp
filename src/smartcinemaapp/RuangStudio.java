package smartcinemaapp;

public class RuangStudio {
    private String namaStudio;
    private int kapasitas;

    public RuangStudio(String namaStudio, int kapasitas) {
        this.namaStudio = namaStudio;
        this.kapasitas = kapasitas;
    }

    public void infoStudio() {
        System.out.println("-> [Komposisi Studio] Ruangan " + namaStudio + " siap dengan kapasitas " + kapasitas + " kursi.");
    }
}
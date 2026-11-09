package smartcinemaapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCinema {

    private static RuangStudio studioUtama = new RuangStudio("Studio IMAX Deluxe", 45);

    public static void cariTiket(String nama, ArrayList<Tiket> daftarTiket) throws TiketTidakDitemukanException {
        System.out.println("Mencari Tiket atas Nama: " + nama);
        boolean ditemukan = false;

        for (int i = 0; i < daftarTiket.size(); i++) {
            if (daftarTiket.get(i).getNamaPemesan().equalsIgnoreCase(nama)) {
                daftarTiket.get(i).tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            throw new TiketTidakDitemukanException("Gagal: Tiket dengan nama '" + nama + "' tidak terdaftar di sistem.");
        }
    }

    public static void simulasiCetakTiket(Tiket item) {
        System.out.print(">> [SIMULASI PROSES] ");
        item.tampilkanInfo();
        item.cetakStrukSpesifik();
    }
    public static void prosesTransaksiAsosiasi(String namaMember, Tiket tiketPilihan) {
        System.out.println("\n===== STRUK TRANSAKSI ASOSIASI =====");
        System.out.println("Member Peminjam/Pembeli : " + namaMember);
        System.out.println("Tiket Film Terpilih     : " + tiketPilihan.getJudulFilm());
        System.out.println("Status Transaksi        : Berhasil divalidasi dan diproses.");
        tiketPilihan.cetakStrukSpesifik();
        System.out.println("=====================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        studioUtama.infoStudio();

        ArrayList<Tiket> daftarTiket = new ArrayList<>();
        
        HashMap<String, String> dataAnggota = new HashMap<>();

        boolean running = true;

        System.out.println("============================================");
        System.out.println("    SELAMAT DATANG DI SMART CINEMA SYSTEM    ");
        System.out.println("============================================");

        try {
            while (running) {
                System.out.println("\n--- MENU UTAMA ---");
                System.out.println("1. Pesan Tiket Reguler");
                System.out.println("2. Pesan Tiket VIP");
                System.out.println("3. Pesan Tiket IMAX");
                System.out.println("4. Tampilkan Semua Tiket");
                System.out.println("5. Cari Tiket ");
                System.out.println("6. Simulasi Cetak Tiket ");
                System.out.println("7. Manajemen Anggota Member");
                System.out.println("8. Proses Transaksi ");
                System.out.println("9. Keluar");
                System.out.print("Pilih menu (1-9): ");

                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan Nama Pemesan : ");
                        String namaR = scanner.nextLine();
                        System.out.print("Masukkan Judul Film   : ");
                        String filmR = scanner.nextLine();
                        System.out.print("Masukkan Harga Dasar  : ");
                        double hargaR = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Masukkan Nomor Kursi  : ");
                        String kursi = scanner.nextLine();

                        daftarTiket.add(new TiketReguler(namaR, filmR, hargaR, kursi));
                        System.out.println(">> Tiket Reguler Berhasil Dipesan! (Total: " + daftarTiket.size() + ")");
                        break;

                    case 2:
                        System.out.print("Masukkan Nama Pemesan : ");
                        String namaV = scanner.nextLine();
                        System.out.print("Masukkan Judul Film   : ");
                        String filmV = scanner.nextLine();
                        System.out.print("Masukkan Harga Dasar  : ");
                        double hargaV = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Masukkan Paket Snack  : ");
                        String snack = scanner.nextLine();

                        daftarTiket.add(new TiketVIP(namaV, filmV, hargaV, snack));
                        System.out.println(">> Tiket VIP Berhasil Dipesan! (Total: " + daftarTiket.size() + ")");
                        break;

                    case 3:
                        System.out.print("Masukkan Nama Pemesan : ");
                        String namaI = scanner.nextLine();
                        System.out.print("Masukkan Judul Film   : ");
                        String filmI = scanner.nextLine();
                        System.out.print("Masukkan Harga Dasar  : ");
                        double hargaI = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Masukkan Tipe Studio  : ");
                        String kacamata = scanner.nextLine();

                        daftarTiket.add(new TiketIMAX(namaI, filmI, hargaI, kacamata));
                        System.out.println(">> Tiket IMAX Berhasil Dipesan! (Total: " + daftarTiket.size() + ")");
                        break;

                    case 4:
                        System.out.println("\n--- DAFTAR TIKET DIPESAN ---");
                        if (daftarTiket.isEmpty()) {
                            System.out.println("Belum ada tiket yang dipesan.");
                        } else {
                            for (int i = 0; i < daftarTiket.size(); i++) {
                                System.out.print((i + 1) + ". ");
                                daftarTiket.get(i).tampilkanInfo();
                                daftarTiket.get(i).cetakStrukSpesifik();

                                if (daftarTiket.get(i) instanceof DapatDiskon) {
                                    ((DapatDiskon) daftarTiket.get(i)).terapkanDiskon(10);
                                }
                                if (daftarTiket.get(i) instanceof DapatCashback) {
                                    ((DapatCashback) daftarTiket.get(i)).klaimCashback();
                                }
                                System.out.println("------------------------------------------------------------------");
                            }
                            System.out.println("Total Tiket Terbuat (Static): " + Tiket.totalTiketDibuat);
                        }
                        break;

                    case 5:
                        System.out.println("\n--- FITUR CARI TIKET ---");
                        System.out.print("Masukkan Nama Pemesan yang dicari: ");
                        String cariNama = scanner.nextLine();

                        try {
                            cariTiket(cariNama, daftarTiket);
                        } catch (TiketTidakDitemukanException e) {
                            System.out.println("Peringatan: " + e.getMessage());
                        } finally {
                            System.out.println("-> Sesi pencarian tiket selesai dieksekusi.");
                        }
                        break;

                    case 6:
                        System.out.println("\n--- SIMULASI CETAK TIKET (PARAMETER UPCASTING) ---");
                        if (daftarTiket.isEmpty()) {
                            System.out.println(">> Belum ada tiket untuk disimulasikan.");
                        } else {
                            for (int i = 0; i < daftarTiket.size(); i++) {
                                simulasiCetakTiket(daftarTiket.get(i));
                            }
                        }
                        break;

                    case 7:
                        System.out.println("\n--- KELOLA ANGGOTA MEMBER (HASHMAP) ---");
                        System.out.println("1. Tambah Anggota Baru");
                        System.out.println("2. Cari Anggota via ID/NPM");
                        System.out.println("3. Tampilkan Semua Anggota");
                        System.out.print("Pilih menu member (1-3): ");
                        int menuMember = scanner.nextInt();
                        scanner.nextLine();

                        if (menuMember == 1) {
                            System.out.print("Masukkan ID/NPM Member (sebagai Key): ");
                            String idMember = scanner.nextLine();
                            System.out.print("Masukkan Nama Lengkap (sebagai Value): ");
                            String namaMember = scanner.nextLine();

                            dataAnggota.put(idMember, namaMember);
                            System.out.println(">> Berhasil menambahkan anggota member baru!");
                        } else if (menuMember == 2) {
                            System.out.print("Masukkan ID/NPM yang dicari: ");
                            String searchId = scanner.nextLine();

                            if (dataAnggota.containsKey(searchId)) {
                                System.out.println(">> Ditemukan! Nama Member: " + dataAnggota.get(searchId));
                            } else {
                                System.out.println(">> Anggota dengan ID tersebut tidak terdaftar.");
                            }
                        } else if (menuMember == 3) {
                            System.out.println("Total Anggota Terdaftar: " + dataAnggota.size());
                            for (String keyId : dataAnggota.keySet()) {
                                System.out.println("- ID/NPM: " + keyId + " | Nama: " + dataAnggota.get(keyId));
                            }
                        } else {
                            System.out.println(">> Pilihan menu member tidak valid.");
                        }
                        break;

                    case 8:
                        System.out.println("\n--- SISTEM TRANSAKSI  ---");
                        if (dataAnggota.isEmpty() || daftarTiket.isEmpty()) {
                            System.out.println(">> Pastikan sudah ada data Member dan data Tiket yang terdaftar terlebih dahulu!");
                        } else {
                            System.out.print("Masukkan ID/NPM Member yang melakukan transaksi: ");
                            String idAsosiasi = scanner.nextLine();

                            if (dataAnggota.containsKey(idAsosiasi)) {
                                String namaM = dataAnggota.get(idAsosiasi);
                                System.out.println("-> Member terdeteksi: " + namaM);
                                
                                System.out.println("Pilih nomor tiket dari daftar berikut:");
                                for (int i = 0; i < daftarTiket.size(); i++) {
                                    System.out.print((i + 1) + ". ");
                                    daftarTiket.get(i).tampilkanInfo();
                                }
                                System.out.print("Masukkan nomor urut tiket: ");
                                int idxTiket = scanner.nextInt() - 1;
                                scanner.nextLine();

                                if (idxTiket >= 0 && idxTiket < daftarTiket.size()) {
                               
                                    prosesTransaksiAsosiasi(namaM, daftarTiket.get(idxTiket));
                                } else {
                                    System.out.println(">> Nomor tiket tidak valid.");
                                }
                            } else {
                                System.out.println(">> ID Member tidak ditemukan di sistem.");
                            }
                        }
                        break;

                    case 9:
                        running = false;
                        System.out.println("\nTerima kasih telah menggunakan Smart Cinema System!");
                        break;

                    default:
                        System.out.println(">> Pilihan menu tidak valid, silakan coba lagi.");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("\n[FATAL ERROR] Input tidak valid! Anda harus memasukkan format angka.");
        } catch (Exception e) {
            System.out.println("\n[ERROR SISTEM] Terjadi kegagalan: " + e.getMessage());
        } finally {
            System.out.println("Blok finally: Menutup scanner dan menghentikan program.");
            scanner.close();
        }
    }
}
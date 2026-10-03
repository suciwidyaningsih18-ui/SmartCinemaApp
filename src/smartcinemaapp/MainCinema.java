package smartcinemaapp;

import java.util.Scanner;

public class MainCinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Tiket[] daftarTiket = new Tiket[10];
        int jumlahTiket = 0;
        boolean running = true;

        System.out.println("============================================");
        System.out.println("   SELAMAT DATANG DI SMART CINEMA SYSTEM    ");
        System.out.println("============================================");

        while (running) {
            System.out.println("\n--- MENU UTAMA ---");
            System.out.println("1. Pesan Tiket Reguler");
            System.out.println("2. Pesan Tiket VIP");
            System.out.println("3. Tampilkan Semua Tiket");
            System.out.println("4. Cari Tiket Berdasarkan Nama Pemesan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            
            int pilihan = scanner.nextInt();
            scanner.nextLine();

          
            switch (pilihan) {
                case 1:
                    if (jumlahTiket < daftarTiket.length) {
                        System.out.print("Masukkan Nama Pemesan : ");
                        String namaR = scanner.nextLine();
                        System.out.print("Masukkan Judul Film   : ");
                        String filmR = scanner.nextLine();
                        System.out.print("Masukkan Harga Dasar  : ");
                        double hargaR = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Masukkan Nomor Kursi  : ");
                        String kursi = scanner.nextLine();

                       
                        daftarTiket[jumlahTiket] = new TiketReguler(namaR, filmR, hargaR, kursi);
                        jumlahTiket++;
                        System.out.println(">> Tiket Reguler Berhasil Dipesan!");
                    } else {
                        System.out.println(">> Kapasitas penyimpanan tiket penuh!");
                    }
                    break;

                case 2:
                    if (jumlahTiket < daftarTiket.length) {
                        System.out.print("Masukkan Nama Pemesan : ");
                        String namaV = scanner.nextLine();
                        System.out.print("Masukkan Judul Film   : ");
                        String filmV = scanner.nextLine();
                        System.out.print("Masukkan Harga Dasar  : ");
                        double hargaV = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.print("Masukkan Paket Snack  : ");
                        String snack = scanner.nextLine();

                       
                        daftarTiket[jumlahTiket] = new TiketVIP(namaV, filmV, hargaV, snack);
                        jumlahTiket++;
                        System.out.println(">> Tiket VIP Berhasil Dipesan!");
                    } else {
                        System.out.println(">> Kapasitas penyimpanan tiket penuh!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- DAFTAR TIKET DIPESAN ---");
                    if (jumlahTiket == 0) {
                        System.out.println("Belum ada tiket yang dipesan.");
                    } else {
                        for (int i = 0; i < jumlahTiket; i++) {
                           
                            daftarTiket[i].tampilkanInfo();
                        }
                        System.out.println("Total Tiket Terbuat (Static): " + Tiket.getTotalTiketDibuat());
                    }
                    break;

                case 4:
                    System.out.print("Masukkan Nama Pemesan yang dicari: ");
                    String cariNama = scanner.nextLine();
                    boolean ditemukanNama = false;
                    for (int i = 0; i < jumlahTiket; i++) {
                       
                        if (daftarTiket[i].cariTiket(cariNama)) {
                            daftarTiket[i].tampilkanInfo();
                            ditemukanNama = true;
                        }
                    }
                    if (!ditemukanNama) {
                        System.out.println(">> Tiket atas nama '" + cariNama + "' tidak ditemukan.");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("\nTerima kasih telah menggunakan Smart Cinema System!");
                    break;

                default:
                    System.out.println(">> Pilihan tidak valid, silakan coba lagi.");
            }
        }
        scanner.close();
    }
}
import java.util.Scanner;

public class SistemAntrianKlinik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PasienLinkedList antrianPasien = new PasienLinkedList();
        TransaksiQueue riwayat = new TransaksiQueue(100); // kapasitas 100 transaksi

        while (true) {
            System.out.println("\n==============================");
            System.out.println("   SISTEM ANTRIAN KLINIK");
            System.out.println("==============================");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Tampilkan Daftar Antrian");
            System.out.println("3. Layani Pasien Berikutnya");
            System.out.println("4. Cek Jumlah Pasien di Antrian");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            int pilihan;
            try {
                pilihan = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("  >> Input ga valid, masukkan angka 1-6.");
                continue;
            }

            switch (pilihan) {
                case 1:
                    // Input data pasien baru
                    System.out.print("  Masukkan Nama Pasien : ");
                    String namaPasien = sc.nextLine();
                    System.out.print("  Masukkan NIK Pasien  : ");
                    String nikPasien = sc.nextLine();
                    System.out.print("  Masukkan Keluhan     : ");
                    String keluhan = sc.nextLine();

                    Pasien pasienBaru = new Pasien(namaPasien, nikPasien, keluhan);
                    antrianPasien.enqueue(pasienBaru);
                    break;

                case 2:
                    // Tampilkan semua pasien di antrian
                    antrianPasien.displayAntrian();
                    break;

                case 3:
                    // Melayani pasien depan, masukin transaksi
                    if (antrianPasien.isEmpty()) {
                        System.out.println("  >> Antrian kosong, ga ada pasien buat dilayani.");
                    } else {
                        Pasien pasienDilangani = antrianPasien.dequeue();
                        System.out.println("  >> Sedang melayani pasien:");
                        pasienDilangani.tampil();

                        // Input data dokter dan durasi
                        System.out.print("    Masukkan ID Dokter    : ");
                        String idDok = sc.nextLine();
                        System.out.print("    Masukkan Nama Dokter  : ");
                        String namaDok = sc.nextLine();
                        System.out.print("    Durasi layanan (jam)  : ");
                        int durasi;
                        try {
                            durasi = Integer.parseInt(sc.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("    >> Durasi ga valid. Set durasi jadi 1 jam.");
                            durasi = 1;
                        }

                        Dokter dokter = new Dokter(idDok, namaDok);
                        // Parameter biaya ga penting (di-override jadi 50000)
                        TransaksiLayanan trx = new TransaksiLayanan(pasienDilangani, dokter, durasi, 0);
                        riwayat.enqueue(trx);
                        System.out.println("    >> Total Biaya: Rp " + trx.hitungBiaya());
                    }
                    break;

                case 4:
                    // Cek jumlah pasien di antrian
                    System.out.println("  >> Jumlah pasien dalam antrian: " + antrianPasien.getSize());
                    break;

                case 5:
                    // Tampilkan riwayat transaksi
                    riwayat.displayRiwayat();
                    break;

                case 6:
                    System.out.println("  >> Keluar.. Sampai ketemu lagi!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("  >> Pilihan harus 1-6.");
            }
        }
    }
}

// Dimas Adit Thalia Putra / 06 & Pranata Putrandana / 19
import java.util.Scanner;

public class SistemAntrianKlinik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PasienLinkedList antrianPasien = new PasienLinkedList();
        TransaksiQueue riwayat = new TransaksiQueue(100);

        while (true) {
            System.out.println("\n===============================");
            System.out.println("-----SISTEM ANTRIAN KLINIK-----");
            System.out.println("===============================");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Tampilkan Daftar Antrian");
            System.out.println("3. Layani Pasien Berikutnya");
            System.out.println("4. Cek Sisa Pasien di Antrian");
            System.out.println("5. Tampilkan Riwayat Transaksi");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");

            int pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan Nama Pasien : ");
                    String namaPasien = sc.nextLine();
                    System.out.print("Masukkan NIK Pasien  : ");
                    String nikPasien = sc.nextLine();
                    System.out.print("Masukkan Keluhan     : ");
                    String keluhan = sc.nextLine();

                    Pasien pasienBaru = new Pasien(namaPasien, nikPasien, keluhan);
                    antrianPasien.add(pasienBaru);
                    break;

                case 2:
                    antrianPasien.displayAntrian();
                    break;

                case 3:
                    if (antrianPasien.isEmpty()) {
                        System.out.println("Antrian kosong, tidak ada pasien untuk dilayani.");
                    } else {
                        Pasien pasienDilangani = antrianPasien.layani();
                        System.out.println("Melayani pasien berikut:");
                        pasienDilangani.tampil();

                        System.out.print("Masukkan ID Dokter   : ");
                        String idDok = sc.nextLine();
                        System.out.print("Masukkan Nama Dokter : ");
                        String namaDok = sc.nextLine();
                        System.out.print("Durasi layanan (jam) : ");

                        int durasi = sc.nextInt();
                        sc.nextLine();

                        Dokter dokter = new Dokter(idDok, namaDok);
                        TransaksiLayanan trx = new TransaksiLayanan(pasienDilangani, dokter, durasi);
                        riwayat.enqueue(trx);
                        System.out.println("Total Biaya : Rp " + trx.hitungBiaya());
                    }
                    break;

                case 4:
                    System.out.println("Jumlah pasien dalam antrian : " + antrianPasien.getSize());
                    break;

                case 5:
                    riwayat.getRiwayat();
                    break;

                case 6:
                    System.out.println("Keluar program. Sampai jumpa!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1-6.");
            }
        }
    }
}

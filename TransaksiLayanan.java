// Dimas Adit Thalia Putra / 06
public class TransaksiLayanan {
    Pasien pasien;
    Dokter dokter;
    int durasiLayanan;
    int biaya;

    public TransaksiLayanan (Pasien pasien, Dokter dokter, int durasiLayanan) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.durasiLayanan = durasiLayanan;
        biaya = 50000;
    }

    public int hitungBiaya() {
        return durasiLayanan * biaya;
    }

    public void tampil() {
        System.out.println("Id Dokter : " + dokter.idDokter + "\t | Nama Dokter : " + dokter.nama);
        System.out.println("NIK : " + pasien.nik + "\t | Nama Pasien : " + pasien.nama +  "\t | Keluhan : " + pasien.keluhan);
        System.out.println("Durasi Layanan : " + durasiLayanan + "\t | Biaya : " + hitungBiaya());
    }
}

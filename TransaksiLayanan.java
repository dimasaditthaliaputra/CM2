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
        System.out.println("Nama Dokter : " + dokter.nama + " NIK : " + pasien.nik + " Keluhan : " + pasien.keluhan + " Durasi Layanan : " + durasiLayanan + " Biaya : " + hitungBiaya());
    }
}

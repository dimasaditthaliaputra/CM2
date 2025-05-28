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
        System.out.println("Id Dokter" + dokter.idDokter + "Nama Dokter : " + dokter.nama);
        System.out.println("NIK : " + pasien.nik + "Nama Pasien : " + pasien.nama +  " Keluhan : " + pasien.keluhan);
        System.out.println("Durasi Layanan : " + durasiLayanan + " Biaya : " + hitungBiaya());
    }
}

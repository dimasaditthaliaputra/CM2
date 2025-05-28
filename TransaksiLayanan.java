public class TransaksiLayanan {
    Pasien pasien;
    Dokter dokter;
    int durasiLayanan;
    int biaya;

    public TransaksiLayanan (Pasien pasien, Dokter dokter, int durasiLayanan, int biaya) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.durasiLayanan = durasiLayanan;
        biaya = 50000;
    }

    public int hitungBiaya() {
        return durasiLayanan * biaya;
    }
}

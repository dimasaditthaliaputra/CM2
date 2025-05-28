public class Dokter {
    String nama, nik, keluhan;

    public Dokter(String nama, String nik, String keluhan) {
        this.nama = nama;
        this.nik = nik;
        this.keluhan = keluhan;
    }

    public void tampil(){
        System.out.println("Nama Dokter : " + nama + " NIK : " + nik + " Keluhan : " + keluhan);
    }
}
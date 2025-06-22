// Pranata Putrandana / 19
public class Pasien {
    String nama, nik, keluhan;

    public Pasien(String nama, String nik, String keluhan) {
        this.nama = nama;
        this.nik = nik;
        this.keluhan = keluhan;
    }

    public void tampil(){
        System.out.println("NAMA : " + nama + "\t\t| NIK : " + nik + " \t\t| KELUHAN : " + keluhan);
    }
}
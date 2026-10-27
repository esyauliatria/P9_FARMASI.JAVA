package model;

public class Pelanggan {
    private String idPelanggan;
    private String nama;
    private String nomorTelepon;

    public Pelanggan(String idPelanggan, String nama, String nomorTelepon) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
    }

    public String getIdPelanggan() {
        return idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }
}
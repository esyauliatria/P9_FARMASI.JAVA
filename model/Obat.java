package model;

public class Obat {
    private String kodeObat;
    private String namaObat;
    private double harga;
    private int stok;

    public Obat(String kodeObat, String namaObat, double harga, int stok) {
        this.kodeObat = kodeObat;
        this.namaObat = namaObat;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKodeObat() {
        return kodeObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    // Validasi state & responsibility pengubahan stok
    public void tambahStok(int jumlah) {
        if (jumlah > 0) {
            this.stok += jumlah;
            System.out.println("Stok " + namaObat + " berhasil ditambah " + jumlah);
        } else {
            System.out.println("Jumlah stok tambahan harus lebih besar dari 0!");
        }
    }

    public boolean kurangiStok(int jumlah) {
        if (jumlah <= 0) {
            System.out.println("Jumlah pembelian harus lebih dari 0!");
            return false;
        }
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
            return true;
        } else {
            System.out.println("Stok obat " + namaObat + " tidak mencukupi!");
            return false;
        }
    }
}
package model;

public class DetailTransaksi {
    private Obat obat;
    private int jumlah;
    private double subtotal;

    public DetailTransaksi(Obat obat, int jumlah) {
        this.obat = obat;
        this.jumlah = jumlah;
        this.subtotal = hitungSubtotal();
    }

    public double hitungSubtotal() {
        return obat.getHarga() * jumlah;
    }

    public Obat getObat() {
        return obat;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
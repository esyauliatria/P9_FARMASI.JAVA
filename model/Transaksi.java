package model;

import java.util.ArrayList;
import java.util.List;

public class Transaksi {
    private String idTransaksi;
    private Pelanggan pelanggan;
    private List<DetailTransaksi> listDetail;
    private double totalBayar;
    private boolean statusLunas;

    public Transaksi(String idTransaksi, Pelanggan pelanggan) {
        this.idTransaksi = idTransaksi;
        this.pelanggan = pelanggan;
        this.listDetail = new ArrayList<>();
        this.totalBayar = 0.0;
        this.statusLunas = false;
    }

    // Mengimplementasikan relasi dan behavior validasi stok obat
    public void tambahObat(Obat obat, int jumlah) {
        if (obat.kurangiStok(jumlah)) {
            DetailTransaksi detail = new DetailTransaksi(obat, jumlah);
            listDetail.add(detail);
            hitungTotal();
            System.out.println("Berhasil menambahkan " + jumlah + " pcs " + obat.getNamaObat() + " ke transaksi.");
        } else {
            System.out.println("Gagal menambahkan " + obat.getNamaObat() + " ke transaksi.");
        }
    }

    public double hitungTotal() {
        totalBayar = 0;
        for (DetailTransaksi detail : listDetail) {
            totalBayar += detail.getSubtotal();
        }
        return totalBayar;
    }

    public boolean prosesPembayaran(double jumlahUang) {
        if (jumlahUang >= totalBayar) {
            double kembalian = jumlahUang - totalBayar;
            statusLunas = true;
            System.out.println("\nPembayaran Berhasil!");
            System.out.println("Uang diterima : Rp " + jumlahUang);
            System.out.println("Kembalian     : Rp " + kembalian);
            return true;
        } else {
            System.out.println("\nPembayaran Gagal! Uang tidak cukup. Kurang: Rp " + (totalBayar - jumlahUang));
            return false;
        }
    }

    public void cetakStruk() {
        System.out.println("\n==========================================");
        System.out.println("              STRUK PHARMACY              ");
        System.out.println("==========================================");
        System.out.println("ID Transaksi : " + idTransaksi);
        System.out.println("Pelanggan    : " + pelanggan.getNama() + " (" + pelanggan.getNomorTelepon() + ")");
        System.out.println("Status       : " + (statusLunas ? "LUNAS" : "BELUM LUNAS"));
        System.out.println("------------------------------------------");
        System.out.printf("%-15s %-5s %-10s %-10s\n", "Item", "Qty", "Harga", "Subtotal");
        System.out.println("------------------------------------------");
        for (DetailTransaksi d : listDetail) {
            System.out.printf("%-15s %-5d %-10.0f %-10.0f\n", 
                d.getObat().getNamaObat(), 
                d.getJumlah(), 
                d.getObat().getHarga(), 
                d.getSubtotal());
        }
        System.out.println("------------------------------------------");
        System.out.println("TOTAL BAYAR  : Rp " + totalBayar);
        System.out.println("==========================================");
    }
}
import model.Obat;
import model.Pelanggan;
import model.Transaksi;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEM INFORMASI FARMASI ===");

        // 1. Inisialisasi Data Obat & Pelanggan
        Obat obat1 = new Obat("OBT001", "Paracetamol", 5000, 20);
        Obat obat2 = new Obat("OBT002", "Amoxicillin", 12000, 10);
        
        Pelanggan pelanggan1 = new Pelanggan("P001", "Budi Santoso", "08123456789");

        // 2. Tambah Stok Obat
        obat1.tambahStok(5); // Stok Paracetamol jadi 25

        // 3. Membuat Transaksi Baru
        Transaksi trx = new Transaksi("TRX-20261027-01", pelanggan1);

        // 4. Membeli Obat (Sesuai & Melebihi Stok)
        System.out.println("\n--- Proses Penambahan Item ---");
        trx.tambahObat(obat1, 3);  // Paracetamol
        trx.tambahObat(obat2, 2);  // Amoxicillin
        trx.tambahObat(obat2, 15); // Uji coba jika melebihi stok

        // 5. Cetak Struk Sebelum Pembayaran
        trx.cetakStruk();

        // 6. Proses Pembayaran
        System.out.println("\n--- Proses Pembayaran ---");
        trx.prosesPembayaran(30000); // Pembayaran gagal (kurang)
        trx.prosesPembayaran(50000); // Pembayaran berhasil

        // 7. Cetak Struk Akhir
        trx.cetakStruk();

        // 8. Cek Sisa Stok Obat
        System.out.println("\n--- Sisa Stok Obat Saat Ini ---");
        System.out.println(obat1.getNamaObat() + " : " + obat1.getStok());
        System.out.println(obat2.getNamaObat() + " : " + obat2.getStok());
    }
}
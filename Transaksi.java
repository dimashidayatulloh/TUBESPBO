package TUBESPBO;

import java.util.ArrayList;
import java.util.List;

public class Transaksi {
    private Pelanggan pelanggan;
    private Kasir kasir;
    private List<ItemTransaksi> items;
    private double totalHarga;

    public Transaksi(Pelanggan pelanggan, Kasir kasir) {
        this.pelanggan = pelanggan;
        this.kasir = kasir;
        this.items = new ArrayList<>();
        this.totalHarga = 0;
    }

    public void tambahProduk(Produk produk, int jumlah) {
        for (ItemTransaksi item : items) {
            if (item.getProduk().getId() == produk.getId()) {
                item.setJumlah(item.getJumlah() + jumlah);
                return;
            }
        }
        items.add(new ItemTransaksi(produk, jumlah));
    }

    public void hapusProduk(int idProduk) {
        items.removeIf(item -> item.getProduk().getId() == idProduk);
    }

    public void hitungTotal() {
        totalHarga = 0;
        for (ItemTransaksi item : items) {
            totalHarga += item.getTotalHarga();
        }
    }

    public void cetakStruk() {
        System.out.println("Struk Pembelian:");
        System.out.println("Pelanggan: " + pelanggan.getNama());
        System.out.println("Kasir: " + kasir.getNama());
        System.out.println("Daftar Produk:");
        for (ItemTransaksi item : items) {
            System.out.println(" - " + item.getProduk().getNama() + " (x" + item.getJumlah() + "): Rp " + item.getProduk().getHarga() + " x " + item.getJumlah() + " = Rp " + item.getTotalHarga());
        }
        System.out.println("Total Harga: Rp " + totalHarga);
    }

    // setter & getter
    public List<ItemTransaksi> getItems() {
        return items;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public Kasir getKasir() {
        return kasir;
    }
}

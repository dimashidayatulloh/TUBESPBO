package TUBESPBO;

import java.util.HashMap;
import java.util.Map;

public class Transaksi {
    private Pelanggan pelanggan;
    private Kasir kasir;
    private Map<Produk, Integer> produks;
    private double totalHarga;

    public Transaksi(Pelanggan pelanggan, Kasir kasir) {
        this.pelanggan = pelanggan;
        this.kasir = kasir;
        this.produks = new HashMap<>();
        this.totalHarga = 0;
    }

    public void tambahProduk(Produk produk, int jumlah) {
        if (produks.containsKey(produk)) {
            produks.put(produk, produks.get(produk) + jumlah);
        } else {
            produks.put(produk, jumlah);
        }
    }

    public void hapusProduk(Produk produk) {
        if (produks.containsKey(produk)) {
            produks.remove(produk);
        }
    }

    public void hitungTotal() {
        totalHarga = 0;
        for (Map.Entry<Produk, Integer> entry : produks.entrySet()) {
            totalHarga += entry.getKey().getHarga() * entry.getValue();
        }
    }

    public void cetakStruk() {
        System.out.println("Struk Pembelian:");
        System.out.println("Pelanggan: " + pelanggan.getNama());
        System.out.println("Kasir: " + kasir.getNama());
        System.out.println("Daftar Produk:");
        for (Map.Entry<Produk, Integer> entry : produks.entrySet()) {
            System.out.println(" - " + entry.getKey().getNama() + " (x" + entry.getValue() + "): Rp " + entry.getKey().getHarga() + " x " + entry.getValue() + " = Rp " + (entry.getKey().getHarga() * entry.getValue()));
        }
        System.out.println("Total Harga: Rp " + totalHarga);
    }

    // setter & getter
    public Map<Produk, Integer> getProduks() {
        return produks;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

}

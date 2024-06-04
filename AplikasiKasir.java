package TUBESPBO;

import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiKasir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Daftar produk yang tersedia di toko
        ArrayList<Produk> daftarProduk = new ArrayList<>();
        daftarProduk.add(new Produk(1, "Buku Tulis", 5000));
        daftarProduk.add(new Produk(2, "Pensil", 2000));
        daftarProduk.add(new Produk(3, "Penghapus", 1000));
        daftarProduk.add(new Produk(4, "Penggaris", 3000));

        // Input Pelanggan
        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = scanner.nextLine();
        Pelanggan pelanggan = new Pelanggan(namaPelanggan);

        // Input Kasir
        System.out.print("Masukkan nama kasir: ");
        String namaKasir = scanner.nextLine();
        Kasir kasir = new Kasir(namaKasir);

        // Buat Transaksi
        Transaksi transaksi = new Transaksi(pelanggan, kasir);

        boolean running = true;
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Hapus Produk");
            System.out.println("3. Cetak Struk");
            System.out.println("4. Keluar");
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan id produk: ");
                    int idProduk = scanner.nextInt();
                    System.out.print("Masukkan jumlah produk: ");
                    int jumlahProduk = scanner.nextInt();
                    scanner.nextLine();

                    // Cari produk berdasarkan id
                    boolean produkDitemukan = false;
                    for (Produk produk : daftarProduk) {
                        if (produk.getId() == idProduk) {
                            transaksi.tambahProduk(produk, jumlahProduk);
                            produkDitemukan = true;
                            break;
                        }
                    }

                    if (!produkDitemukan) {
                        System.out.println("Produk dengan id " + idProduk + " tidak ditemukan.");
                    } else {
                        System.out.println("Produk berhasil ditambahkan.");
                    }
                    break;
                case 2:
                    System.out.print("Masukkan id produk yang ingin dihapus: ");
                    int idProdukHapus = scanner.nextInt();
                    scanner.nextLine();

                    transaksi.hapusProduk(idProdukHapus);
                    System.out.println("Produk berhasil dihapus.");
                    break;
                case 3:
                    transaksi.hitungTotal();
                    transaksi.cetakStruk();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih lagi.");
                    break;
            }
        }

        scanner.close();
    }
}

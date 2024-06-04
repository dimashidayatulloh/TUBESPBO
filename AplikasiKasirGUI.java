package TUBESPBO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AplikasiKasirGUI {
    private static ArrayList<Produk> daftarProduk = new ArrayList<>();
    private static Transaksi transaksi;
    private static JTextArea strukArea;

    public static void main(String[] args) {
        // Daftar produk yang tersedia di toko
        daftarProduk.add(new Produk(1, "Buku Tulis", 5000));
        daftarProduk.add(new Produk(2, "Pensil", 2000));
        daftarProduk.add(new Produk(3, "Penghapus", 1000));
        daftarProduk.add(new Produk(4, "Penggaris", 3000));

        // Create and set up the window.
        JFrame frame = new JFrame("Aplikasi Kasir");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Panel for input data
        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        frame.add(inputPanel, BorderLayout.NORTH);

        // Input Pelanggan
        JLabel pelangganLabel = new JLabel("Nama Pelanggan:");
        JTextField pelangganField = new JTextField();
        inputPanel.add(pelangganLabel);
        inputPanel.add(pelangganField);

        // Input Kasir
        JLabel kasirLabel = new JLabel("Nama Kasir:");
        JTextField kasirField = new JTextField();
        inputPanel.add(kasirLabel);
        inputPanel.add(kasirField);

        // Text Area for Struk
        strukArea = new JTextArea();
        strukArea.setEditable(false);
        frame.add(new JScrollPane(strukArea), BorderLayout.CENTER);

        // Buttons
        JButton startButton = new JButton("Mulai Transaksi");
        JButton addButton = new JButton("Tambah Produk");
        JButton removeButton = new JButton("Hapus Produk");
        JButton printButton = new JButton("Cetak Struk");
        JButton exitButton = new JButton("Keluar");

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(printButton);
        buttonPanel.add(exitButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Event listeners
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String namaPelanggan = pelangganField.getText();
                String namaKasir = kasirField.getText();
                if (namaPelanggan.isEmpty() || namaKasir.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Nama pelanggan dan kasir harus diisi.");
                    return;
                }
                Pelanggan pelanggan = new Pelanggan(namaPelanggan);
                Kasir kasir = new Kasir(namaKasir);
                transaksi = new Transaksi(pelanggan, kasir);
                strukArea.setText("Transaksi dimulai.\n");
            }
        });

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (transaksi == null) {
                    JOptionPane.showMessageDialog(frame, "Mulai transaksi terlebih dahulu.");
                    return;
                }
                String idProdukStr = JOptionPane.showInputDialog(frame, "Masukkan id produk:");
                String jumlahProdukStr = JOptionPane.showInputDialog(frame, "Masukkan jumlah produk:");
                try {
                    int idProduk = Integer.parseInt(idProdukStr);
                    int jumlahProduk = Integer.parseInt(jumlahProdukStr);

                    boolean produkDitemukan = false;
                    for (Produk produk : daftarProduk) {
                        if (produk.getId() == idProduk) {
                            transaksi.tambahProduk(produk, jumlahProduk);
                            produkDitemukan = true;
                            break;
                        }
                    }

                    if (!produkDitemukan) {
                        JOptionPane.showMessageDialog(frame, "Produk dengan id " + idProduk + " tidak ditemukan.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Produk berhasil ditambahkan.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "ID dan jumlah produk harus berupa angka.");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (transaksi == null) {
                    JOptionPane.showMessageDialog(frame, "Mulai transaksi terlebih dahulu.");
                    return;
                }
                String idProdukStr = JOptionPane.showInputDialog(frame, "Masukkan id produk yang ingin dihapus:");
                try {
                    int idProduk = Integer.parseInt(idProdukStr);
                    transaksi.hapusProduk(idProduk);
                    JOptionPane.showMessageDialog(frame, "Produk berhasil dihapus.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "ID produk harus berupa angka.");
                }
            }
        });

        printButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (transaksi == null) {
                    JOptionPane.showMessageDialog(frame, "Mulai transaksi terlebih dahulu.");
                    return;
                }
                transaksi.hitungTotal();
                strukArea.setText("");  // Clear the area
                strukArea.append("Struk Pembelian:\n");
                strukArea.append("Pelanggan: " + transaksi.getPelanggan().getNama() + "\n");
                strukArea.append("Kasir: " + transaksi.getKasir().getNama() + "\n");
                strukArea.append("Daftar Produk:\n");
                for (ItemTransaksi item : transaksi.getItems()) {
                    strukArea.append(" - " + item.getProduk().getNama() + " (x" + item.getJumlah() + "): Rp " + item.getProduk().getHarga() + " x " + item.getJumlah() + " = Rp " + item.getTotalHarga() + "\n");
                }
                strukArea.append("Total Harga: Rp " + transaksi.getTotalHarga() + "\n");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Display the window.
        frame.setVisible(true);
    }
}

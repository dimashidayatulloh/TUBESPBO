package TUBESPBO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

public class AplikasiKasirGUI extends JFrame {
    private JTextField namaPelangganField;
    private JTextField namaKasirField;
    private JTextField idProdukField;
    private JTextField jumlahProdukField;
    private JTextArea outputArea;

    private Pelanggan pelanggan;
    private Kasir kasir;
    private Transaksi transaksi;
    private ArrayList<Produk> daftarProduk;

    public AplikasiKasirGUI() {
        setTitle("Aplikasi Kasir");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        daftarProduk = new ArrayList<>();
        daftarProduk.add(new Produk(1, "Buku Tulis", 5000));
        daftarProduk.add(new Produk(2, "Pensil", 2000));
        daftarProduk.add(new Produk(3, "Penghapus", 1000));
        daftarProduk.add(new Produk(4, "Penggaris", 3000));
        daftarProduk.add(new Produk(5, "Bolpen", 4000));
        daftarProduk.add(new Produk(6, "Stabilo", 6000));
        daftarProduk.add(new Produk(7, "Spidol", 5500));
        daftarProduk.add(new Produk(8, "Pensil Warna", 2500));
        daftarProduk.add(new Produk(9, "Kertas HVS", 7000));
        daftarProduk.add(new Produk(10, "Stapler", 8000));
        daftarProduk.add(new Produk(11, "Lem Kertas", 3500));
        daftarProduk.add(new Produk(12, "Selotip", 1500));
        daftarProduk.add(new Produk(13, "Gunting", 4500));
        daftarProduk.add(new Produk(14, "Penggaris Segitiga", 3200));
        daftarProduk.add(new Produk(15, "Kalkulator", 10000));
        daftarProduk.add(new Produk(16, "Binder", 9000));
        daftarProduk.add(new Produk(17, "Map Plastik", 2000));
        daftarProduk.add(new Produk(18, "Label", 1200));
        daftarProduk.add(new Produk(19, "Tinta Printer", 15000));
        daftarProduk.add(new Produk(20, "Kuas Lukis", 5500));
        daftarProduk.add(new Produk(21, "Penghapus Pensil", 800));
        daftarProduk.add(new Produk(22, "Kalkulator Sains", 12000));
        daftarProduk.add(new Produk(23, "Tipe-X", 1800));
        daftarProduk.add(new Produk(24, "Karbon Kertas", 2500));
        daftarProduk.add(new Produk(25, "Alas Potlak", 3000));
        daftarProduk.add(new Produk(26, "Pulpen", 3500));
        daftarProduk.add(new Produk(27, "Tipe-X Cair", 2300));
        daftarProduk.add(new Produk(28, "Kalkulator Finansial", 15000));
        daftarProduk.add(new Produk(29, "Binder Besar", 12000));
        daftarProduk.add(new Produk(30, "Spidol Permanen", 4000));
        daftarProduk.add(new Produk(31, "Kertas Fax", 8500));
        daftarProduk.add(new Produk(32, "Stiker Label", 2700));
        daftarProduk.add(new Produk(33, "Buku Catatan", 4800));
        daftarProduk.add(new Produk(34, "Pensil Mekanik", 3200));
        daftarProduk.add(new Produk(35, "Isi Pulpen", 2100));

        JPanel panelInput = new JPanel(new GridLayout(0, 2));
        panelInput.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Input pelanggan
        panelInput.add(new JLabel("Nama Pelanggan:"));
        namaPelangganField = new JTextField();
        panelInput.add(namaPelangganField);

        // Input kasir
        panelInput.add(new JLabel("Nama Kasir:"));
        namaKasirField = new JTextField();
        panelInput.add(namaKasirField);

        // Input produk
        panelInput.add(new JLabel("ID Produk:"));
        idProdukField = new JTextField();
        panelInput.add(idProdukField);

        panelInput.add(new JLabel("Jumlah Produk:"));
        jumlahProdukField = new JTextField();
        panelInput.add(jumlahProdukField);

        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelButtons.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Tombol tampilkan produk
        JButton tampilkanProdukButton = new JButton("Tampilkan Produk");
        panelButtons.add(tampilkanProdukButton);
        tampilkanProdukButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tampilkanProduk();
            }
        });

        // Tombol tambah produk
        JButton tambahProdukButton = new JButton("Tambah Produk");
        panelButtons.add(tambahProdukButton);
        tambahProdukButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tambahProduk();
            }
        });

        // Tombol hapus produk
        JButton hapusProdukButton = new JButton("Hapus Produk");
        panelButtons.add(hapusProdukButton);
        hapusProdukButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hapusProduk();
            }
        });

        // Tombol cetak struk
        JButton cetakStrukButton = new JButton("Cetak Struk");
        panelButtons.add(cetakStrukButton);
        cetakStrukButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cetakStruk();
            }
        });

        // Tombol mulai transaksi
        JButton mulaiTransaksiButton = new JButton("Mulai Transaksi");
        panelButtons.add(mulaiTransaksiButton);
        mulaiTransaksiButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mulaiTransaksi();
            }
        });

        // Area output
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(panelInput, BorderLayout.NORTH);
        contentPane.add(panelButtons, BorderLayout.CENTER);
        contentPane.add(scrollPane, BorderLayout.SOUTH);

        setContentPane(contentPane);
    }

    private void tampilkanProduk() {
        StringBuilder daftarProdukStr = new StringBuilder("Daftar Produk:\n");
        for (Produk produk : daftarProduk) {
            daftarProdukStr.append("ID: ").append(produk.getId())
                    .append(", Nama: ").append(produk.getNama())
                    .append(", Harga: Rp ").append(produk.getHarga()).append("\n");
        }
        JOptionPane.showMessageDialog(null, daftarProdukStr.toString(), "Daftar Produk", JOptionPane.INFORMATION_MESSAGE);
    }

    private void tambahProduk() {
        if (transaksi == null) {
            JOptionPane.showMessageDialog(null, "Silakan mulai transaksi terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idProduk = Integer.parseInt(idProdukField.getText());
            int jumlahProduk = Integer.parseInt(jumlahProdukField.getText());

            boolean produkDitemukan = false;
            for (Produk produk : daftarProduk) {
                if (produk.getId() == idProduk) {
                    transaksi.tambahProduk(produk, jumlahProduk);
                    produkDitemukan = true;
                    JOptionPane.showMessageDialog(null, "Produk berhasil ditambahkan.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }

            if (!produkDitemukan) {
                JOptionPane.showMessageDialog(null, "ID Produk tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            idProdukField.setText("");
            jumlahProdukField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID Produk dan Jumlah Produk harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void hapusProduk() {
        if (transaksi == null) {
            JOptionPane.showMessageDialog(null, "Silakan mulai transaksi terlebih dahulu.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idProduk = Integer.parseInt(idProdukField.getText());

            boolean produkDitemukan = false;
            for (Produk produk : daftarProduk) {
                if (produk.getId() == idProduk) {
                    transaksi.hapusProduk(produk);
                    produkDitemukan = true;
                    JOptionPane.showMessageDialog(null, "Produk berhasil dihapus.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }

            if (!produkDitemukan) {
                JOptionPane.showMessageDialog(null, "ID Produk tidak ditemukan.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            idProdukField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "ID Produk harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cetakStruk() {
        if (transaksi == null) {
            JOptionPane.showMessageDialog(null, "Tidak ada transaksi yang sedang berlangsung.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        transaksi.hitungTotal();
        StringBuilder struk = new StringBuilder();
        struk.append("Struk Pembelian:\n");
        struk.append("Pelanggan: ").append(pelanggan.getNama()).append("\n");
        struk.append("Kasir: ").append(kasir.getNama()).append("\n");
        struk.append("Daftar Produk:\n");
        for (Map.Entry<Produk, Integer> entry : transaksi.getProduks().entrySet()) {
            struk.append(" - ").append(entry.getKey().getNama()).append(" (x").append(entry.getValue()).append("): Rp ")
                    .append(entry.getKey().getHarga()).append(" x ").append(entry.getValue()).append(" = Rp ")
                    .append(entry.getKey().getHarga() * entry.getValue()).append("\n");
        }
        struk.append("\n");
        struk.append("Total Harga: Rp ").append(transaksi.getTotalHarga()).append("\n");

        JOptionPane.showMessageDialog(null, struk.toString(), "Struk Pembelian", JOptionPane.INFORMATION_MESSAGE);
    }

    private void mulaiTransaksi() {
        String namaPelanggan = namaPelangganField.getText();
        String namaKasir = namaKasirField.getText();

        if (namaPelanggan.isEmpty() || namaKasir.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama pelanggan dan nama kasir harus diisi.", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            pelanggan = new Pelanggan(namaPelanggan);
            kasir = new Kasir(namaKasir);
            transaksi = new Transaksi(pelanggan, kasir);

            JOptionPane.showMessageDialog(null, "Transaksi dimulai.", "Informasi", JOptionPane.INFORMATION_MESSAGE);

            namaPelangganField.setText("");
            namaKasirField.setText("");
            idProdukField.setText("");
            jumlahProdukField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new AplikasiKasirGUI().setVisible(true);
            }
        });
    }
}

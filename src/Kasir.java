/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rhnfa
 */
public class Kasir {
    private Barang[] daftarBarang;
    private int jumlahBarang;

    // Constructor
    public Kasir(int kapasitas) {
        daftarBarang = new Barang[kapasitas];
        jumlahBarang = 0;
    }

    // Method untuk menambahkan barang ke dalam daftar
    public void tambahBarang(Barang barang) {
        if (jumlahBarang < daftarBarang.length) {
            daftarBarang[jumlahBarang] = barang;
            jumlahBarang++;
        } else {
            System.out.println("Daftar barang sudah penuh!");
        }
    }

    // Method untuk mencetak struk
    public void cetakStruk() {
        double total = 0;
        System.out.println("\n===== Struk Pembelian =====");
            for (int i = 0; i < jumlahBarang; i++) {
                Barang barang = daftarBarang[i];
                System.out.println(barang.getNama() + " - " + barang.getJumlah() + " x " + barang.getHarga() + " = " + barang.hitungTotalHarga());
                total += barang.hitungTotalHarga();
            }
        // Pemberian diskon jika total melebihi 1.000.000
        if (total > 1000000) {
            System.out.println("Anda mendapatkan diskon 10%!");
            total *= 0.9;
        }
        System.out.println("===========================");
        System.out.println("Total: " + total);
    }

}

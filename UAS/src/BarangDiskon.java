/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rhnfa
 */
public class BarangDiskon extends Barang{
    private double diskon;

    // Constructor
    public BarangDiskon(String nama, double harga, int jumlah, double diskon) {
        super(nama, harga, jumlah);
        this.diskon = diskon;
    }

    // Overriding method untuk menghitung total harga barang dengan diskon
    @Override
    public double hitungTotalHarga() {
        return super.hitungTotalHarga() * (1 - diskon);
    }
 
}

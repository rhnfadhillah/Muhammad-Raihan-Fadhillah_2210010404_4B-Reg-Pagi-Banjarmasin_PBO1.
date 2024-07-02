
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rhnfa
 */
public class KasirBeraksi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for the capacity of the cash register
        System.out.print("Masukkan total barang: ");
        int kapasitas = scanner.nextInt();

        Kasir kasir = new Kasir(kapasitas);
        int kapasitasAwal = 0;

        while (kapasitasAwal < kapasitas) {
            System.out.println("\n===========================");
            System.out.println("Pilih jenis barang:");
            System.out.println("1. Barang biasa");
            System.out.println("2. Barang dengan diskon khusus");
            System.out.println("3. Selesai dan cetak struk");
            System.out.print("Masukkan Pilihan : ");
            int pilihan;
            try {
                pilihan = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Error : Pilihan invalid! Masukkan angka!");
                scanner.next(); // discard invalid input
                continue;
            }
            
            if (pilihan == 3) {
                break;
            }

            System.out.print("Nama barang: ");
            String nama = scanner.next();

            System.out.print("Harga barang: ");
            double harga = scanner.nextDouble();

            System.out.print("Jumlah barang: ");
            int jumlah = scanner.nextInt();

            if (pilihan == 1) {
                Barang barang = new Barang(nama, harga, jumlah);
                kasir.tambahBarang(barang);
            } else if (pilihan == 2) {
                System.out.print("Diskon (misal 0.1 untuk 10%): ");
                double diskon = scanner.nextDouble();
                BarangDiskon barang = new BarangDiskon(nama, harga, jumlah, diskon);
                kasir.tambahBarang(barang);
            }
            kapasitasAwal ++;
        }

        // Mencetak struk
        kasir.cetakStruk();

        // Menutup scanner
        scanner.close();
        
    }

}


# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi Kasir menggunakan Java sebagai proyek tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi
Aplikasi ini menerima input berupa kapasitas kasir, pilihan menu, nama barang, jumlah barang dan harga barang, dan memberikan output berupa informasi dari nama barang, jumlah, dan harga barang serta total dari jumlah di kalikan dengan harga barang.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overloading, Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Barang`, `BarangDiskon`, `Kasir` dan `KasirBeraksi` adalah contoh dari class.

```bash
public class Barang {
    ...
}

public class BarangDiskon extends Barang {
    ...
}

public class Kasir{
    ...
}

public class KasirBeraksi {
    ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, `Kasir kasir = new Kasir(kapasitas);`, `Barang barang = new Barang(nama, harga, jumlah);`, `BarangDiskon barang = new BarangDiskon(nama, harga, jumlah, diskon);`, 
`daftarBarang = new Barang[kapasitas];` adalah contoh pembuatan object.

```bash
//Pemanggilan object pada class KasirBeraksi
Kasir kasir = new Kasir(kapasitas);
Barang barang = new Barang(nama, harga, jumlah);
BarangDiskon barang = new BarangDiskon(nama, harga, jumlah, diskon);

//Pemanggilan object pada class Kasir
daftarBarang = new Barang[kapasitas];
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `nama`, `harga`, dan `jumlah` adalah contoh atribut.

```bash
    private String nama;
    private double harga;
    private int jumlah;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `Barang`, `BarangDiskon`, dan `Kasir`.

```bash
public Barang(String nama, double harga, int jumlah) {
        this.nama = nama;
        this.harga = harga;
        this.jumlah = jumlah;
}

public BarangDiskon(String nama, double harga, int jumlah, double diskon) {
        super(nama, harga, jumlah);
        this.diskon = diskon;
}

public Kasir(int kapasitas) {
        daftarBarang = new Barang[kapasitas];
        jumlahBarang = 0;
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setNama`, `setHarga`, dan `setJumlah` adalah contoh method mutator.

```bash
// Mutator (Setter)
public void setNama(String nama) {
    this.nama = nama;
}

public void setHarga(double harga) {
    this.harga = harga;
}

public void setJumlah(int jumlah) {
    this.jumlah = jumlah;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getNama`, `getHarga`, dan `getJumlah` adalah contoh method accessor.

```bash
// Accessor (Getter)
public String getNama() {
    return nama;
}

public double getHarga() {
    return harga;
}

public int getJumlah() {
    return jumlah;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut `nama`, `harga`, dan `jumlah` dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```bash
private String nama;
private double harga;
private int jumlah;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `BarangDiskon` mewarisi `Barang` dengan sintaks `extends`.

```bash
public class BarangDiskon extends Barang{
   ....
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, method `hitungTotalHarga` di `BarangDiskon` merupakan overriding method `hitungTotalHarga` di `Barang`.

```bash
public double hitungTotalHarga() {
    return harga * jumlah;
}

@Override
public double hitungTotalHarga() {
    return super.hitungTotalHarga() * (1 - diskon);
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `if else` dalam method `tambahBarang`, `cetakStruk` dan `Main`.

```bash
//Method tambahBarang
public void tambahBarang(Barang barang) {
    if (jumlahBarang < daftarBarang.length) {
        daftarBarang[jumlahBarang] = barang;
        jumlahBarang++;
    } else {
        System.out.println("Daftar barang sudah penuh!");
    }
}

//Method cetakStruk
public void cetakStruk() {
    double total = 0;
    System.out.println("===== Struk Pembelian =====");
    for (int i = 0; i < jumlahBarang; i++) {
        Barang barang = daftarBarang[i];
        System.out.println(barang.getNama() + " - " + barang.getJumlah() + " x " + barang.getHarga() + " = " + barang.hitungTotalHarga());
        total += barang.hitungTotalHarga();
    }
    if (total > 1000000) {
        System.out.println("Anda mendapatkan diskon 10%!");
        total *= 0.9;
    }
    System.out.println("===========================");
    System.out.println("Total: " + total);
}

//Method Main
public static void main(String[] args) {
if (pilihan == 1) {
    Barang barang = new Barang(nama, harga, jumlah);
    kasir.tambahBarang(barang);
} else if (pilihan == 2) {
    System.out.print("Diskon (misal 0.1 untuk 10%): ");
    double diskon = scanner.nextDouble();
    BarangDiskon barang = new BarangDiskon(nama, harga, jumlah, diskon);
    kasir.tambahBarang(barang);
} else {
    System.out.println("Pilihan tidak valid!");
}
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `for` dan `while` untuk meminta input dan menampilkan data.

```bash
for (int i = 0; i < jumlahBarang; i++) {
        ....
}

while (count < kapasitas) {
    ....
}
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` untuk menampilkan output.

```bash
System.out.println("\n===========================");
System.out.println("Pilih jenis barang:");
System.out.println("1. Barang biasa");
System.out.println("2. Barang dengan diskon khusus");
System.out.println("3. Selesai dan cetak struk");
System.out.print("Masukkan Pilihan : ");
int pilihan = scanner.nextInt();
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `daftarBarang = new Barang[kapsitas]` adalah contoh penggunaan array.

```bash
 public Kasir(int kapasitas) {
        daftarBarang = new Barang[kapasitas];
        jumlahBarang = 0;
}
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try catch` untuk menangani error.

```bash
try {
    pilihan = scanner.nextInt();
} catch (Exception e) {
    System.out.println("Error : Pilihan invalid! Masukkan angka!");
    scanner.next();
    continue;
}
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Muhammad Raihan Fadhillah
NPM: 2210010404

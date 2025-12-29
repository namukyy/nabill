/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

/**
 *
 * @author ACER
 */
import java.util.Scanner;

abstract class Penumpang {
    protected String nama;
    protected String noTiket;

    public Penumpang(String nama, String noTiket) {
        this.nama = nama;
        this.noTiket = noTiket;
    }

    // ABSTRACT METHOD 
    public abstract double hitungHargaTiket();

    // METHOD ASLI
    public void tampilkanData() {
        System.out.println("Nama        : " + nama);
        System.out.println("No Tiket    : " + noTiket);
        System.out.println("Harga Tiket : Rp " + hitungHargaTiket());
    }

    // === TAMBAHAN (OVERLOADING) ===
    public void tampilkanData(String jenis) {
        System.out.println("Jenis Penumpang : " + jenis);
        tampilkanData();
    }
}

// ================== PENUMPANG REGULER ==================
class PenumpangReguler extends Penumpang {
    public PenumpangReguler(String nama, String noTiket) {
        super(nama, noTiket);
    }

    // === TAMBAHAN (OVERRIDING) ===
    @Override
    public double hitungHargaTiket() {
        return 100000;
    }
}

// ================== PENUMPANG VIP ==================
class PenumpangVIP extends Penumpang {
    public PenumpangVIP(String nama, String noTiket) {
        super(nama, noTiket);
    }

    // === TAMBAHAN (OVERRIDING) ===
    @Override
    public double hitungHargaTiket() {
        return 150000;
    }
}

// ================== INPUT ==================
class InputPenumpang {
    protected Scanner input = new Scanner(System.in);
}

// ================== MAIN ==================
class Main extends InputPenumpang {
    public static void main(String[] args) {
        Main m = new Main();

        System.out.print("Masukkan Nama Penumpang : ");
        String nama = m.input.nextLine();

        System.out.print("Masukkan No Tiket       : ");
        String noTiket = m.input.nextLine();

        System.out.print("Jenis Penumpang (1=Reguler, 2=VIP): ");
        int pilihan = m.input.nextInt();

        Penumpang penumpang;

        if (pilihan == 1) {
            penumpang = new PenumpangReguler(nama, noTiket);
            penumpang.tampilkanData("Reguler");
        } else {
            penumpang = new PenumpangVIP(nama, noTiket);
            penumpang.tampilkanData("VIP");
        }
    }
}


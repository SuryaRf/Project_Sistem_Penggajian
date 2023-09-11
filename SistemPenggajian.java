import java.util.Scanner;

class Karyawan {
    private String nama;
    private int gaji;

    public Karyawan(String nama, int gaji) {
        this.nama = nama;
        this.gaji = gaji;
    }

    public String getNama() {
        return nama;
    }

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    @Override
    public String toString() {
        return "Nama: " + nama + ", Gaji: " + gaji;
    }
}

public class SistemPenggajian {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Membuat objek karyawan
        Karyawan karyawan = new Karyawan("John Doe", 5000000);
        Karyawan karyawan2 = new Karyawan("Ahmad zaki", 9000000);
        

        while (true) {
            System.out.println("Sistem Penggajian");
            System.out.println("1. Lihat Informasi Karyawan");
            System.out.println("2. Ubah Gaji Karyawan");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");

            int pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.println(" ");
                System.out.println("Informasi Karyawan:");
                    System.out.println(" ");
                    System.out.println(karyawan);
                    System.out.println(" ");
                    System.out.println(karyawan2);
                    System.out.println(" ");
                    break;
                case 2:
                    System.out.print("Masukkan gaji baru: ");
                    int gajiBaru = input.nextInt();
                    karyawan.setGaji(gajiBaru);
                    System.out.println("Gaji berhasil diubah.");
                    break;
                case 3:
                    System.out.println("Terima kasih!");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
}

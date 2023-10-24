import java.util.Date;
import java.util.Scanner;
public class penggajian {
        static Date tanggal = new Date();
        static Scanner sc = new Scanner(System.in);
        static String[] nama = new String [100];
        static String[] golongan = new String [100];
        static String[] jeniskelamin = new String [100];
        static int[] totalGaji = new int [100];
        static int[] jamLembur = new int [100];
        
        static int hitungPegawai, gajiPokok, tunjangan, lembur = 10000, gajiLembur, pajak = 0;
    public static void main (String[] args) {
        int menu;
        while(true){
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^+");
        System.out.println("|    * PILIHAN MENU *     |");
        System.out.println("+^^^^^^^^^^^^^^^^^^^^^^^^^+");
        System.out.println("| [1] Data Pegawai        |");
        System.out.println("| [2] Perhitungan Gaji    |");
        System.out.println("| [3] Cetak Slip Gaji     |");
        System.out.println("| [4] Pencarian           |");
        System.out.println("| [5] Laporan             |");
        System.out.println("| [6] Keluar              |");
        System.out.println("+-------------------------+"); 
        System.out.print("Masukkan menu pilihan anda: "); 
        menu = sc.nextInt(); 
        if(menu == 1){
            //data pegawai
            dataPegawai();
        }else if(menu == 2){
            //hitung gaji
            String z;
            System.out.println("+-----------------------------------------------------------+");
            System.out.println("+              Perhitungan Gaji Karyawan+                   +");
            System.out.println("+-----------------------------------------------------------+");
            System.out.print("Masukan Nama pegawai : ");
            String nama2 = sc.nextLine();
            nama2 = sc.nextLine();
            
            for(int i = 0; i <= hitungPegawai; i++){
                if(nama[i].equalsIgnoreCase (nama2)){
                    perhitungan(i);
                    cekPajak(i);
                    System.out.println("Total gaji adalah " + totalGaji[i] );
                    break;
                }else if (i == hitungPegawai){
                    System.out.println("Nama yang anda masukan tidak terdaftar!");
                }
            }
            
        }else if(menu == 3){
            //cetak slip

            System.out.println("+-----------------------------------------------------------+");
            System.out.println("+                     Cetak Slip Gaji+                      +");
            System.out.println("+-----------------------------------------------------------+");
            System.out.print("Masukan Nama pegawai : ");
            String nama2 = sc.nextLine();
            nama2 = sc.nextLine();
            for(int i = 0; i <= hitungPegawai; i++){
                if(nama[i].equalsIgnoreCase (nama2)){ 
                    cetakSlip(i);
                    break;
                }else if(i == hitungPegawai){
                    System.out.println("Nama yang anda masukan tidak terdaftar!");
                }
            }
            
        }else if(menu == 4){
            //pencarian
            pencarian();
        }else if(menu == 5){
            //laporan
            pelaporan();
        }else if(menu == 6) break;
        }
    }
    
    static void dataPegawai(){
        int kode = 0;
        do{
        System.out.println("[1] Input Data Pegawai ");
        System.out.println("[2] Tampil Data Pegawai");
        System.out.println("[3] Edit Data Pegawai");
        System.out.println("[4] Data Jumlah Pegawai");
        System.out.println("[5] Kembali");
        System.out.print("Masukan pilihan : ");
        kode = sc.nextInt();
        sc.nextLine();
        if(kode == 1){
        for(int j = 0;true; j++){
                System.out.print("Nama Pegawai\t: ");
                nama[j] = sc.nextLine();
                System.out.print("Jenis kelamin (P/L) : ");
                String jenisK = sc.nextLine();
                

                System.out.println("Untuk Golongan :");
                System.out.println("A = Pengawai Paruh waktu");
                System.out.println("B = Pengawai Magang");
                System.out.println("C = Pengawai Tetap");
                System.out.println("D = manajer");

                System.out.print("Masukan Golongan (A-D) : ");
                golongan[j] = sc.nextLine();
                System.out.print("Masukan Waktu lembur (jam) : ");
                jamLembur[j] = sc.nextInt();
                System.out.print("lanjut ? (Y/N) : ");
                String lanjut = sc.nextLine();
                lanjut = sc.nextLine();

                if(jenisK.equalsIgnoreCase("p")){
                    jeniskelamin[j] = "Perempuan";
                }else if (jenisK.equalsIgnoreCase("l")){
                    jeniskelamin[j] = "Laki-laki";
                }
                if (lanjut.equalsIgnoreCase("n")) {
                    break;
                }
               
                hitungPegawai++;
            }
        }
        if(kode == 2){
            for(int i = 0; i <= hitungPegawai; i++){
            System.out.println("+---------------------------------+");
            System.out.println("Nama Pegawai\t: " + nama[i]);
            System.out.println("Golongan Pegawai: " + golongan[i]);
            System.out.println("Jenis Kelamin\t: " + jeniskelamin[i]);
            System.out.println("+---------------------------------+");
            }
        }else if(kode == 3){
            System.out.print("Masukan Nama pegawai : ");
            String nama2 = sc.nextLine();
            for(int i = 0; i <= hitungPegawai; i++){
                if(nama[i].equalsIgnoreCase (nama2)){ 
                    System.out.print("Nama Pegawai\t: ");
                    nama[i] = sc.nextLine();
                    System.out.print("Jenis kelamin (P/L) : ");
                    String jenisK = sc.nextLine();
                    
    
                    System.out.println("Untuk Golongan :");
                    System.out.println("A = Pengawai Paruh waktu");
                    System.out.println("B = Pengawai Magang");
                    System.out.println("C = Pengawai Tetap");
                    System.out.println("D = manajer");
    
                    System.out.print("Masukan Golongan (A-D) : ");
                    golongan[i] = sc.nextLine();
                    System.out.print("Masukan Waktu lembur (jam) : ");
                    jamLembur[i] = sc.nextInt();
                    
    
                    if(jenisK.equalsIgnoreCase("p")){
                        jeniskelamin[i] = "Perempuan";
                    }else if (jenisK.equalsIgnoreCase("l")){
                        jeniskelamin[i] = "Laki-laki";
                    }

                    break;
                }else if(i == hitungPegawai){
                    System.out.println("Nama yang anda masukan tidak terdaftar!");
                }
            }
        }else if(kode == 4){
            int paruhWaktu = 0, magang = 0, tetap = 0, manajer = 0;
            for(int i = 0; i <= hitungPegawai; i++){
                if(golongan[i].equalsIgnoreCase("a")){
                    paruhWaktu++;
                }else if(golongan[i].equalsIgnoreCase("b")){
                    magang++;
                }else if(golongan[i].equalsIgnoreCase("c")){
                    tetap++;
                }else if(golongan[i].equalsIgnoreCase("d")){
                    manajer++;
                }
            }
            System.out.println("+-----------------------------------------------------------+");
            System.out.println("+                      Jumlah Karyawan                      +");
            System.out.println("+-----------------------------------------------------------+");
            System.out.println("Jumlah Pegawai Paruh Waktu : " + paruhWaktu + " orang." );
            System.out.println("Jumlah Pegawai Magang : " +magang+ " orang,");
            System.out.println("Jumlah Pegawai Tetap : " +tetap+ " orang,");
            System.out.println("Jumlah Manajer : " +manajer+ " orang,");
            System.out.println("+-----------------------------------------------------------+");
            System.out.println("Total Jumlah Pegawai : " + (hitungPegawai+1) + " orang,");
            
        }
        }while(kode!=5); 
    }
        

        
    static void perhitungan(int x) {
        if(golongan[x].equalsIgnoreCase("a")){
            gajiPokok = 1000000;
            tunjangan = 500000;
        }else if(golongan[x].equalsIgnoreCase("b")){
            gajiPokok = 1500000;
            tunjangan = 700000;
        }else if(golongan[x].equalsIgnoreCase("c")){
            gajiPokok = 2000000;
            tunjangan = 900000;
        }else if(golongan[x].equalsIgnoreCase("d")){
            gajiPokok = 2500000;
            tunjangan = 1200000;
        }

 
            gajiLembur = jamLembur[x]*lembur;
            totalGaji[x] = (gajiPokok + tunjangan + gajiLembur);
           
        }

    static void cekPajak(int x){
        if(totalGaji[x] > 450000){
            pajak = 5;
        }else if(totalGaji[x] > 1250000){
            pajak = 15;
        }else if(totalGaji[x] > 2050000){
            pajak = 25;
        }

        int totalPajak = totalGaji[x] * pajak / 100;
        totalGaji[x]-=totalPajak;
    }
        
    static void cetakSlip(int x){
        
        perhitungan(x);
        cekPajak(x);
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                     Slip Gaji Karyawan                    +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.print("Tanggal              : ");
        System.out.println(tanggal);
        System.out.println("Nama                 : "+ nama[x]);
        System.out.println("Gaji Pokok           : "+ gajiPokok);
        System.out.println("Gaji Lembur          : "+ gajiLembur);
        System.out.println("Tunjangan            : "+ tunjangan);
        System.out.println("Pajak                : "+ pajak+ "%");
        System.out.println("Gaji Diterima        : "+ totalGaji[x]);
    }
    static void pencarian(){
        System.out.println("[1] Cari berdasarkan nama ");
        System.out.println("[2] Cari berdasarkan nomor karyawan");
        System.out.println("[3] Batal");
        System.out.print("Masukan pilihan : ");
        int masukan = sc.nextInt();
        sc.nextLine();
        int cari = 0;
        
        if(masukan == 1){
            System.out.print("Masukan Nama : ");
            String nama2 = sc.nextLine();
            for(int i = 0; i<= hitungPegawai; i++){
                if(nama[i].equalsIgnoreCase (nama2)){
                    System.out.println("       Hasil Pencarian      ");
                    System.out.println("Nama Karyawan     : "+ nama[i]);
                    System.out.println("Golongan          : "+golongan[i]);
                    System.out.println("Nomor Karyawan    : "+ i);
                    break;
                }else if(i == hitungPegawai){
                    System.out.println("Nama yang anda cari tidak terdaftar!");
                }
            }
        }else if(masukan == 2){
            System.out.print("Masukan Nonor Karyawan : ");
            cari = sc.nextInt();
            System.out.println("       Hasil Pencarian      ");
            System.out.println("Nama Karyawan     : "+ nama[cari]);
            System.out.println("Golongan          : "+ golongan[cari]);
            System.out.println("Nomor Karyawan    : "+ cari);
        }
        
    }
    static void pelaporan () {
        int i = 0;
        int pengeluaran = 0;
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                 Laporan Pengeluaran Gaji                  +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.print("Tanggal : ");
        System.out.println(tanggal);
        System.out.println();
        System.out.println();

        for(int j = 0; j <= hitungPegawai; j++){
            perhitungan(j);
            System.out.println("+------------------------------+");
            System.out.println("Nama Pegawai\t: " + nama[j]);
            System.out.println("Jenis kelamin : " + jeniskelamin[j]);
            System.out.println("Golongan Pegawai: " + golongan[j]);
            System.out.println("Waktu lembur : " + jamLembur[j] + " jam");
            System.out.println("Gaji Pegawai = " + totalGaji[j]);
            System.out.println("+------------------------------+");
            pengeluaran += totalGaji[j];
        }
        System.out.println("Jadi Total Pengeluaran Perusahan Untuk Gaji Seluruh Karyawan = "+ pengeluaran);        
        
    }
} 
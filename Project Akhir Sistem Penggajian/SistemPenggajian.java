import java.util.Scanner;
import java.util.Date;

public class SistemPenggajian {
    // global variable

    static Scanner sc = new Scanner(System.in);
    static Date tanggal = new Date();
    static boolean menuProcess, mainProcess, validationAdmin, validationKaryawan;
    static String status, yesNo, jK;
    static String golongan[] = new String[2];
    static String jenisKelamin[] = new String[2];
    static int jamLembur[] = new int[2];
    static String[][] userMain = { { "admin", "karyawan" }, { "123", "456" } };
    static String[][] getUser = new String[2][2];
    static int menu;
    static String[] nama = new String[100];
    static int hitungPegawai, gajiPokok, tunjangan, lembur = 10000, gajiLembur, pajak = 0;

    // validation Admin function
    static boolean validationAdmin(String username, String password) {
        return username.equals(userMain[0][0]) && password.equals(userMain[1][0]);
    }

    // validation Karyawan function
    static boolean validationKaryawan(String username, String password) {
        return username.equals(userMain[0][1]) && password.equals(userMain[1][1]);
    }

    // login page admin function
    static void loginPageAdmin() {
        System.out.println("===========================");
        System.out.println("        * LOGIN *          ");
        System.out.println("===========================");

        System.out.print("Masukan username : ");
        getUser[0][0] = sc.nextLine();
        System.out.print("Masukan Password : ");
        getUser[1][0] = sc.nextLine();
        validationAdmin = validationAdmin(getUser[0][0], getUser[1][0]);

    }

    // login page karywan
    static void loginKaryawan() {
        validationKaryawan = validationKaryawan(getUser[0][0], getUser[1][0]);
    }

    // data karyawan function
    static void dataKaryawan(){
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
                    jenisKelamin[j] = "Perempuan";
                }else if (jenisK.equalsIgnoreCase("l")){
                    jenisKelamin[j] = "Laki-laki";
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
            System.out.println("Jenis Kelamin\t: " + jenisKelamin[i]);
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
                        jenisKelamin[i] = "Perempuan";
                    }else if (jenisK.equalsIgnoreCase("l")){
                        jenisKelamin[i] = "Laki-laki";
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

    // // show data function
    // static void showData(){
    // System.out.println("\n======================== Data Employee
    // ========================");
    // System.out.println("| No | Nama | Jabatan | Gaji Pokok | Tunjangan | Bonus
    // Lembur | Potongan |");
    // for (int i = 0; i < dataEmploy.length; i++) {
    // if (frameDataEmploy[i][0] != null) {
    // System.out.printf("| %-2d | %-8s | %-12s | %-12s | %-11s | %-12s | %-10s
    // |\n", (i + 1), frameDataEmploy[i][0], frameDataEmploy[i][1],
    // frameDataEmploy[i][2], frameDataEmploy[i][3], frameDataEmploy[i][4],
    // frameDataEmploy[i][5]);

    // }

    // }
    // }

    // delete data function
    static void deleteData() {

    }

    // ada masalah ketika set frame di masukin , data input array ga masuk

    public static void main(String[] args) {
        // setFrame();
        String line = "===========================================";
        System.out.printf("%s\n\t     NELONGSO PAYROLL \n%s", line, line);
        mainProcess = true;
        while (mainProcess) {
            System.out.println("\nPLEASE LOGIN TO CONTINUE ACCESS THE PROGRAM \n1. Login \n2. Exit Program");
            System.out.print("Choose menu 1 - 2 : ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    menuProcess = true;
                    loginPageAdmin();
                    if (validationAdmin) {
                        System.out.println("\nWelcome Admin!");
                        while (menuProcess) {
                            System.out.println("+^^^^^^^^^^^^^^^^^^^^^^^^^+");
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
                            sc.nextLine();
                            switch (menu) {
                                case 1:
                                    dataKaryawan();
                                    break;
                                case 2:
                                    // showData();
                                    break;
                                case 3:

                                default:
                                    break;
                            }
                        }
                    }
                    loginKaryawan();
                    if (validationKaryawan) {
                        System.out.println("\nWelcome Karyawan!");
                        while (menuProcess) {
                            System.out.println("\nMENU \n1. Show Sallary \n2. Show Data \n3. Returning \n4. Logout");
                            System.out.println("Choose Menu 1 - 4 ");
                            menu = sc.nextInt();
                            sc.nextLine();

                            switch (menu) {
                                case 1:
                                    System.out.println("Gaji anda : ");
                                    break;

                                default:
                                    break;
                            }
                        }
                    }
                    break;

                default:
                    System.out.println("Maaf identitas tidak dikenali");
                    break;
            }
        }
    }

}

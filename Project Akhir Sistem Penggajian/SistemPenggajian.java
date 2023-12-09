import java.util.Scanner;
import java.util.Date;

public class SistemPenggajian {
    // global variable

    static Scanner sc = new Scanner(System.in);
    static Date tanggal = new Date();
    static boolean menuProcess, mainProcess, validationAdmin, validationKaryawan;
    static String status, yesNo, jK;
    static String golongan[] = new String[100];
    static String alamat[] = new String[100];
    static String jenisKelamin[] = new String[100];
    static int jamLembur[] = new int[100];
    static String[][] userMain = { { "admin", "karyawan" }, { "123", "456" } };
    static String[][] getUser = new String[2][2];
    static int menu;
    static String[] nama = new String[100];
    static int hitungPegawai = 2, gajiPokok, tunjangan, lembur = 10000, gajiLembur, pajak = 0;
    static int[] totalGaji = new int[100];
    static String[] gender = new String[100];
    static int[] age = new int[100];
    static int[] id = new int[500];
    static String jenisK;
    static int language;
    static int[] gajiNovember = new int[100];
    static int displayAll;
    static double pajakBilangan;
    static {
        for (int i = 0; i <= hitungPegawai; i++) {

            nama[0] = "John Doe";
            id[0] = 101;
            jenisKelamin[0] = "Laki-laki";
            age[0] = 28;
            alamat[0] = "Jl. Contoh No. 123";
            golongan[0] = "C";
            jamLembur[0] = 5;
            gajiNovember[0] = calculateSalary(0);

            nama[1] = "Jane Doe";
            id[1] = 102;
            jenisKelamin[1] = "Perempuan";
            age[1] = 25;
            alamat[1] = "Jl. Contoh No. 456";
            golongan[1] = "B";
            jamLembur[1] = 3;
            gajiNovember[1] = calculateSalary(1);

            nama[2] = "Rahmat";
            id[2] = 101;
            jenisKelamin[2] = "Laki-laki";
            age[2] = 28;
            alamat[2] = "Jl. Contoh No. 123";
            golongan[2] = "C";
            jamLembur[2] = 5;
            gajiNovember[2] = calculateSalary(2);

            nama[3] = "Fatahillah";
            id[3] = 302;
            jenisKelamin[3] = "Perempuan";
            age[3] = 25;
            alamat[3] = "Jl. Contoh No. 456";
            golongan[3] = "B";
            jamLembur[3] = 3;
            gajiNovember[3] = calculateSalary(3);
        }
        hitungPegawai++;

    }

    static int calculateSalary(int index) {

        totalGaji[index] = gajiPokok + tunjangan + gajiLembur - pajak;
        gajiNovember[index] = totalGaji[index];

        return totalGaji[index];
    }

    // validation Admin function
    static boolean validationAdmin(String username, String password) {
        return username.equals(userMain[0][0]) && password.equals(userMain[1][0]);
    }

    // validation Karyawan function
    static boolean validationKaryawan(String username, String password) {
        return username.equals(userMain[0][1]) && password.equals(userMain[1][1]);
    }

    static String[] frameData = new String[50];

    // static void setFrameItem() {
    // for (int i = 0; i < dataDummy.length; i++) {
    // dataDummy[i] = frameData[i];

    // }

    // }// DATA DUMMY BELOM

    // login page admin function
    static void loginPageAdmin() {
        System.out.println("===============================================================");
        System.out.println("                          \u001b[32m *LOGIN* \u001b[0m          ");
        System.out.println("===============================================================");

        System.out.print("Masukan Username : ");
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
    static void employeeData() {
        int kode = 0;
        do {
            System.out.println();
            System.out.println("============================================");
            System.out.println("              Employee Data Menu            ");
            System.out.println("============================================");
            System.out.println();
            System.out.println("[1] Input Employee Data ");
            System.out.println("[2] Show Employee Data ");
            System.out.println("[3] Edit Employee Data ");
            System.out.println("[4] Total Employee Data ");
            System.out.println("[5] Back ");
            System.out.print("Enter Choice\t: ");
            kode = sc.nextInt();
            sc.nextLine();
            if (kode == 1) {
                int j;
                for (j = 0; j < nama.length; j++) {
                    if (nama[j] == null) {
                        break; // Found an empty slot, break the loop
                    }
                }

                if (j == nama.length) {
                    System.out.println("Employee data is full. Cannot add more.");
                    continue; // Go back to the main loop
                }

                // Input data into the first empty slot
                System.out.print("Employee Name\t: ");
                nama[j] = sc.nextLine();
                System.out.print("Number ID\t: ");
                id[j] = sc.nextInt();
                System.out.print("Gender (M/F)\t: ");
                sc.nextLine(); // Consume the newline character
                jenisK = sc.nextLine();
                System.out.print("Age\t\t: ");
                age[j] = sc.nextInt();
                System.out.print("Address\t\t: ");
                sc.nextLine(); // Consume the newline character
                alamat[j] = sc.nextLine();

                System.out.println("For Classes :");
                System.out.println("A = Part-time Employees");
                System.out.println("B = Internship");
                System.out.println("C = Permanent Staff");
                System.out.println("D = Manager");

                System.out.print("Class Input (A-D): ");
                golongan[j] = sc.nextLine();
                System.out.print("Input Overtime Time (Hours): ");
                jamLembur[j] = sc.nextInt();

                if (jenisK.equalsIgnoreCase("f")) {
                    jenisKelamin[j] = "Perempuan";
                } else if (jenisK.equalsIgnoreCase("m")) {
                    jenisKelamin[j] = "Laki-laki";
                }

                hitungPegawai++;
            }
            if (kode == 2) {
                for (int i = 0; i <= hitungPegawai; i++) {
                    System.out.println("+---------------------------------+");
                    System.out.println("Employee Name\t: " + nama[i]);
                    System.out.println("Class Employee\t: " + golongan[i]);
                    System.out.println("Number ID\t: " + id[i]);
                    System.out.println("Gender\t\t: " + jenisKelamin[i]);
                    System.out.println("Address\t\t: " + alamat[i]);
                    System.out.println("Age\t\t: " + age[i]);
                    System.out.println("+---------------------------------+");
                }
            } else if (kode == 3) {
                System.out.print("Enter Employee Name : ");
                String nama2 = sc.nextLine();
                for (int i = 0; i <= hitungPegawai; i++) {
                    if (nama[i].equalsIgnoreCase(nama2)) {
                        System.out.print("Employee Name\t: ");
                        nama[i] = sc.nextLine();
                        System.out.print("Number ID: ");
                        id[i] = sc.nextInt();
                        System.out.print("Gender (M/F) : ");
                        jenisK = sc.nextLine();
                        sc.nextLine();
                        System.out.print("Age : ");
                        age[i] = sc.nextInt();
                        System.out.print("Address : ");
                        sc.nextLine();
                        alamat[i] = sc.nextLine();
                        System.out.println("For Classes :");
                        System.out.println("A = Part-time Employees");
                        System.out.println("B = Internship");
                        System.out.println("C = Permanent Staff");
                        System.out.println("D = Manager");

                        System.out.print("Class Input (A-D) : ");
                        golongan[i] = sc.nextLine();
                        System.out.print("Input Overtime Time (Hours) : ");
                        jamLembur[i] = sc.nextInt();

                        if (jenisK.equalsIgnoreCase("f")) {
                            jenisKelamin[i] = "Perempuan";
                        } else if (jenisK.equalsIgnoreCase("m")) {
                            jenisKelamin[i] = "Laki-laki";
                        }

                        break;
                    } else if (i == hitungPegawai) {
                        System.out.println("\u001b[31mThe Name You Entered is Not Registered!\u001b[0m");
                    }
                }
            } else if (kode == 4) {
                int paruhWaktu = 0, magang = 0, tetap = 0, manajer = 0;
                for (int i = 0; i <= hitungPegawai; i++) {
                    if (golongan[i].equalsIgnoreCase("a")) {
                        paruhWaktu++;
                    } else if (golongan[i].equalsIgnoreCase("b")) {
                        magang++;
                    } else if (golongan[i].equalsIgnoreCase("c")) {
                        tetap++;
                    } else if (golongan[i].equalsIgnoreCase("d")) {
                        manajer++;
                    }
                }
                System.out.println("+-----------------------------------------------------------+");
                System.out.println("+                 Total Number of Employees                 +");
                System.out.println("+-----------------------------------------------------------+");
                System.out.println("Total Number of Part-Time Employees: " + paruhWaktu + " Person,");
                System.out.println("Total Number of Interns            : " + magang + " Person,");
                System.out.println("Total Number of Permanent Employees: " + tetap + " Person,");
                System.out.println("Total Number of Manager            : " + manajer + " Person,");
                System.out.println("+-----------------------------------------------------------+");
                System.out.println("Total Number of Employees : " + (hitungPegawai + 1) + " Person.");

            }
        } while (kode != 5);
    }

    static void calculateSlry() {
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+              Employee Salary Calculation +                +");
        System.out.println("+-----------------------------------------------------------+");

        // Ask the user for the desired month
        System.out.println("╔═════════════════════════════════════════════════╗");
        System.out.println("║ Enter month (11 for November, 12 for December): ║");
        System.out.println("╚═════════════════════════════════════════════════╝");
        int selectedMonth = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Display the input prompt in a box for displayAll
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║ Display salaries for all employees? (1 for Yes, 0 for No): ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        int displayAll = sc.nextInt();
        sc.nextLine(); // Consume the newline character


        if (selectedMonth == 11) {
            if (displayAll == 1) {
                // Display salaries for all employees
                for (int i = 0; i <= hitungPegawai; i++) {
                    cetakSlipNov(i, selectedMonth);
                    pajakBilangan = (pajak / 100.0) * totalGaji[i];
                }
            } else {
                // Display salary for a specific employee
                System.out.print("Enter Employee Name : ");
                String nama2 = sc.nextLine();
                for (int i = 0; i <= hitungPegawai; i++) {
                    pajakBilangan = (pajak / 100.0) * totalGaji[i];
                    if (nama[i].equalsIgnoreCase(nama2)) {
                        cetakSlipNov(i, selectedMonth);
                        break;
                    } else if (i == hitungPegawai) {
                        System.out.println("\u001b[31mThe Name You Entered is Not Registered!\u001b[0m");
                    }
                }
            }
        } else if (selectedMonth == 12) {
            if (displayAll == 1) {
                // Display salaries for all employees
                for (int i = 0; i <= hitungPegawai; i++) {
                    cetakSlip(i, selectedMonth);
                    pajakBilangan = (pajak / 100.0) * totalGaji[i];
                }
            } else {
                // Display salary for a specific employee
                System.out.print("Enter Employee Name : ");
                String nama2 = sc.nextLine();
                for (int i = 0; i <= hitungPegawai; i++) {
                    pajakBilangan = (pajak / 100.0) * totalGaji[i];
                    if (nama[i].equalsIgnoreCase(nama2)) {
                        cetakSlip(i, selectedMonth);
                        break;
                    } else if (i == hitungPegawai) {
                        System.out.println("\u001b[31mThe Name You Entered is Not Registered!\u001b[0m");
                    }
                }
            }
        } // Consume the newline character

        // Display salaries based on user input

    }

    static void cetakSlipNov(int x, int selectedMonth) {
        perhitungan(x);
        cekPajak(x);

        // Adjust the logic based on the selected month

        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                      Employee Pay Slip                    +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.print("Date                 : ");
        System.out.println("17 - Nov  - 2023");
        System.out.println("Name                 :     " + nama[x]);
        System.out.println("Base Salary          : Rp. " + gajiPokok);
        System.out.println("Overtime Salary      : Rp. " + gajiLembur);
        System.out.println("Allowance Money      : Rp. " + tunjangan);
        System.out.println("Tax (Percentage)     : " + pajak + "%");
        System.out.println("Tax (Numeric)        : " + pajakBilangan);
        System.out.println("Salary Received      : Rp. " + totalGaji[x]);
    }

    static void cetakSlip(int x, int selectedMonth) {
        perhitungan(x);
        cekPajak(x);

        // Adjust the logic based on the selected month

        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                      Employee Pay Slip                    +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.print("Date                 : ");
        System.out.println(tanggal);
        System.out.println("Name                 :     " + nama[x]);
        System.out.println("Base Salary          : Rp. " + gajiPokok);
        System.out.println("Overtime Salary      : Rp. " + gajiLembur);
        System.out.println("Allowance Money      : Rp. " + tunjangan);
        System.out.println("Tax (Percentage)     : " + pajak + "%");
        System.out.println("Tax (Numeric)        : " + pajakBilangan);
        System.out.println("Salary Received      : Rp. " + totalGaji[x]);
    }

    // static void calculateSlry() {
    // System.out.println("+-----------------------------------------------------------+");
    // System.out.println("+ Employee Salary Calculation + +");
    // System.out.println("+-----------------------------------------------------------+");
    // System.out.print("Enter Employee Name : ");
    // String nama2 = sc.nextLine();

    // for (int i = 0; i <= hitungPegawai; i++) {
    // if (nama[i].equalsIgnoreCase(nama2)) {
    // perhitungan(i);
    // cekPajak(i);

    // double pajakBilangan = (pajak / 100.0) * totalGaji[i]; // Calculate tax in
    // numeric value

    // System.out.println("Base Salary : Rp. " + gajiPokok);
    // System.out.println("Allowance Money : Rp. " + tunjangan);
    // System.out.println("Overtime Salary : Rp. " + gajiLembur);
    // System.out.println("Tax (Numeric) : Rp. " + pajakBilangan);
    // System.out.println("Tax (Percentage) : " + pajak + "%");
    // System.out.println("Total Salary : Rp. " + totalGaji[i]);
    // break;
    // } else if (i == hitungPegawai) {
    // System.out.println("\u001b[31mThe Name You Entered is Not
    // Registered!\u001b[0m");
    // }
    // }
    // }

    static void searching() {
        System.out.println("[1] Search by Name ");
        System.out.println("[2] Search by Employee Number");
        System.out.println("[3] Cancel");
        System.out.print("Enter Choice : ");
        int masukan = sc.nextInt();
        sc.nextLine();
        int cari = 0;

        if (masukan == 1) {
            System.out.print("Enter Employee Name  : ");
            String nama2 = sc.nextLine();
            for (int i = 0; i <= hitungPegawai; i++) {
                if (nama[i].equalsIgnoreCase(nama2)) {
                    System.out.println("       Search Results     ");
                    System.out.println("Employee Name    : " + nama[i]);
                    System.out.println("Class            : " + golongan[i]);
                    System.out.println("Gender           : " + jenisKelamin[i]);
                    System.out.println("Addres           : " + alamat[i]);
                    System.out.println("Age              : " + age[i]);
                    System.out.println("Employee Number  : " + id[i]);
                    break;
                } else if (i == hitungPegawai) {
                    System.out.println("\u001b[31mThe Name You Entered is Not Registered!\u001b[0m");
                }
            }
        } else if (masukan == 2) {
            System.out.print("Enter Employee Number : ");
            cari = sc.nextInt();
            for (int i = 0; i <= hitungPegawai; i++) {
                if (id[i] == cari) {
                    System.out.println("       Search Results      ");
                    System.out.println("Employee Name   : " + nama[i]);
                    System.out.println("Class           : " + golongan[i]);
                    System.out.println("Gender\t: " + jenisKelamin[i]);
                    System.out.println("Addres\t: " + alamat[i]);
                    System.out.println("Age\t: " + age[i]);
                    System.out.println("Employee Number  : " + id[i]);
                }
            }
        }

    }

    static void report() {
        int i = 0;
        int pengeluaran = 0;
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                    Salary Expense Report                  +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.print("Date : Mon Nov 13 12:00:15 WIB 2023 - ");
        System.out.println(tanggal);
        System.out.println();
        System.out.println();

        for (int j = 0; j <= hitungPegawai; j++) {
            perhitungan(j);
            System.out.println("+------------------------------+");
            System.out.println("Employee Name   :     " + nama[j]);
            System.out.println("Gender          :     " + jenisKelamin[j]);
            System.out.println("Employee Class  :     " + golongan[j]);
            System.out.println("Overtime time   :     " + jamLembur[j] + " jam");
            System.out.println("Employee Salary : Rp. " + totalGaji[j]);
            System.out.println("+------------------------------+");
            pengeluaran += totalGaji[j];
        }

        System.out.println("So Total Company Expenses for Salaries of All Employees = Rp. " + pengeluaran);

    }

    // delete data function BELOMMMM PLISS
    static void deleteEmployee() {
        System.out.print("Enter Employee Name to Delete: ");
        String deleteName = sc.nextLine();

        boolean found = false;
        for (int i = 0; i <= hitungPegawai; i++) {
            if (nama[i].equalsIgnoreCase(deleteName)) {
                // Found the employee to delete
                found = true;

                // Move the remaining elements one position up to fill the gap
                for (int j = i; j < hitungPegawai; j++) {
                    nama[j] = nama[j + 1];
                    id[j] = id[j + 1];
                    jenisKelamin[j] = jenisKelamin[j + 1];
                    age[j] = age[j + 1];
                    alamat[j] = alamat[j + 1];
                    golongan[j] = golongan[j + 1];
                    jamLembur[j] = jamLembur[j + 1];
                }

                // Clear the last element
                nama[hitungPegawai] = null;
                id[hitungPegawai] = 0;
                jenisKelamin[hitungPegawai] = null;
                age[hitungPegawai] = 0;
                alamat[hitungPegawai] = null;
                golongan[hitungPegawai] = null;
                jamLembur[hitungPegawai] = 0;

                // Decrement the employee count
                hitungPegawai--;

                System.out.println("Employee data deleted successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("\u001b[31mThe Name You Entered is Not Found!\u001b[0m");
        }
    }

    static void perhitungan(int x) {
        if (golongan[x].equalsIgnoreCase("a")) {
            gajiPokok = 1000000;
            tunjangan = 500000;
        } else if (golongan[x].equalsIgnoreCase("b")) {
            gajiPokok = 1500000;
            tunjangan = 700000;
        } else if (golongan[x].equalsIgnoreCase("c")) {
            gajiPokok = 2000000;
            tunjangan = 900000;
        } else if (golongan[x].equalsIgnoreCase("d")) {
            gajiPokok = 2500000;
            tunjangan = 1200000;
        }

        gajiLembur = jamLembur[x] * lembur;
        totalGaji[x] = (gajiPokok + tunjangan + gajiLembur);

    }

    static void cekPajak(int x) {
        if (totalGaji[x] > 450000) {
            pajak = 5;
        } else if (totalGaji[x] > 1250000) {
            pajak = 15;
        } else if (totalGaji[x] > 2050000) {
            pajak = 25;
        }

        int totalPajak = totalGaji[x] * pajak / 100;
        totalGaji[x] -= totalPajak;
    }

    static void cetakSlip(int x) {

        perhitungan(x);
        cekPajak(x);
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                      Employee Pay Slip                    +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.print("Date                 : ");
        System.out.println(tanggal);
        System.out.println("Name                 :     " + nama[x]);
        System.out.println("Base Salary          : Rp. " + gajiPokok);
        System.out.println("Overtime Salary      : Rp. " + gajiLembur);
        System.out.println("Allowance Money      : Rp. " + tunjangan);
        System.out.println("Tax                  : " + pajak + "%");
        System.out.println("Salary Received      : Rp. " + totalGaji[x]);
    }

    static void showGaji() {
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                     Print Salary Slip+                    +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.print("Enter Employee Name : ");
        String nama2 = sc.nextLine();
        for (int i = 0; i <= hitungPegawai; i++) {
            if (nama[i].equalsIgnoreCase(nama2)) {
                cetakSlip(i);
                break;
            } else if (i == hitungPegawai) {
                System.out.println("\u001b[31mThe Name You Entered is Not Registered!\u001b[0m");
            }
        }
    }

    static void tampilGaji() {
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                     Cetak Slip Gaji+                    +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.print("Masukan nama karyawan : ");
        String nama2 = sc.nextLine();
        for (int i = 0; i <= hitungPegawai; i++) {
            if (nama[i].equalsIgnoreCase(nama2)) {
                cetakSlip(i);
                break;
            } else if (i == hitungPegawai) {
                System.out.println("\u001b[31mNama yang Anda Masukkan Tidak Terdaftar!\u001b[0m");
            }
        }
    }

    static void dataKaryawan() {
        int kode = 0;
        do {
            System.out.println();
            System.out.println("============================================");
            System.out.println("              Data Menu Karyawan            ");
            System.out.println("============================================");
            System.out.println();
            System.out.println("[1] Input Data Karyawan ");
            System.out.println("[2] Tampil Data Karyawan");
            System.out.println("[3] Edit Data Karyawan");
            System.out.println("[4] Data Jumlah Karyawan");
            System.out.println("[5] Kembali");
            System.out.print("Masukan pilihan :");
            kode = sc.nextInt();
            sc.nextLine();
            if (kode == 1) {
                int j;
                for (j = 0; j < nama.length; j++) {
                    if (nama[j] == null) {
                        break; // Found an empty slot, break the loop
                    }
                }

                if (j == nama.length) {
                    System.out.println("Data karyawan sudah penuh. Tidak dapat menambahkan lagi.");
                    continue; // Go back to the main loop
                }

                // Input data into the first empty slot
                System.out.print("Nama Karyawan\t : ");
                nama[j] = sc.nextLine();
                System.out.print("Nomor ID\t  : ");
                id[j] = sc.nextInt();
                System.out.print("Jenis Kelamin (L/P)\t: ");
                sc.nextLine(); // Consume the newline character
                jenisK = sc.nextLine();
                System.out.print("Umur\t\t: ");
                age[j] = sc.nextInt();
                System.out.print("Alamat\t\t: ");
                sc.nextLine(); // Consume the newline character
                alamat[j] = sc.nextLine();

                System.out.println("Untuk Golongan :");
                System.out.println("A = Pengawai Paruh Waktu");
                System.out.println("B = Pengawai Magang");
                System.out.println("C = Pengawai Tetap");
                System.out.println("D = Manajer");

                System.out.print("Masukan Golongan (A-D) : ");
                golongan[j] = sc.nextLine();
                System.out.print("Masukan Waktu lembur (jam) : ");
                jamLembur[j] = sc.nextInt();

                if (jenisK.equalsIgnoreCase("p")) {
                    jenisKelamin[j] = "Perempuan";
                } else if (jenisK.equalsIgnoreCase("l")) {
                    jenisKelamin[j] = "Laki-laki";
                }

                hitungPegawai++;
            }
            if (kode == 2) {
                for (int i = 0; i <= hitungPegawai; i++) {
                    System.out.println("+---------------------------------+");
                    System.out.println("Nama Karyawan\t: " + nama[i]);
                    System.out.println("Golongan Karyawan: " + golongan[i]);
                    System.out.println("Nomer ID\t: " + id[i]);
                    System.out.println("Jenis Kelamin\t: " + jenisKelamin[i]);
                    System.out.println("Alamat\t\t: " + alamat[i]);
                    System.out.println("Umur\t\t: " + age[i]);
                    System.out.println("+---------------------------------+");
                }
            } else if (kode == 3) {
                System.out.print("Masukan Nama Karyawan : ");
                String nama2 = sc.nextLine();
                for (int i = 0; i <= hitungPegawai; i++) {
                    if (nama[i].equalsIgnoreCase(nama2)) {
                        System.out.print("Nama Karyawan\t: ");
                        nama[i] = sc.nextLine();
                        System.out.print("Nomer ID: ");
                        id[i] = sc.nextInt();
                        System.out.print("Jenis Kelamin (L/P) : ");
                        jenisK = sc.nextLine();
                        sc.nextLine();
                        System.out.print("Umur : ");
                        age[i] = sc.nextInt();
                        System.out.print("Alamat : ");
                        sc.nextLine();
                        alamat[i] = sc.nextLine();
                        System.out.println("Untuk Golongan :");
                        System.out.println("A = Pengawai Paruh Waktu");
                        System.out.println("B = Pengawai Magang");
                        System.out.println("C = Pengawai Tetap");
                        System.out.println("D = Manajer");

                        System.out.print("Masukan Golongan (A-D) : ");
                        golongan[i] = sc.nextLine();
                        System.out.print("Masukan Waktu lembur (jam) : ");
                        jamLembur[i] = sc.nextInt();
                        System.out.print("lanjut ? (Y/T) : ");
                        String lanjut = sc.nextLine();
                        lanjut = sc.nextLine();

                        if (jenisK.equalsIgnoreCase("p")) {
                            jenisKelamin[i] = "Perempuan";
                        } else if (jenisK.equalsIgnoreCase("l")) {
                            jenisKelamin[i] = "Laki-laki";
                        }

                        break;
                    } else if (i == hitungPegawai) {
                        System.out.println("\u001b[31mNama yang anda masukan tidak terdaftar!\u001b[0m");
                    }
                }
            } else if (kode == 4) {
                int paruhWaktu = 0, magang = 0, tetap = 0, manajer = 0;
                for (int i = 0; i <= hitungPegawai; i++) {
                    if (golongan[i].equalsIgnoreCase("a")) {
                        paruhWaktu++;
                    } else if (golongan[i].equalsIgnoreCase("b")) {
                        magang++;
                    } else if (golongan[i].equalsIgnoreCase("c")) {
                        tetap++;
                    } else if (golongan[i].equalsIgnoreCase("d")) {
                        manajer++;
                    }
                }
                System.out.println("+-----------------------------------------------------------+");
                System.out.println("+                      Jumlah Karyawan                      +");
                System.out.println("+-----------------------------------------------------------+");
                System.out.println("Jumlah Pegawai Paruh Waktu : " + paruhWaktu + " orang.");
                System.out.println("Jumlah Pegawai Magang : " + magang + " orang,");
                System.out.println("Jumlah Pegawai Tetap : " + tetap + " orang,");
                System.out.println("Jumlah Manajer : " + manajer + " orang,");
                System.out.println("+-----------------------------------------------------------+");
                System.out.println("Total Jumlah Pegawai : " + (hitungPegawai + 1) + " orang,");

            }
        } while (kode != 5);
    }

    static void hitungGaji() {

        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+              Perhitungan Gaji Karyawan +                  +");
        System.out.println("+-----------------------------------------------------------+");

        // Ask the user for the desired month
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║ Masukkan bulan (11 untuk November, 12 untuk Desember): ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        int selectedMonth = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Display the input prompt in a box for displayAll
        System.out.println("╔═════════════════════════════════════════════════════════════════════╗");
        System.out.println("║ Menampilkan gaji untuk semua karyawan? (1 untuk Ya, 0 untuk Tidak): ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════════╝");
        int displayAll = sc.nextInt();
        sc.nextLine(); // Consume the newline character


        if (selectedMonth == 11) {
            if (displayAll == 1) {
                // Display salaries for all employees
                for (int i = 0; i <= hitungPegawai; i++) {
                    cetakSlipNovInd(i, selectedMonth);
                    pajakBilangan = (pajak / 100.0) * totalGaji[i];
                }
            } else {
                // Display salary for a specific employee
                System.out.print("Masukan Nama Karyawan : ");
                String nama2 = sc.nextLine();
                for (int i = 0; i <= hitungPegawai; i++) {
                    pajakBilangan = (pajak / 100.0) * totalGaji[i];
                    if (nama[i].equalsIgnoreCase(nama2)) {
                        cetakSlipNovInd(i, selectedMonth);
                        break;
                    } else if (i == hitungPegawai) {
                        System.out.println("\u001b[31mNama yang Anda Masukkan Tidak Terdaftar!\u001b[0m");
                    }
                }
            }
        } else if (selectedMonth == 12) {
            if (displayAll == 1) {
                // Display salaries for all employees
                for (int i = 0; i <= hitungPegawai; i++) {
                    cetakSlipInd(i, selectedMonth);
                    pajakBilangan = (pajak / 100.0) * totalGaji[i];
                }
            } else {
                // Display salary for a specific employee
                System.out.print("Masukan Nama Karyawan : ");
                String nama2 = sc.nextLine();
                for (int i = 0; i <= hitungPegawai; i++) {
                    pajakBilangan = (pajak / 100.0) * totalGaji[i];
                    if (nama[i].equalsIgnoreCase(nama2)) {
                        cetakSlipInd(i, selectedMonth);
                        break;
                    } else if (i == hitungPegawai) {
                        System.out.println("\u001b[31mNama yang Anda Masukkan Tidak Terdaftar!\u001b[0m");
                    }
                }
            }
        } // Consume the newline character

        // Display salaries based on user input

    }

    static void cetakSlipNovInd(int x, int selectedMonth) {
        perhitungan(x);
        cekPajak(x);

        // Adjust the logic based on the selected month

        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                      Slip Gaji Karyawan                   +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.print("Date                 : ");
        System.out.println("17 - Nov  - 2023");
        System.out.println("Nama                 :     " + nama[x]);
        System.out.println("Gaji Pokok           : Rp. " + gajiPokok);
        System.out.println("Uang Lembur          : Rp. " + gajiLembur);
        System.out.println("Uang Tunjangan       : Rp. " + tunjangan);
        System.out.println("Pajak (Persentase)   : " + pajak + "%");
        System.out.println("Tax (Angka)          : " + pajakBilangan);
        System.out.println("Gaji yang diterima   : Rp. " + totalGaji[x]);
    }

    static void cetakSlipInd(int x, int selectedMonth) {
        perhitungan(x);
        cekPajak(x);

        // Adjust the logic based on the selected month

        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                      Employee Pay Slip                    +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.print("Date                 : ");
        System.out.println(tanggal);
        System.out.println("Nama                 :     " + nama[x]);
        System.out.println("Gaji Pokok           : Rp. " + gajiPokok);
        System.out.println("Uang Lembur          : Rp. " + gajiLembur);
        System.out.println("Uang Tunjangan       : Rp. " + tunjangan);
        System.out.println("Pajak (Persentase)   : " + pajak + "%");
        System.out.println("Tax (Angka)          : " + pajakBilangan);
        System.out.println("Gaji yang diterima   : Rp. " + totalGaji[x]);
    }


    static void pencarian() {
        System.out.println("[1] Cari Berdasarkan Nama ");
        System.out.println("[2] Cari berdasarkan Nomor Karyawan");
        System.out.println("[3] Kembali");
        System.out.print("Masukan Pilihan : ");
        int masukan = sc.nextInt();
        sc.nextLine();
        int cari = 0;

        if (masukan == 1) {
            System.out.print("Masukan Nama Karyawan  : ");
            String nama2 = sc.nextLine();
            for (int i = 0; i <= hitungPegawai; i++) {
                if (nama[i].equalsIgnoreCase(nama2)) {
                    System.out.println("       Hasil Pencarian    ");
                    System.out.println("Nama Karyawan     : " + nama[i]);
                    System.out.println("Golongan          : " + golongan[i]);
                    System.out.println("Jenis Kelamin     : " + jenisKelamin[i]);
                    System.out.println("Alamat            : " + alamat[i]);
                    System.out.println("Umur              : " + age[i]);
                    System.out.println("Nomor ID Karyawan : " + id[i]);
                    break;
                } else if (i == hitungPegawai) {
                    System.out.println("\u001b[31mNama yang anda masukan tidak terdaftar!\u001b[0m");
                }
            }
        } else if (masukan == 2) {
            System.out.print("Enter Employee Number : ");
            cari = sc.nextInt();
            for (int i = 0; i <= hitungPegawai; i++) {
                if (id[i] == cari) {
                    System.out.println("Nama Karyawan     : " + nama[i]);
                    System.out.println("Golongan          : " + golongan[i]);
                    System.out.println("Jenis Kelamin     : " + jenisKelamin[i]);
                    System.out.println("Alamat            : " + alamat[i]);
                    System.out.println("Umur              : " + age[i]);
                    System.out.println("Nomor ID Karyawan : " + id[i]);
                    break;
                } else if (i == hitungPegawai) {
                    System.out.println("\u001b[31mNama yang anda masukan tidak terdaftar!\u001b[0m");
                }
            }
        }

    }

    static void laporan() {
        int i = 0;
        int pengeluaran = 0;
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                    Laporan Pengeluaran Gaji               +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.print("Tanggal : Senin Nov 13 12:00:15 WIB 2023 - ");
        System.out.println(tanggal);
        System.out.println();
        System.out.println();

        for (int j = 0; j <= hitungPegawai; j++) {
            perhitungan(j);
            System.out.println("+------------------------------+");
            System.out.println("Nama Pegawai     :     " + nama[j]);
            System.out.println("Jenis kelamin    :     " + jenisKelamin[j]);
            System.out.println("Golongan Pegawai :     " + golongan[j]);
            System.out.println("Waktu lembur     :     " + jamLembur[j] + " jam");
            System.out.println("Gaji Pegawai     : Rp. " + totalGaji[j]);
            System.out.println("+------------------------------+");
            pengeluaran += totalGaji[j];
        }
        System.out.println("Jadi Total Pengeluaran Perusahan Untuk Gaji Seluruh Karyawan = Rp. " + pengeluaran);

    }

    // delete data function BLOMMM PLISS
    static void menghapusData() {
        System.out.print("Masukan Nama Karyawan Yang Ingin di Hapus: ");
        String namaHapus = sc.nextLine();

        // cari index data karyawan yang akan dihapus
        int indexHapus = -1;
        for (int i = 0; i <= hitungPegawai; i++) {
            if (nama[i].equalsIgnoreCase(namaHapus)) {
                indexHapus = i;
                break;
            }
        }

        // hapus data karyawan dari array
        if (indexHapus >= -1) {
            for (int i = indexHapus; i < hitungPegawai; i++) {
                nama[i] = nama[i + 1];
                jenisKelamin[i] = jenisKelamin[i + 1];
                golongan[i] = golongan[i + 1];
                jamLembur[i] = jamLembur[i + 1];
            }

        } else {
            System.out.println("Data Tidak Ditemukan");
        }
    }

    static void Menghitung(int x) {
        if (golongan[x].equalsIgnoreCase("a")) {
            gajiPokok = 1000000;
            tunjangan = 500000;
        } else if (golongan[x].equalsIgnoreCase("b")) {
            gajiPokok = 1500000;
            tunjangan = 700000;
        } else if (golongan[x].equalsIgnoreCase("c")) {
            gajiPokok = 2000000;
            tunjangan = 900000;
        } else if (golongan[x].equalsIgnoreCase("d")) {
            gajiPokok = 2500000;
            tunjangan = 1200000;
        }

        gajiLembur = jamLembur[x] * lembur;
        totalGaji[x] = (gajiPokok + tunjangan + gajiLembur);

    }

    static void cekkPajak(int x) {
        if (totalGaji[x] > 450000) {
            pajak = 5;
        } else if (totalGaji[x] > 1250000) {
            pajak = 15;
        } else if (totalGaji[x] > 2050000) {
            pajak = 25;
        }

        int totalPajak = totalGaji[x] * pajak / 100;
        totalGaji[x] -= totalPajak;
    }

    static void Slip(int x) {

        perhitungan(x);
        cekPajak(x);
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                      Slip Gaji Karyawan                   +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.print("Tanggal              : ");
        System.out.println(tanggal);
        System.out.println("Nama                 :     " + nama[x]);
        System.out.println("Gaji Pokok           : Rp. " + gajiPokok);
        System.out.println("Uang Lembur          : Rp. " + gajiLembur);
        System.out.println("Uang Tunjangan       : Rp. " + tunjangan);
        System.out.println("Pajak                : Rp. " + pajak + "%");
        System.out.println("Gaji Yang Diterima   : Rp. " + totalGaji[x]);
    }

    static void menunjukanGaji() {
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                     Cetak Slip Gaji+                      +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.print("Masukan Nama Karyawan : ");
        String nama2 = sc.nextLine();
        for (int i = 0; i <= hitungPegawai; i++) {
            if (nama[i].equalsIgnoreCase(nama2)) {
                cetakSlip(i);
                break;
            } else if (i == hitungPegawai) {
                System.out.println("\\u001b[31mNama yang anda masukan tidak terdaftar!\u001b[0m");
            }
        }
    }

    static void editDataKar() {
        System.out.print("Masukan nama : ");
        String nama2 = sc.nextLine();
        for (int i = 0; i <= hitungPegawai; i++) {
            if (nama[i].equalsIgnoreCase(nama2)) {
                System.out.print("Nama Karyawan\t: ");
                nama[i] = sc.nextLine();
                System.out.print("Jenis Kelamin (L/P): ");
                jenisK = sc.nextLine();
                System.out.print("Umur: ");
                age[i] = sc.nextInt();
                System.out.print("Alamat: ");
                sc.nextLine();
                alamat[i] = sc.nextLine();
                if (jenisK.equalsIgnoreCase("P")) {
                    jenisKelamin[i] = "Perempuan";
                } else if (jenisK.equalsIgnoreCase("L")) {
                    jenisKelamin[i] = "Laki-laki";
                }

                break;
            } else if (i == hitungPegawai) {
                System.out.println("\u001b[31mNama yang anda masukan tidak terdaftar!\u001b[0m");
            }
        }
    }

    static void editDataKarIng() {
        System.out.print("Enter Employee Name : ");
        String nama2 = sc.nextLine();
        for (int i = 0; i <= hitungPegawai; i++) {
            if (nama[i].equalsIgnoreCase(nama2)) {
                System.out.print("Employee Name\t: ");
                nama[i] = sc.nextLine();
                System.out.print("Gender (M/F): ");
                jenisK = sc.nextLine();
                sc.nextLine();
                System.out.print("Age : ");
                age[i] = sc.nextInt();
                System.out.print("Address : ");
                sc.nextLine();
                alamat[i] = sc.nextLine();
                if (jenisK.equalsIgnoreCase("f")) {
                    jenisKelamin[i] = "Perempuan";
                } else if (jenisK.equalsIgnoreCase("m")) {
                    jenisKelamin[i] = "Laki-laki";
                }
                break;
            } else if (i == hitungPegawai) {
                System.out.println("\u001b[31mNama yang anda masukan tidak terdaftar!\u001b[0m");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("\u001B[34m" +
                " ._.   _________.__          __                   __________                                        __.__                ._. \n"
                + //
                " | |  /   _____/|__| _______/  |_  ____   _____   \\______   \\ ____   ____    ____   _________      |__|__|____    ____   | | \n"
                + //
                " |_|  \\_____  \\ |  |/  ___/\\   __\\/ __ \\ /     \\   |     ___// __ \\ /    \\  / ___\\ / ___\\__  \\     |  |  \\__  \\  /    \\  |_| \n"
                + //
                " |-|  /        \\|  |\\___ \\  |  | \\  ___/|  Y Y  \\  |    |   \\  ___/|   |  \\/ /_/  > /_/  > __ \\_   |  |  |/ __ \\|   |  \\ |-| \n"
                + //
                " | | /_______  /|__/____  > |__|  \\___  >__|_|  /  |____|    \\___  >___|  /\\___  /\\___  (____  /\\__|  |__(____  /___|  / | | \n"
                + //
                " |_|         \\/         \\/            \\/      \\/                 \\/     \\//_____//_____/     \\/\\______|       \\/     \\/  |_|\u001B[0m");

        // setFrameItem();
        System.out.println();
        String line = "===============================================================";
        System.out.printf("%s\n\t     SELAMAT DATANG DI SISTEM PENGGAJIAN \n%s", line, line);
        mainProcess = true;
        System.out.println();
        while (mainProcess) {
            // Menambahkan warna dan font
            System.out.println("\u001b[32mSILAHKAN LOGIN UNTUK MELANJUTKAN AKSES PROGRAM\u001b[0m");
            System.out.println("1. Login");
            System.out.println("2. Keluar Program");
            System.out.println();
            System.out.print("Pilih Menu 1 - 2 : ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    menuProcess = true;
                    loginPageAdmin();
                    if (validationAdmin) {
                        System.out.println("===============================================================");
                        System.out.println("                     \u001b[32mSelamat Datang Admin!\u001b[0m");
                        System.out.println("===============================================================");
                        System.out.println(" Pilihan Bahasa");
                        System.out.println(" [1] English");
                        System.out.println(" [2] Indonesian");
                        System.out.println("===============================================================");
                        System.out.print("Pilih Bahasa : ");
                        language = sc.nextInt();
                        if (language == 1) {

                            while (menuProcess) {
                                System.out.println("+^^^^^^^^^^^^^^^^^^^^^^^^^+");
                                System.out.println("|    * MENU OPTIONS *     |");
                                System.out.println("+^^^^^^^^^^^^^^^^^^^^^^^^^+");
                                System.out.println("| [1] Employee Data       |");
                                System.out.println("| [2] Salary Calculation  |");
                                System.out.println("| [3] Searching           |");
                                System.out.println("| [4] Report              |");
                                System.out.println("| [5] Delete Data         |");
                                System.out.println("| [6] Exit                |");
                                System.out.println("+-------------------------+");
                                System.out.print("Choose Menu 1 - 5 : ");
                                menu = sc.nextInt();
                                sc.nextLine();
                                switch (menu) {
                                    case 1:
                                        employeeData();
                                        break;
                                    case 2:
                                        calculateSlry();
                                        break;
                                    case 3:
                                        searching();
                                        break;
                                    case 4:
                                        report();
                                        break;
                                    case 5:
                                        deleteEmployee();
                                        break;
                                    case 6:
                                        menuProcess = false;
                                        break;
                                    default:
                                        System.out.println();
                                        System.out.println("\u001b[31mInvalid menu! Choose menu correctly\u001b[0m");
                                        System.out.println();
                                        break;
                                }
                            }
                        } else if (language == 2) {
                            while (menuProcess) {
                                System.out.println("+^^^^^^^^^^^^^^^^^^^^^^^^^+");
                                System.out.println("|    * PILIHAN MENU *     |");
                                System.out.println("+^^^^^^^^^^^^^^^^^^^^^^^^^+");
                                System.out.println("| [1] Data Karyawan       |");
                                System.out.println("| [2] Perhitungan Gaji    |");
                                System.out.println("| [3] Pencarian           |");
                                System.out.println("| [4] Laporan             |");
                                System.out.println("| [5] Hapus Data          |");
                                System.out.println("| [6] Keluar              |");
                                System.out.println("+-------------------------+");
                                System.out.print("Masukan Menu Pilihan Anda : ");
                                menu = sc.nextInt();
                                sc.nextLine();
                                switch (menu) {
                                    case 1:
                                        dataKaryawan();
                                        break;
                                    case 2:
                                        hitungGaji();
                                        break;
                                    case 3:
                                        pencarian();
                                        break;
                                    case 4:
                                        laporan();
                                        break;
                                    case 5:
                                        menghapusData();
                                        break;
                                    case 6:
                                        menuProcess = false;
                                        break;
                                    default:
                                        System.out.println();
                                        System.out.println(
                                                "\u001b[31mMenu tidak valid! Silahkan Pilih menu dengan benar\u001b[0m");
                                        System.out.println();
                                        break;
                                }
                            }

                        }
                    }
                    loginKaryawan();
                    if (validationKaryawan) {
                        System.out.println("===============================================================");
                        System.out.println("                     Selamat Datang Karyawan!");
                        System.out.println("===============================================================");
                        System.out.println(" Pilihan Bahasa");
                        System.out.println(" [1] English");
                        System.out.println(" [2] Indonesian");
                        System.out.println("===============================================================");
                        System.out.print("Pilih Bahasa : ");
                        language = sc.nextInt();
                        if (language == 2) {
                            while (menuProcess) {
                                System.out.println("+^^^^^^^^^^^^^^^^^^^^^^^^^+");
                                System.out.println("|    * PILIHAN MENU *     |");
                                System.out.println("+^^^^^^^^^^^^^^^^^^^^^^^^^+");
                                System.out.println("| [1] Tampilkan Gaji      |");
                                System.out.println("| [2] Edit Data           |");
                                System.out.println("| [3] Keluar              |");
                                System.out.println("+-------------------------+");
                                System.out.print("Pilih menu 1 - 3 : ");
                                menu = sc.nextInt();
                                sc.nextLine();
                                switch (menu) {
                                    case 1:
                                        tampilGaji();
                                        break;
                                    case 2:
                                        editDataKar();
                                        break;
                                    case 3:
                                        menuProcess = false;
                                        break;

                                    default:
                                        System.out.println();
                                        System.out.println(
                                                "\u001b[31mMenu tidak valid! Pilih menu dengan benar\u001b[0m");
                                        System.out.println();
                                        break;
                                }
                            }

                        } else if (language == 1) {
                            while (menuProcess) {
                                System.out.println("+^^^^^^^^^^^^^^^^^^^^^^^^^+");
                                System.out.println("|    * MENU OPTIONS *     |");
                                System.out.println("+^^^^^^^^^^^^^^^^^^^^^^^^^+");
                                System.out.println("| [1] Show Salary         |");
                                System.out.println("| [2] Edit Data           |");
                                System.out.println("| [3] Exit                |");
                                System.out.println("+-------------------------+");
                                System.out.print("Choose Menu 1 - 3 : ");
                                menu = sc.nextInt();
                                sc.nextLine();

                                switch (menu) {
                                    case 1:
                                        showGaji();
                                        break;
                                    case 2:
                                        editDataKar();
                                        break;
                                    case 3:
                                        menuProcess = false;
                                        break;

                                    default:
                                        System.out.println();
                                        System.out.println("\u001b[31mInvalid menu! Choose menu correctly\u001b[0m");
                                        System.out.println();
                                        break;
                                }
                            }
                        }
                    }
                    break;

                case 2:
                    menuProcess = false;
                    break;

                default:
                    System.out.println();
                    System.out.println("\u001b[31mSorry Identity not Recognized\u001b[0m");
                    System.out.println();
                    break;
            }
        }
    }

}

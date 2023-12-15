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
            // gajiNovember[0] = calculateSalary(0);

            nama[1] = "Jane Doe";
            id[1] = 102;
            jenisKelamin[1] = "Perempuan";
            age[1] = 25;
            alamat[1] = "Jl. Contoh No. 456";
            golongan[1] = "B";
            jamLembur[1] = 3;
            // gajiNovember[1] = calculateSalary(1);

            nama[2] = "Rahmat";
            id[2] = 103;
            jenisKelamin[2] = "Laki-laki";
            age[2] = 28;
            alamat[2] = "Jl. Contoh No. 123";
            golongan[2] = "C";
            jamLembur[2] = 5;
            // gajiNovember[2] = calculateSalary(2);

            nama[3] = "Fatahillah";
            id[3] = 302;
            jenisKelamin[3] = "Perempuan";
            age[3] = 25;
            alamat[3] = "Jl. Contoh No. 456";
            golongan[3] = "B";
            jamLembur[3] = 3;
            // gajiNovember[3] = calculateSalary(3);
        }
        hitungPegawai++;

    }

    // static int calculateSalary(int index) {

    // totalGaji[index] = gajiPokok + tunjangan + gajiLembur - pajak;
    // gajiNovember[index] = totalGaji[index];

    // return totalGaji[index];
    // }

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
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                          \u001b[32m *LOGIN* \u001b[0m                             ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");

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
            System.out.println("\u001b[32m+==========================================+");
            System.out.println("|            \u001b[0m\u001b[32mEmployee Data Menu            \u001b[0m\u001b[32m|");
            System.out.println("+==========================================+\u001b[0m");
            System.out.println("| [1] Input Employee Data                  |");
            System.out.println("| [2] Show Employee Data                   |");
            System.out.println("| [3] Edit Employee Data                   |");
            System.out.println("| [4] Total Employee Data                  |");
            System.out.println("| [5] Back                                 |");
            System.out.println("+==========================================+");
            System.out.print("Enter Choice\t: ");
            kode = sc.nextInt();
            sc.nextLine();
            System.out.println("");
            if (kode == 1) {
                while (true) {

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

                    System.out.println("+---------------------------+");
                    System.out.println("|        For Classes        |");
                    System.out.println("+---------------------------+");
                    System.out.println("|  A = Part-time Employees  |");
                    System.out.println("|  B = Internship           |");
                    System.out.println("|  C = Permanent Staff      |");
                    System.out.println("|  D = Manager              |");
                    System.out.println("+---------------------------+");

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
                    System.out.print("Do you want to enter employee data again? (Y/N): ");
                    String continueInput = sc.next();
                    if (!continueInput.equalsIgnoreCase("Y")) {
                        break; // Exit the loop if the user does not want to continue
                    }
                    sc.nextLine(); // Consume the newline character
                }

                // Display summary or perform other actions if needed
                System.out.println("Number of employees that have been entered: " + (hitungPegawai + 1));
            }

            if (kode == 2) {
                for (int i = 0; i <= hitungPegawai; i++) {
                    System.out.println("  ╔════════════════════════════════════════════╗");
                    System.out.println("  ║ Employee Name   : " + nama[i] + "                 ");
                    System.out.println("  ║ Class Employee  : " + golongan[i] + "                        ");
                    System.out.println("  ║ Number ID       : " + id[i] + "                      ");
                    System.out.println("  ║ Gender          : " + jenisKelamin[i] + "                ");
                    System.out.println("  ║ Address         : " + alamat[i] + "       ");
                    System.out.println("  ║ Age             : " + age[i] + "                       ");
                    System.out.println("  ╚════════════════════════════════════════════╝");
                }
            } else if (kode == 3) {
                System.out.print("Enter Employee Name : ");
                String nama2 = sc.nextLine();
                for (int i = 0; i <= hitungPegawai; i++) {
                    if (nama[i].equalsIgnoreCase(nama2)) {
                        System.out.print("Employee Name     : ");
                        nama[i] = sc.nextLine();
                        System.out.print("Number ID         : ");
                        id[i] = sc.nextInt();
                        System.out.print("Gender (M/F)      : ");
                        jenisK = sc.nextLine();
                        sc.nextLine();
                        System.out.print("Age               : ");
                        age[i] = sc.nextInt();
                        System.out.print("Address           : ");
                        sc.nextLine();
                        alamat[i] = sc.nextLine();
                        System.out.println("+---------------------------+");
                        System.out.println("|        For Classes        |");
                        System.out.println("+---------------------------+");
                        System.out.println("|  A = Part-time Employees  |");
                        System.out.println("|  B = Internship           |");
                        System.out.println("|  C = Permanent Staff      |");
                        System.out.println("|  D = Manager              |");
                        System.out.println("+---------------------------+");
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
                System.out.println("\u001b[32m+---------------------------------------------------------------+");
                System.out.println(
                        "|                 \u001b[0m\u001b[32mTotal Number of Employees                     \u001b[0m\u001b[32m|");
                System.out.println("+---------------------------------------------------------------+\u001b[0m");

                System.out
                        .println("| Total Number of Part-Time Employees   : " + paruhWaktu + " Person,             |");
                System.out.println("| Total Number of Interns               : " + magang + " Person,             |");
                System.out.println("| Total Number of Permanent Employees   : " + tetap + " Person,             |");
                System.out.println("| Total Number of Managers              : " + manajer + " Person,             |");
                System.out.println("+---------------------------------------------------------------+");
                System.out.println(
                        "| Total Number of Employees             : " + (hitungPegawai + 1) + " Person.             |");
                System.out.println("+---------------------------------------------------------------+");

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
        System.out.print("Enter here: ");
        int selectedMonth = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Display the input prompt in a box for displayAll
        System.out.println("╔════════════════════════════════════════════════════════════╗");
        System.out.println("║ Display salaries for all employees? (1 for Yes, 0 for No): ║");
        System.out.println("╚════════════════════════════════════════════════════════════╝");
        System.out.print("Enter here: ");
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

    }

    static void cetakSlipNov(int x, int selectedMonth) {
        perhitungan(x);
        cekPajak(x);

        // Adjust the logic based on the selected month

        System.out.println("\u001b[34m+-----------------------------------------------------------+");
        System.out.println("|                      Employee Pay Slip                    |");
        System.out.println("+-----------------------------------------------------------+\u001b[0m");

        System.out.printf("\u001b[34m| Date                 : %-33s  |\n\u001b[0m", "17 - Nov  - 2023");
        System.out.printf("\u001b[34m| Name                 : %-33s  |\n\u001b[0m", nama[x]);
        System.out.printf("\u001b[34m| Base Salary          : Rp. %-30s |\n\u001b[0m", +gajiPokok);
        System.out.printf("\u001b[34m| Overtime Salary      : Rp. %-30s |\n\u001b[0m", gajiLembur);
        System.out.printf("\u001b[34m| Allowance Money      : Rp. %-30s |\n\u001b[0m", tunjangan);
        System.out.printf("\u001b[34m| Tax (Percentage)     : %-31s    |\n\u001b[0m", pajak + "%");
        System.out.printf("\u001b[34m| Tax (Numeric)        : Rp. %-30s |\n\u001b[0m", pajakBilangan);
        System.out.printf("\u001b[34m| Salary Received      : Rp. %-30s |\n\u001b[0m", totalGaji[x]);
        System.out.println("\u001b[34m+-----------------------------------------------------------+\u001b[0m");
        System.out.println();

    }

    static void cetakSlip(int x, int selectedMonth) {
        perhitungan(x);
        cekPajak(x);
        pajakBilangan = (pajak / 100.0) * totalGaji[x];
        // Adjust the logic based on the selected month

        System.out.println("\u001b[34m+-----------------------------------------------------------+");
        System.out.println("|                      Employee Pay Slip                    |");
        System.out.println("+-----------------------------------------------------------+\u001b[0m");

        System.out.printf("\u001b[34m| Date                 : %-33s  |\n\u001b[0m", tanggal);
        System.out.printf("\u001b[34m| Name                 : %-33s  |\n\u001b[0m", nama[x]);
        System.out.printf("\u001b[34m| Base Salary          : Rp. %-30s |\n\u001b[0m", +gajiPokok);
        System.out.printf("\u001b[34m| Overtime Salary      : Rp. %-30s |\n\u001b[0m", gajiLembur);
        System.out.printf("\u001b[34m| Allowance Money      : Rp. %-30s |\n\u001b[0m", tunjangan);
        System.out.printf("\u001b[34m| Tax (Percentage)     : %-31s    |\n\u001b[0m", pajak + "%");
        System.out.printf("\u001b[34m| Tax (Numeric)        : Rp. %-30s |\n\u001b[0m", pajakBilangan);
        System.out.printf("\u001b[34m| Salary Received      : Rp. %-30s |\n\u001b[0m", totalGaji[x]);
        System.out.println("\u001b[34m+-----------------------------------------------------------+\u001b[0m");
        System.out.println();
    }

    static void searching() {
        System.out.println("+----------------------------------------+");
        System.out.println("|             Search Options             |");
        System.out.println("+----------------------------------------+");
        System.out.println("| [1] Search by Name                     |");
        System.out.println("| [2] Search by Employee Number          | ");
        System.out.println("| [3] Cancel                             |");
        System.out.println("+----------------------------------------+");
        System.out.print("Enter Choice : ");

        int masukan = sc.nextInt();
        sc.nextLine();
        int cari = 0;

        if (masukan == 1) {
            System.out.print("Enter Employee Name  : ");
            String nama2 = sc.nextLine();
            System.out.println("");

            boolean employeeFound = false;

            for (int i = 0; i < hitungPegawai; i++) {
                if (nama[i].equalsIgnoreCase(nama2)) {
                    employeeFound = true;

                    System.out.println(
                            "\u001b[32m+-----------------------------------------------------------------------------------------------------------+");
                    System.out.println(
                            "|                                             Search Results                                                |");
                    System.out.println(
                            "+-----------------------------------------------------------------------------------------------------------+\u001b[0m");

                    String format = "| %-20s | %-10s | %-10s | %-30s | %-5s | %-15s |\n";

                    System.out.format(format, "Employee Name", "Class", "Gender", "Address", "Age", "Employee Number");
                    System.out.println(
                            "+----------------------+------------+------------+--------------------------------+-------+-----------------+");

                    System.out.format(format, nama[i], golongan[i], jenisKelamin[i], alamat[i], age[i], id[i]);

                    System.out.println(
                            "+-----------------------------------------------------------------------------------------------------------+");
                    break;
                }
            }

            if (!employeeFound) {
                System.out.println("\u001b[31mThe Name You Entered is Not Registered!\u001b[0m");
            }

        } else if (masukan == 2) {
            System.out.print("Enter Employee Number : ");
            cari = sc.nextInt();
            System.out.println("");
            boolean employeeFound = false;
            for (int i = 0; i <= hitungPegawai; i++) {
                if (id[i] == cari) {
                    employeeFound = true;

                    System.out.println(
                            "\u001b[32m+-----------------------------------------------------------------------------------------------------------+");
                    System.out.println(
                            "|                                             Search Results                                                |");
                    System.out.println(
                            "+-----------------------------------------------------------------------------------------------------------+\u001b[0m");

                    String format = "| %-20s | %-10s | %-10s | %-30s | %-5s | %-15s |\n";

                    System.out.format(format, "Employee Name", "Class", "Gender", "Address", "Age", "Employee Number");
                    System.out.println(
                            "+----------------------+------------+------------+--------------------------------+-------+-----------------+");

                    System.out.format(format, nama[i], golongan[i], jenisKelamin[i], alamat[i], age[i], id[i]);

                    System.out.println(
                            "+-----------------------------------------------------------------------------------------------------------+");
                    break;
                }
            }

            if (!employeeFound) {
                System.out.println("\u001b[31mThe Name You Entered is Not Registered!\u001b[0m");
            }
        }
    }

    static void report() {
        int i = 0;
        int pengeluaran = 0;
        System.out.println(
                "\u001b[32m+==================================================================================+");
        System.out.println(
                "|                             \u001b[0m\u001b[32mSalary Expense Report                                \u001b[0m\u001b[32m|");
        System.out.println(
                "+==================================================================================+\u001b[0m");

        System.out.printf("|     Date: Mon Nov 13 12:00:15 WIB 2023 - %-19s            |\n", tanggal);
        System.out.println("+==================================================================================+");
        System.out.printf("| %-15s | %-9s | %-14s | %-15s | %-16s|\n", "Employee Name", "Gender", "Employee Class",
                "Overtime time", "Employee Salary");
        System.out.println("+-----------------+-----------+----------------+-----------------+-----------------|");
        for (int j = 0; j <= hitungPegawai; j++) {
            perhitungan(j);
            System.out.printf("| %-15s | %-6s | %-14s | %-15s | Rp. %-12s|\n", nama[j], jenisKelamin[j], golongan[j],
                    jamLembur[j] + " jam", totalGaji[j]);
            System.out.println("+-----------------+-----------+----------------+-----------------+-----------------|");
            pengeluaran += totalGaji[j];
        }

        System.out.printf(
                "\u001b[33m| So Total Company Expenses for Salaries of All Employees = Rp. %-18s |\u001b[0m\n",
                pengeluaran);

        System.out.println("+----------------------------------------------------------------------------------+");

    }

    // delete data function
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
                System.out.println();
                System.out.println("\u001b[32mEmployee data deleted successfully.\u001b[0m");
                System.out.println();
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
        pajakBilangan = (pajak / 100.0) * totalGaji[x];
        // Adjust the logic based on the selected month

        System.out.println("\u001b[34m+-----------------------------------------------------------+");
        System.out.println("|                      Employee Pay Slip                    |");
        System.out.println("+-----------------------------------------------------------+\u001b[0m");

        System.out.printf("\u001b[34m| Date                 : %-33s  |\n\u001b[0m", "17 - Nov  - 2023");
        System.out.printf("\u001b[34m| Name                 : %-33s  |\n\u001b[0m", nama[x]);
        System.out.printf("\u001b[34m| Base Salary          : Rp. %-30s |\n\u001b[0m", +gajiPokok);
        System.out.printf("\u001b[34m| Overtime Salary      : Rp. %-30s |\n\u001b[0m", gajiLembur);
        System.out.printf("\u001b[34m| Allowance Money      : Rp. %-30s |\n\u001b[0m", tunjangan);
        System.out.printf("\u001b[34m| Tax (Percentage)     : %-31s    |\n\u001b[0m", pajak + "%");
        System.out.printf("\u001b[34m| Tax (Numeric)        : Rp. %-30s |\n\u001b[0m", pajakBilangan);
        System.out.printf("\u001b[34m| Salary Received      : Rp. %-30s |\n\u001b[0m", totalGaji[x]);
        System.out.println("\u001b[34m+-----------------------------------------------------------+\u001b[0m");
        System.out.println();
    }

    static void showGaji() {
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                       Print Salary                        +");
        System.out.println("+-----------------------------------------------------------+");

        // Ask the user for the desired month
        System.out.println("╔═════════════════════════════════════════════════╗");
        System.out.println("║ Enter month (11 for November, 12 for December): ║");
        System.out.println("╚═════════════════════════════════════════════════╝");
        System.out.print("Enter here: ");
        int selectedMonth = sc.nextInt();

        sc.nextLine(); // Consume the newline character
        if (selectedMonth == 11) {
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
        } else if (selectedMonth == 12) {
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

    }

    static void tampilGaji() {
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("+                        Cetak Gaji                         +");
        System.out.println("+-----------------------------------------------------------+");
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║ Masukkan bulan (11 untuk November, 12 untuk Desember): ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.print("Enter here: ");
        int selectedMonth = sc.nextInt();
        sc.nextLine();
        if (selectedMonth == 11) {
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
        } else if (selectedMonth == 12) {
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
    }

    static void dataKaryawan() {
        int kode = 0;
        do {
            System.out.println();
            System.out.println("\u001b[32m+================================================+");
            System.out.println(
                    "|              \u001b[0m\u001b[32mMenu Data Karyawan                \u001b[0m\u001b[32m|");
            System.out.println("+================================================+\u001b[0m");
            System.out.println("| [1] Input Data Karyawan                        |");
            System.out.println("| [2] Tampil Data Karyawan                       |");
            System.out.println("| [3] Edit Data Karyawan                         |");
            System.out.println("| [4] Data Jumlah Karyawan                       |");
            System.out.println("| [5] Kembali                                    |");
            System.out.println("+================================================+");
            System.out.print("Masukan pilihan : ");

            kode = sc.nextInt();
            sc.nextLine();
            if (kode == 1) {
                while (true) {
                    int j;
                    for (j = 0; j < nama.length; j++) {
                        if (nama[j] == null) {
                            break; // Found an empty slot, break the loop
                        }
                    }

                    if (j == nama.length) {
                        System.out.println("Data karyawan sudah penuh. Tidak dapat menambahkan lagi.");
                        break; // Exit the loop
                    }
                    System.out.println();

                    // Input data into the first empty slot
                    System.out.print("Nama Karyawan          : ");
                    nama[j] = sc.nextLine();
                    System.out.print("Nomor ID               : ");
                    id[j] = sc.nextInt();
                    System.out.print("Jenis Kelamin (L/P)    : ");
                    sc.nextLine(); // Consume the newline character
                    String jenisK = sc.nextLine();
                    System.out.print("Umur                   : ");
                    age[j] = sc.nextInt();
                    System.out.print("Alamat                 : ");
                    sc.nextLine(); // Consume the newline character
                    alamat[j] = sc.nextLine();

                    System.out.println("+---------------------------+");
                    System.out.println("|       Untuk Golongan      |");
                    System.out.println("+---------------------------+");
                    System.out.println("|  A = Pengawai Paruh Waktu |");
                    System.out.println("|  B = Pengawai Magang      |");
                    System.out.println("|  C = Pengawai Tetap       |");
                    System.out.println("|  D = Manajer              |");
                    System.out.println("+---------------------------+");

                    System.out.print("Masukan Golongan (A-D)     : ");
                    golongan[j] = sc.nextLine();
                    System.out.print("Masukan Waktu lembur (jam) : ");
                    jamLembur[j] = sc.nextInt();

                    if (jenisK.equalsIgnoreCase("p")) {
                        jenisKelamin[j] = "Perempuan";
                    } else if (jenisK.equalsIgnoreCase("l")) {
                        jenisKelamin[j] = "Laki-laki";
                    }

                    hitungPegawai++;

                    // Ask the user if they want to continue
                    System.out.print("Apakah Anda ingin memasukkan data karyawan lagi? (Y/N): ");
                    String continueInput = sc.next();
                    if (!continueInput.equalsIgnoreCase("Y")) {
                        break; // Exit the loop if the user does not want to continue
                    }
                    sc.nextLine(); // Consume the newline character
                }

                // Display summary or perform other actions if needed
                System.out.println("Jumlah pegawai yang telah dimasukkan: " + (hitungPegawai + 1));
            }

            if (kode == 2) {
                for (int i = 0; i <= hitungPegawai; i++) {
                    System.out.println("╔════════════════════════════════════════════╗");
                    System.out.println("║Nama Karyawan     : " + nama[i]);
                    System.out.println("║Golongan Karyawan : " + golongan[i]);
                    System.out.println("║Nomer ID          : " + id[i]);
                    System.out.println("║Jenis Kelamin     : " + jenisKelamin[i]);
                    System.out.println("║Alamat            : " + alamat[i]);
                    System.out.println("║Umur              : " + age[i]);
                    System.out.println("╚════════════════════════════════════════════╝");
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
                        System.out.println("+---------------------------+");
                        System.out.println("|       Untuk Golongan      |");
                        System.out.println("+---------------------------+");
                        System.out.println("|  A = Pengawai Paruh Waktu |");
                        System.out.println("|  B = Pengawai Magang      |");
                        System.out.println("|  C = Pengawai Tetap       |");
                        System.out.println("|  D = Manajer              |");
                        System.out.println("+---------------------------+");

                        System.out.print("Masukan Golongan (A-D) : ");
                        golongan[i] = sc.nextLine();
                        System.out.print("Masukan Waktu lembur (jam) : ");
                        jamLembur[i] = sc.nextInt();

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
                System.out.println("\u001b[32m+---------------------------------------------------------------+");
                System.out.println(
                        "|                       \u001b[0m\u001b[32mJumlah Karyawan                         \u001b[0m\u001b[32m|");
                System.out.println("+---------------------------------------------------------------+\u001b[0m");

                System.out
                        .println("| Jumlah Pegawai Paruh Waktu : " + paruhWaktu + " Orang,                         |");
                System.out.println("| Jumlah Pegawai Magang      : " + magang + " Orang,                         |");
                System.out.println("| Jumlah Pegawai Tetap       : " + tetap + " Orang,                         |");
                System.out.println("| Jumlah manajer             : " + manajer + " Orang,                         |");
                System.out.println("+---------------------------------------------------------------+");
                System.out.println(
                        "| Total Jumlah Pegawai       : " + (hitungPegawai + 1) + " Orang.                         |");
                System.out.println("+---------------------------------------------------------------+");

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
        System.out.print("Enter here: ");
        int selectedMonth = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        // Display the input prompt in a box for displayAll
        System.out.println("╔═════════════════════════════════════════════════════════════════════╗");
        System.out.println("║ Menampilkan gaji untuk semua karyawan? (1 untuk Ya, 0 untuk Tidak): ║");
        System.out.println("╚═════════════════════════════════════════════════════════════════════╝");
        System.out.print("Masukan Disini: ");
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
        pajakBilangan = (pajak / 100.0) * totalGaji[x];

        // Adjust the logic based on the selected month

        System.out.println("\u001b[34m+-----------------------------------------------------------+");
        System.out.println("|                      Slip Gaji Karyawan                   |");
        System.out.println("+-----------------------------------------------------------+\u001b[0m");

        System.out.printf("\u001b[34m| Tanggal              : %-33s  |\n\u001b[0m", "17 - Nov  - 2023");
        System.out.printf("\u001b[34m| Nama                 : %-33s  |\n\u001b[0m", nama[x]);
        System.out.printf("\u001b[34m| Gaji Pokok           : Rp. %-30s |\n\u001b[0m", +gajiPokok);
        System.out.printf("\u001b[34m| Uang Lembur          : Rp. %-30s |\n\u001b[0m", gajiLembur);
        System.out.printf("\u001b[34m| Uang Tunjangan       : Rp. %-30s |\n\u001b[0m", tunjangan);
        System.out.printf("\u001b[34m| Pajak (Persentase)   : %-31s    |\n\u001b[0m", pajak + "%");
        System.out.printf("\u001b[34m| Pajak (Angka)        : Rp. %-30s |\n\u001b[0m", pajakBilangan);
        System.out.printf("\u001b[34m| Gaji Yang Diterim    : Rp. %-30s |\n\u001b[0m", totalGaji[x]);
        System.out.println("\u001b[34m+-----------------------------------------------------------+\u001b[0m");
        System.out.println();
    }

    static void cetakSlipInd(int x, int selectedMonth) {
        perhitungan(x);
        cekPajak(x);
        pajakBilangan = (pajak / 100.0) * totalGaji[x];

        // Adjust the logic based on the selected month

        System.out.println("\u001b[34m+-----------------------------------------------------------+");
        System.out.println("|                      Slip Gaji Karyawan                   |");
        System.out.println("+-----------------------------------------------------------+\u001b[0m");

        System.out.printf("\u001b[34m| Tanggal              : %-33s  |\n\u001b[0m", tanggal);
        System.out.printf("\u001b[34m| Nama                 : %-33s  |\n\u001b[0m", nama[x]);
        System.out.printf("\u001b[34m| Gaji Pokok           : Rp. %-30s |\n\u001b[0m", +gajiPokok);
        System.out.printf("\u001b[34m| Uang Lembur          : Rp. %-30s |\n\u001b[0m", gajiLembur);
        System.out.printf("\u001b[34m| Uang Tunjangan       : Rp. %-30s |\n\u001b[0m", tunjangan);
        System.out.printf("\u001b[34m| Pajak (Persentase)   : %-31s    |\n\u001b[0m", pajak + "%");
        System.out.printf("\u001b[34m| Pajak (Angka)        : Rp. %-30s |\n\u001b[0m", pajakBilangan);
        System.out.printf("\u001b[34m| Gaji Yang Diterim    : Rp. %-30s |\n\u001b[0m", totalGaji[x]);
        System.out.println("\u001b[34m+-----------------------------------------------------------+\u001b[0m");
        System.out.println();
    }

    static void pencarian() {
        System.out.println("+----------------------------------------+");
        System.out.println("|                Pencarian               |");
        System.out.println("+----------------------------------------+");
        System.out.println("| [1] Cari Berdasarkan Nama              |");
        System.out.println("| [2] Cari berdasarkan Nomor Karyawan    | ");
        System.out.println("| [3] Kembali                            |");
        System.out.println("+----------------------------------------+");
        System.out.print("Masukan Pilihan : ");
        int masukan = sc.nextInt();
        sc.nextLine();
        int cari = 0;

        if (masukan == 1) {
            System.out.print("Masukan Nama Karyawan  : ");
            String nama2 = sc.nextLine();
            System.out.println("");

            boolean employeeFound = false;

            for (int i = 0; i < hitungPegawai; i++) {
                if (nama[i].equalsIgnoreCase(nama2)) {
                    employeeFound = true;

                    System.out.println(
                            "\u001b[32m+----------------------------------------------------------------------------------------------------------------+");
                    System.out.println(
                            "|                                             Hasil Pencarian                                                    |");
                    System.out.println(
                            "+----------------------------------------------------------------------------------------------------------------+\u001b[0m");

                    String format = "| %-20s | %-10s | %-14s | %-28s | %-5s | %-18s |\n";

                    System.out.format(format, "Nama Karyawan", "Golongan", "Jenis Kelamin", "Alamat", "Umur",
                            "Nomor ID Karyawan");
                    System.out.println(
                            "+----------------------+------------+----------------+------------------------------+-------+--------------------+");

                    System.out.format(format, nama[i], golongan[i], jenisKelamin[i], alamat[i], age[i], id[i]);

                    System.out.println(
                            "+----------------------------------------------------------------------------------------------------------------+");
                    break;
                }
            }

            if (!employeeFound) {
                System.out.println("\u001b[31mNama yang Anda Masukkan Tidak Terdaftar!\u001b[0m");
            }

        } else if (masukan == 2) {
            System.out.print("Masukan Nomor ID Karyawan : ");
            cari = sc.nextInt();
            System.out.println("");
            boolean employeeFound = false;
            for (int i = 0; i <= hitungPegawai; i++) {
                if (id[i] == cari) {
                    employeeFound = true;

                    System.out.println(
                            "\u001b[32m+----------------------------------------------------------------------------------------------------------------+");
                    System.out.println(
                            "|                                             Hasil Pencarian                                                    |");
                    System.out.println(
                            "+----------------------------------------------------------------------------------------------------------------+\u001b[0m");

                    String format = "| %-20s | %-10s | %-14s | %-28s | %-5s | %-18s |\n";

                    System.out.format(format, "Nama Karyawan", "Golongan", "Jenis Kelamin", "Alamat", "Umur",
                            "Nomor ID Karyawan");
                    System.out.println(
                            "+----------------------+------------+----------------+------------------------------+-------+--------------------+");

                    System.out.format(format, nama[i], golongan[i], jenisKelamin[i], alamat[i], age[i], id[i]);

                    System.out.println(
                            "+----------------------------------------------------------------------------------------------------------------+");
                    break;
                }
            }

            if (!employeeFound) {
                System.out.println("\u001b[31mNama yang Anda Masukkan Tidak Terdaftar!!\u001b[0m");
            }
        }

    }

    static void laporan() {
        int i = 0;
        int pengeluaran = 0;

        System.out.println(
                "\u001b[32m+====================================================================================+");
        System.out.println(
                "|                             \u001b[0m\u001b[32mLaporan Pengeluaran Gaji                               \u001b[0m\u001b[32m|");
        System.out.println(
                "+====================================================================================+\u001b[0m");

        System.out.printf("|     Tanggal: Mon Nov 13 12:00:15 WIB 2023 - %-19s           |\n", tanggal);
        System.out.println("+====================================================================================+");
        System.out.printf("| %-15s | %-12s | %-12s | %-15s | %-16s|\n", "Nama Karyawan", "Jenis Kelamin", "Golongan",
                "Waktu Lembur", "Gaji Karyawan");
        System.out.println("+-----------------+---------------+--------------+-----------------+-----------------|");
        for (int j = 0; j <= hitungPegawai; j++) {
            perhitungan(j);
            System.out.printf("| %-15s | %-13s | %-12s | %-15s | Rp. %-12s|\n", nama[j], jenisKelamin[j], golongan[j],
                    jamLembur[j] + " jam", totalGaji[j]);
            System.out
                    .println("+-----------------+---------------+--------------+-----------------+-----------------|");
            pengeluaran += totalGaji[j];
        }

        System.out.printf(
                "\u001b[33m| Jadi Total Pengeluaran Perusahaan untuk Gaji Seluruh Karyawan = Rp. %-14s |\u001b[0m\n",
                pengeluaran);

        System.out.println("+------------------------------------------------------------------------------------+");

    }

    static void menghapusData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukan Nama Karyawan yang ingin Dihapus:  ");
        String deleteName1 = scanner.nextLine();

        boolean found1 = false;
        for (int i = 0; i <= hitungPegawai; i++) {
            if (nama[i].equalsIgnoreCase(deleteName1)) {
                // Found the employee to delete
                found1 = true;
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
                System.out.println();
                System.out.println("\u001b[32mData karyawan berhasil dihapus.\u001b[0m");
                System.out.println();
                break;
            }
        }

        if (!found1) {
            System.out.println("\u001b[31mNama yang Anda Masukkan Tidak Ditemukan!\u001b[0m");
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
        pajakBilangan = (pajak / 100.0) * totalGaji[x];
        System.out.println("\u001b[34m+-----------------------------------------------------------+");
        System.out.println("|                      Slip Gaji Karyawan                   |");
        System.out.println("+-----------------------------------------------------------+\u001b[0m");

        System.out.printf("\u001b[34m| Tanggal              : %-33s  |\n\u001b[0m", tanggal);
        System.out.printf("\u001b[34m| Nama                 : %-33s  |\n\u001b[0m", nama[x]);
        System.out.printf("\u001b[34m| Gaji Pokok           : Rp. %-30s |\n\u001b[0m", +gajiPokok);
        System.out.printf("\u001b[34m| Uang Lembur          : Rp. %-30s |\n\u001b[0m", gajiLembur);
        System.out.printf("\u001b[34m| Uang Tunjangan       : Rp. %-30s |\n\u001b[0m", tunjangan);
        System.out.printf("\u001b[34m| Pajak (Persentase)   : %-31s    |\n\u001b[0m", pajak + "%");
        System.out.printf("\u001b[34m| Pajak (Angka)        : Rp. %-30s |\n\u001b[0m", pajakBilangan);
        System.out.printf("\u001b[34m| Gaji Yang Diterim    : Rp. %-30s |\n\u001b[0m", totalGaji[x]);
        System.out.println("\u001b[34m+-----------------------------------------------------------+\u001b[0m");
        System.out.println();
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
                System.out.print("Jenis Kelamin (L/P) : ");
                jenisK = sc.nextLine();
                System.out.print("Umur : ");
                age[i] = sc.nextInt();
                System.out.print("Alamat : ");
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

    // Ask the employee to enter their name
    static void withdrawSalary() {
        System.out.println("\u001b[32m+-----------------------------------------------------------+");
        System.out.println(
                "|                    \u001b[0m\u001b[32mSalary Withdrawal                      \u001b[0m\u001b[32m|");
        System.out.println("+-----------------------------------------------------------+\u001b[0m");

        System.out.println("");
        System.out.print("Enter Employee Name for Salary Withdrawal: ");
        String withdrawName = sc.nextLine();

        boolean employeeFound = false;
        for (int i = 0; i <= hitungPegawai; i++) {
            if (nama[i].equalsIgnoreCase(withdrawName)) {
                employeeFound = true;

                System.out.println("Current Salary Information:");
                cetakSlip(i);
                System.out.println("");

                // Ask for withdrawal amount
                System.out.print("Enter Withdrawal Amount: Rp. ");
                int withdrawalAmount = sc.nextInt();
                System.out.println("");
                System.out.println("+----------------------+----------------------+");
                sc.nextLine(); // Consume the newline character
                System.out.printf("| %-20s | %-20s |\n", "Employee Name", "Remaining Salary");
                System.out.println("+----------------------+----------------------+");
                // Check if the withdrawal amount is valid
                if (withdrawalAmount > 0 && withdrawalAmount <= totalGaji[i]) {
                    // Deduct the withdrawal amount from the total salary
                    totalGaji[i] -= withdrawalAmount;

                    System.out.printf("| %-20s | Rp. %-16s |\n", nama[i], totalGaji[i]);
                    System.out.println("+----------------------+----------------------+");

                    System.out.println("\u001b[32mSalary withdrawal successful.\u001b[0m");
                } else {
                    System.out.println("\u001b[31mInvalid withdrawal amount or insufficient balance.\u001b[0m");
                }
                break;
            }
        }

        if (!employeeFound) {
            System.out.println("\u001b[31mThe Name You Entered is Not Found!\u001b[0m");
        }
        System.out.println("");
    }

    static void tarikGaji() {
        System.out.println("\u001b[32m+-----------------------------------------------------------+");
        System.out.println(
                "|                      \u001b[0m\u001b[32mPenarikan Gaji                       \u001b[0m\u001b[32m|");
        System.out.println("+-----------------------------------------------------------+\u001b[0m");

        System.out.println("");
        System.out.print("Masukkan Nama Karyawan yang akan melakukan Penarikan Gaji: ");
        String withdrawName = sc.nextLine();

        boolean employeeFound = false;
        for (int i = 0; i <= hitungPegawai; i++) {
            if (nama[i].equalsIgnoreCase(withdrawName)) {
                employeeFound = true;

                System.out.println("Informasi Gaji Saat Ini:");
                Slip(i);
                System.out.println("");

                // Ask for withdrawal amount
                System.out.print("Masukkan Jumlah Penarikan: Rp. ");
                int withdrawalAmount = sc.nextInt();
                System.out.println("");
                System.out.println("+----------------------+----------------------+");
                sc.nextLine(); // Consume the newline character
                System.out.printf("| %-20s | %-20s |\n", "Nama Karyawan", "Sisa Gaji");
                System.out.println("+----------------------+----------------------+");
                // Check if the withdrawal amount is valid
                if (withdrawalAmount > 0 && withdrawalAmount <= totalGaji[i]) {
                    // Deduct the withdrawal amount from the total salary
                    totalGaji[i] -= withdrawalAmount;

                    System.out.printf("| %-20s | Rp. %-16s |\n", nama[i], totalGaji[i]);
                    System.out.println("+----------------------+----------------------+");

                    System.out.println("\u001b[32mPenarikan gaji berhasil dilakukan.\u001b[0m");
                } else {
                    System.out.println("\u001b[31mJumlah penarikan tidak valid atau saldo tidak mencukupi.\u001b[0m");
                }
                break;
            }
        }

        if (!employeeFound) {
            System.out.println("\u001b[31mNama yang Anda Masukkan Tidak Ditemukan!\u001b[0m");
        }
        System.out.println("");
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

        System.out.println();
        String line = "=================================================================";
        System.out.printf("\u001b[32m%s\n\t     SELAMAT DATANG DI SISTEM PENGGAJIAN \n%s\u001b[0m", line, line);

        System.out.println();
        mainProcess = true;
        System.out.println();
        while (mainProcess) {
            // Menambahkan warna dan font
            System.out.println("");
            System.out.println("\u001b[31mSILAHKAN LOGIN UNTUK MELANJUTKAN AKSES PROGRAM\u001b[0m");
            System.out.println("╔═════════════════════════════════════════════════╗");
            System.out.println("║ 1. Login                                        ║");
            System.out.println("║ 2. Keluar Program                               ║");
            System.out.println("╚═════════════════════════════════════════════════╝");
            System.out.print("Pilih Menu 1 - 2 : ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    menuProcess = true;
                    loginPageAdmin();
                    if (validationAdmin) {
                        System.out.println("+===============================================================+");
                        System.out.println(
                                "|   \u001b[32m                  Selamat Datang Admin!\u001b[0m                     |");
                        System.out.println("+===============================================================+");
                        System.out.println("| Pilihan Bahasa  :                                             |");
                        System.out.println("| [1] English                                                   |");
                        System.out.println("| [2] Indonesian                                                |");
                        System.out.println("+===============================================================+");
                        System.out.print("Pilih Bahasa : ");
                        language = sc.nextInt();
                        if (language == 1) {

                            while (menuProcess) {
                                System.out.println(
                                        "\u001b[32m+===============================================================+");
                                System.out.println(
                                        "|                      * \u001b[0m\u001b[32mMENU OPTIONS \u001b[0m\u001b[32m*                         |");
                                System.out.println(
                                        "+===============================================================+\u001b[0m");
                                System.out.println("| [1] Employee Data                                             |");
                                System.out.println("| [2] Salary Calculation                                        |");
                                System.out.println("| [3] Searching                                                 |");
                                System.out.println("| [4] Report                                                    |");
                                System.out.println("| [5] Delete Data                                               |");
                                System.out.println("| [6] Exit                                                      |");
                                System.out.println("+===============================================================+");
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

                                System.out.println("\u001b[32m+================================================+");
                                System.out.println(
                                        "|                 * \u001b[0m\u001b[32mPILIHAN MENU \u001b[0m\u001b[32m*               |");
                                System.out.println("+================================================+\u001b[0m");

                                System.out.println("| [1] Data Karyawan                              |");
                                System.out.println("| [2] Perhitungan Gaji                           |");
                                System.out.println("| [3] Pencarian                                  |");
                                System.out.println("| [4] Laporan                                    |");
                                System.out.println("| [5] Hapus Data                                 |");
                                System.out.println("| [6] Keluar                                     |");
                                System.out.println("+================================================+");
                                System.out.print("Masukan Menu Pilihan Anda : ");
                                menu = sc.nextInt();

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
                        System.out.println("+===============================================================+");
                        System.out.println(
                                "|   \u001b[32m                  Selamat Datang Karyawan!\u001b[0m                  |");
                        System.out.println("+===============================================================+");
                        System.out.println("| Pilihan Bahasa  :                                             |");
                        System.out.println("| [1] English                                                   |");
                        System.out.println("| [2] Indonesian                                                |");
                        System.out.println("+===============================================================+");
                        System.out.print("Pilih Bahasa : ");
                        language = sc.nextInt();
                        if (language == 2) {
                            while (menuProcess) {
                                System.out.println("\u001b[32m+================================================+");
                                System.out.println(
                                        "|                 * \u001b[0m\u001b[32mPILIHAN MENU \u001b[0m\u001b[32m*               |");
                                System.out.println("+================================================+\u001b[0m");

                                System.out.println("| [1] Tampilkan Gaji                             |");
                                System.out.println("| [2] Edit Data                                  |");
                                System.out.println("| [3] Penarikan Gaji                             |");
                                System.out.println("| [4] Keluar                                     |");
                                System.out.println("+================================================+");
                                System.out.print("Masukan Menu Pilihan Anda : ");
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
                                        tarikGaji();
                                        break;
                                    case 4:
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
                                System.out.println(
                                        "\u001b[32m+===============================================================+");
                                System.out.println(
                                        "|                      * \u001b[0m\u001b[32mMENU OPTIONS \u001b[0m\u001b[32m*                         |");
                                System.out.println(
                                        "+===============================================================+\u001b[0m");

                                System.out.println("| [1] Show Salary                                               |");
                                System.out.println("| [2] Edit Data                                                 |");
                                System.out.println("| [3] Withdraw                                                  |");
                                System.out.println("| [4] Exit                                                      |");
                                System.out.println("+===============================================================+");
                                System.out.print("Choose Menu 1 - 3 : ");
                                menu = sc.nextInt();
                                sc.nextLine();

                                switch (menu) {
                                    case 1:
                                        showGaji();
                                        break;
                                    case 2:
                                        editDataKarIng();
                                        break;
                                    case 3:
                                        withdrawSalary();
                                        break;
                                    case 4:
                                        menuProcess = false;

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
                    mainProcess = false;
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

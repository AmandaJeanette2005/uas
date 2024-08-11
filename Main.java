import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Membuat objek MemberManager
        Member memberManager = new Member(null, null, 0);

        // Menampilkan semua member yang terdaftar
        memberManager.displayMembers();

        // Meminta pengguna memasukkan nama member
        System.out.print("Masukkan Nama Member: ");
        String memberName = scanner.nextLine();

        // Menambahkan member baru
        memberManager.addMember(memberName);

        // Menambah point berdasarkan transaksi
        System.out.print("Masukkan jumlah transaksi: ");
        int transaksi = scanner.nextInt();
        
        // Menambahkan point pada member terakhir yang didaftarkan
        memberManager.tambahPoint(transaksi);

        // Menampilkan daftar hadiah yang bisa ditukar
        System.out.println("Daftar Hadiah:");
        System.out.println("1. Boneka - 10000 point");
        System.out.println("2. Mainan - 7000 point");
        System.out.println("3. Mie Instant - 5000 point");
        System.out.println("4. Biskuit - 4000 point");

        // Menukarkan point dengan hadiah
        System.out.print("Pilih hadiah yang ingin ditukar (masukkan nomor): ");
        int pilihanHadiah = scanner.nextInt();
        
        // Menukarkan point pada member terakhir yang didaftarkan
        memberManager.tukarPoint(pilihanHadiah);

        scanner.close();
    }
}

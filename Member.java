import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Member {
    private String kodeMember;
    private String name;
    private int point;
    
    // Konstruktor untuk menginisialisasi objek Member
    public Member(String kodeMember, String name, int point) {
        this.kodeMember = kodeMember;
        this.name = name;
        this.point = point;
    }

    private List<Member> members = new ArrayList<>();
    private static int counterMembers = 1;

    // Metode getter untuk mengambil KodeMember pelanggan
    public String getKodeMember() {
        return kodeMember;
    }

    // Metode getter untuk mengambil nama pelanggan
    public String getName() {
        return name;
    }

    // Metode getter untuk mengambil point pelanggan
    public int getPoint() {
        return point;
    }

    // Metode toString untuk mengembalikan representasi string dari objek Member
    @Override
    public String toString() {
        return "Kode Member: " + kodeMember + "\nNama Member: " + name + "\nTotal Point: " + point;
    }

    // Metode untuk mendapatkan tanggal saat ini
    private static String getCurrentDate() {
        return new SimpleDateFormat("yyyyMMdd").format(new Date());
    }

    // Metode untuk menambahkan member baru
    public void addMember(String name) {
        String dateNow = getCurrentDate();
        String kodeMember = dateNow + "CUS" + String.format("%04d", counterMembers++);
        int defaultPoint = 0;

        Member newMember = new Member(kodeMember, name, defaultPoint);
        members.add(newMember);
        System.out.println("Member baru berhasil ditambahkan: " + newMember);
    }

    // Metode untuk menampilkan semua member
    public void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("Belum ada member yang terdaftar.");
        } else {
            for (Member member : members) {
                System.out.println(member);
            }
        }
    }
    public void tambahPoint(int transaksi) {
        int tambahanPoint = transaksi / 10000;  // Setiap 10000 rupiah mendapatkan 1 point
        this.point += tambahanPoint;

        System.out.println("Point yang didapat: " + tambahanPoint + ". Total point saat ini: " + this.point);
    }

    // Metode untuk menukar point dengan hadiah
    public void tukarPoint(int pilihanHadiah) {
        int pointDibutuhkan = 0;
        String hadiah = "";

        switch (pilihanHadiah) {
            case 1:
                hadiah = "Boneka";
                pointDibutuhkan = 10000;
                break;
            case 2:
                hadiah = "Mainan";
                pointDibutuhkan = 7000;
                break;
            case 3:
                hadiah = "Mie Instant";
                pointDibutuhkan = 5000;
                break;
            case 4:
                hadiah = "Biskuit";
                pointDibutuhkan = 4000;
                break;
            default:
                System.out.println("Pilihan hadiah tidak valid.");
                return;
        }

        if (this.point >= pointDibutuhkan) {
            this.point -= pointDibutuhkan;
            System.out.println("Anda berhasil menukarkan point dengan " + hadiah + ". Sisa point: " + this.point);
        } else {
            System.out.println("Point Anda tidak mencukupi untuk menukarkan hadiah ini.");
        }
    }

}

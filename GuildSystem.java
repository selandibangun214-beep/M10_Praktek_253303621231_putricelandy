import java.io.*;
import java.util.ArrayList;

public class GuildSystem {
    public static void main(String[] args) {

        // =========================
        // PROSES SAVE (SERIALIZATION)
        // =========================
        ArrayList<Member> daftarMember = new ArrayList<>();

        daftarMember.add(new Member("G001", "Celandy"));
        daftarMember.add(new Member("G002", "putri"));
        daftarMember.add(new Member("G003", "Ariel"));

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream("guild_data.dat"))) {

            oos.writeObject(daftarMember);
            System.out.println("Data guild berhasil disimpan!");

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan data.");
            e.printStackTrace();
        }

        // =========================
        // PROSES LOAD (DESERIALIZATION)
        // =========================
        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream("guild_data.dat"))) {

            ArrayList<Member> hasilLoad =
                    (ArrayList<Member>) ois.readObject();

            System.out.println("\n=== Data Member Hasil Load ===");

            for (Member m : hasilLoad) {
                System.out.println("ID   : " + m.getId());
                System.out.println("Nama : " + m.getNama());
                System.out.println("-------------------");
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Terjadi kesalahan saat membaca data.");
            e.printStackTrace();
        }
    }
}
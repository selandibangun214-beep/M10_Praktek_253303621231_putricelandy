import java.io.Serializable;

public class Member implements Serializable {
    private String id;
    private String nama;

    public Member(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }
}
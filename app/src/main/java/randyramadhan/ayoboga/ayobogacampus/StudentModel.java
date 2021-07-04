package randyramadhan.ayoboga.ayobogacampus;

public class StudentModel {

    private int id;
    private String name;
    private String jk;
    private String date;
    private String address;

    //constructor
    public StudentModel(int id, String name, String jk, String date, String address) {
        this.id = id;
        this.name = name;
        this.jk = jk;
        this.date = date;
        this.address = address;
    }

    public StudentModel() {
    }


    // ToString

    @Override
    public String toString() {
        return "StudentModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jk='" + jk + '\'' +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    // Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

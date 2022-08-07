
public class User {
    private int id;
    private String name;
    private int age;
    private String profession;
    private boolean martialStatus;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public boolean getMartialStatus() {
        return martialStatus;
    }

    public void setMartialStatus(boolean martialStatus) {
        this.martialStatus = martialStatus;
    }

    @Override
    public String toString() {
        return  id + "," + name+ "," +age+ "," +profession+ "," +martialStatus + "\n";
    }
}

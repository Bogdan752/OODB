import java.util.Date;

public class Client implements Comparable<Client>{

    private int id;
    private String name;
    private Date birthDay;

    public Client(int id, String name, Date birthDay) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }



    @Override
    public int compareTo(Client client) {
        if (this.id > client.getId()) return 1;
        else if (this.id < client.getId()) return -1;
        return 0;
    }
}

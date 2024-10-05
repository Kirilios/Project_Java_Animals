package Animals;

public class Animals {
    private String name;
    private String birthday;
    private String type;
    public Animals(String name, String birthday, String type) {
        this.name = name;
        this.birthday = birthday;
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public String getBirthday() {
        return birthday;
    }
    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void showInfo() {
        System.out.println("Name: " + getName() + " | " + "Birthday: " + getBirthday() + " | " + "Type: " + getType());
    }

    public void showActions(){}
}

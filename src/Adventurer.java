import java.util.ArrayList;

public class Adventurer {
    String name;
    int age;
    String role;
    Double goldEarned;
    ArrayList<Adventurer> adventurers;

    public Adventurer(String name, int age, String role, Double goldEarned,  ArrayList<Adventurer> adventurers) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.goldEarned = goldEarned;
        this.adventurers = adventurers;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getRole() {
        return role;
    }
    public Double getGoldEarned() {
        return goldEarned;
    }

    public String toString() {
        return "This is a toString: " + name + age + role + goldEarned;
    }
}

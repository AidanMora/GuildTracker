import java.util.ArrayList;
import java.util.List;

public class Adventurer implements Comparable<Adventurer> {
    private final String name;
    private final int age;
    private final String role;
    private final Double goldEarned;
    private final List<Skill> Skills;

    public Adventurer(String name, int age, String role, Double goldEarned, List<Skill> skills) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.goldEarned = goldEarned;
        this.Skills = skills = new ArrayList<>(skills);
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
    public List<Skill> getSkills() {return new ArrayList<>(Skills);}
    // will create a list of skills that are in the original list, so that this list can be
    // manipulated withouth changing the original list at all.

    public boolean hasSkill(Skill s){ //helper method for the stream filters
        return Skills.contains(s);
    }

    public int getSkillCount(){ // another helper method for stream filters I'm going to make later
        return Skills.size();
    }

    @Override
    public int compareTo(Adventurer o) {
        int byName = String.CASE_INSENSITIVE_ORDER.compare(this.name, o.name);
        return (byName != 0) ? byName : Integer.compare(this.age, o.age);
        // compare case:
            // compare this name with other name, not checking for case
            // if the names are the same, then compare on age
        // if its like testName, 21 compare -> testName2, 50
            // then its negative since testName is younger than testName2
    }


    public String toString() {
        return "This is a toString: " + name + age + role + goldEarned;
    }
}

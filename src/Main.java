import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("~Guild / Skill Tracker~");


        Adventurer Aidan = new Adventurer(
                "Aidan", 21, "Explorer", 2500.00,
                Arrays.asList(Skill.NECROMANCY, Skill.SWORDSMANSHIP,
                        Skill.STEALTH, Skill.HEALING, Skill.INTELLIGENCE)
        );
        Adventurer Jace = new Adventurer(
                "Jace", 21, "Beggar", 3.0,
                Arrays.asList(Skill.THIEVERY, Skill.DECEPTION, Skill.DISEASE)
        );
        Adventurer Josyan = new Adventurer(
                "Josyan", 20, "Stable Cleaner", 350.0,
                Arrays.asList(Skill.HORSEMANSHIP)
        );
        Adventurer Liam = new Adventurer(
                "Liam", 21, "Gypsy", 1205.0,
                Arrays.asList(Skill.THIEVERY, Skill.DECEPTION,Skill.FORTUNETELLING, Skill.GEMCRAFTING)
        );
        Adventurer Jodan = new Adventurer(
                "Jodan", 22, "Nerd", 120.0,
                Arrays.asList(Skill.INTELLIGENCE, Skill.BREWING, Skill.MEMECRAFTING)
        );
        Adventurer Zack = new Adventurer(
                "Zack", 22,"Jester", 210.00,
                Arrays.asList(Skill.GOOFY, Skill.DANCING, Skill.LOUD)
        );
        Adventurer Quinten = new Adventurer(
                "Quinten", 23, "Engineer", 3500.00,
                Arrays.asList(Skill.INTELLIGENCE, Skill.BUILDING)
        );
        Adventurer Nathan = new Adventurer(
                "Nathan", 21, "Wagon Detailer", 1600.00,
                Arrays.asList(Skill.CLEANING, Skill.HORSEMANSHIP, Skill.INTELLIGENCE)
        );



    }

}

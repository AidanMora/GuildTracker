import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("~Guild / Skill Tracker~\n\n");


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
                "Josyan", 20, "Beggar", 350.0,
                Arrays.asList(Skill.THIEVERY, Skill.DISEASE)
        );
        Adventurer Liam = new Adventurer(
                "Liam", 21, "Gypsy", 1205.0,
                Arrays.asList(Skill.THIEVERY, Skill.DECEPTION,Skill.FORTUNETELLING,
                        Skill.GEMCRAFTING, Skill.DISEASE)
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


        Guild bottomFeeders = new Guild ("Bottom Feeders",
                new ArrayList<>(Arrays.asList(Jace, Josyan, Liam)));

        Guild councilOfErmActually = new Guild("Council Of Erm Actually",
                new ArrayList<>(Arrays.asList(Nathan, Jodan, Quinten)));

        Guild coolGuys = new Guild ("Cool Guys",
                new  ArrayList<>(Arrays.asList(Aidan, Zack)));


        List<Guild> guilds =  Arrays.asList(bottomFeeders, coolGuys, councilOfErmActually);

        List<Adventurer> allAdventurers = guilds.stream()
                .flatMap(g -> g.getAdventurers().stream())
                .collect(Collectors.toList()); //define allAdventurers

        //filter adventurers by skill (across guilds)
        System.out.println("1. Any Adventurers with Intelligence skill equipped");
        GuildStreams.filteringBySkill(guilds, Skill.INTELLIGENCE)
                .forEach(System.out::println);


        //Adventurers grouped by skill (across guilds)
        System.out.println("\n2. Role Groups (across guilds)");

        Map<String, List<Adventurer>> rGroups = AdventurerStreams.groupByRole(allAdventurers);
        rGroups.forEach((role, adventurers) -> { //iterate through each k, v pair
            String names = adventurers.stream() //take list of adventurers for each role into a stream
                    .map(Adventurer::getName) //fetch the names for each adventurer that is processing in stream ONLY
                    .collect(Collectors.joining(", ")); // collect, and join the strings nicely
            System.out.println(role + ": " + names);
        });

        //Adventurer with most skills (across guilds)
        System.out.println("\n3. Adventurer(s) With Most Skills");
        List<Adventurer> superSkilled = AdventurerStreams.highestSkillsCount(allAdventurers);

        if (superSkilled.isEmpty()) {
            System.out.println("No Adventurers (go get some friends) :/ ");
        } else {
            superSkilled.forEach(System.out::println);
        }


        System.out.println("\n4. Rank Guilds by Average Adventurer Age");
        GuildStreams.rankGuildsAverageAge(guilds)
                .forEach(System.out::println);

        System.out.println("\n5. Skill-Wise Adventurer Count Map");
        GuildStreams.skillCounts(guilds)
                .forEach((skill, count) -> {
                    System.out.println(skill + ", " + count);
                });









    }

}


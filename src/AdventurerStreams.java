import java.util.*;
import java.util.stream.Collectors;

public final class AdventurerStreams {
    private AdventurerStreams() {}

        //grouping adventurer by role
        public static Map<String, List<Adventurer>> groupByRole(List<Adventurer> adventurers){
            return adventurers.stream()
                    .collect(Collectors.groupingBy(
                            Adventurer::getRole, // Use Adventurer class, get role to use for first stage of grouping
                            TreeMap::new, // store it in a treemap (also makes it sorted into alphabetically by default)
                            Collectors.toList()
                    ));
        }

        //Find adventurer(s) with most skills
        public static List<Adventurer> highestSkillsCount(List<Adventurer> adventurers){
            int highSkillCount = adventurers.stream()
                    .mapToInt(a -> a.getSkills().size()) // adventurer to skillCount
                    .max()// find the max
                    .orElse(0); //but the list COULD be empty so 0
            return adventurers.stream() //now I can filter who has the highestSkillCount
                    .filter(a -> a.getSkills().size() == highSkillCount)
                    .collect(Collectors.toList()); //filter the amount of skills to find adventurers with 'max' skill counts
        }

        public static void bonusGoldEvent(List<Adventurer> adventurers){
            adventurers.stream() //turn adventurers into a stream
                    .filter(a -> a.getGoldEarned() < 1000.0) //filter that stream I made so that ONLY adventurers
                                                                // with less than 1000 gold can continue down stream
                    .forEach(a -> a.setGoldEarned(a.getGoldEarned() * 1.20));
                    // whatever adventurer that passes through it will set their gold to their current gold with a 20% increase
        }


}
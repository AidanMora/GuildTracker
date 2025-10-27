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

        //Find adventurer with most skills
        public static Optional<Adventurer> highestSkillsCount(List<Adventurer> adventurers){
            return adventurers.stream() // turn into a stream
                    .max(Comparator//return largest element from this comparison
                    .comparingInt(a -> a.getSkills().size())); //compare the int of the size of skill list
        }

        public static void bonusGoldEvent(List<Adventurer> adventurers){
            adventurers.stream() //turn adventurers into a stream
                    .filter(a -> a.getGoldEarned() < 1000.0) //filter that stream I made so that ONLY adventurers
                                                                // with less than 1000 gold can continue down stream
                    .forEach(a -> a.setGoldEarned(a.getGoldEarned() * 1.20));
                    // whatever adventurer that passes through it will set their gold to their current gold with a 20% increase
        }


}
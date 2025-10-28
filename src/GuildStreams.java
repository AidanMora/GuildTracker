import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;


/**@Author Aidan Mora
 * Date: 10/28/25
 * streams used for the guild class, used in main
 */
public final class GuildStreams {
    /**
     * Constructor to prevent creating an object of that class (i need help understanding this)
     * it gave error if I didn't have it but
     */
    private GuildStreams(){}

    //flatten the streams into one stream, so I don't have like multiple nested streams in a single stream
    //cus I can't really do anything with that, I can't sort that.
    //In this case it's a stream of guild objects

    /**
     * allAdventurers is similar to a helper so that I can use the allAdventurers as a flattened list, so i don't need to flatten it when I reference them.
     * @param guilds takes list of guilds created
     * @return flat map of adventurers inside of guilds into a singular stream
     * rather than multiple streams of guilds inside a stream (prevents nesting issues)
     */
    private static Stream<Adventurer> allAdventurers(List<Guild> guilds) {
        return guilds.stream()
                .flatMap(g -> g.getAdventurers().stream());
    }



    /**
     * Filter all adventurers from guilds, based on their skills.
     * @param guilds takes list of guilds created
     * @param skill skills each adventurer has to be filtered on
     * @return filtered updated list of adventurers
     */
    public static List<Adventurer> filteringBySkill(List<Guild> guilds, Skill skill) {
        return allAdventurers(guilds)
                .filter(a -> a.getSkills().contains(skill)) //get the skills, then filter adventurers by skills by guild
                .collect(Collectors.toList()); //final destination is List<Adventurer>
    }

    /**
     *Rank guilds average age
     * @param guilds list of guilds created
     * @return comparison of the adventurers pulled from guilds into a stream, then mapping
     * the adventurer to its age, get the average of those adventurer mappings, but if
     * the list is empty then just have age average as 0.0 .
     */
    public static List<Guild> rankGuildsAverageAge(List<Guild>  guilds) {
        return guilds.stream() //create stream turns List<Guild> into stream of my guild obj's
                .sorted(Comparator.comparingDouble( // sort based on double which is defined below this line
                        g->g.getAdventurers().stream() // stream of the guilds adventurers
                                .mapToInt(Adventurer::getAge) // fetch JUST the ages which is mapped to INT using lambda :)
                                .average() // compute the average of (adventurers)
                                .orElse(0.0) //if the guild ends up being empty it will just be 0.0 so no optional error
                ))
                .collect(Collectors.toList()); // the stream funnels back into a List<Guild>
    }

    /**
     * Skill count tree
     * @param guilds takes list of guilds created
     * @return s a stream of all skill enums, for each skill it will count how many adventurers across ALL guilds
     * have it, then build a map with its keys being skill, count
     * if there is a duplicate key it will just keep the first value,
     * finally stores inside enum map
     */
    public static Map<Skill, Long> skillCounts(List<Guild> guilds) {
        return Arrays.stream(Skill.values()).collect(Collectors.toMap( //create stream turns enum of skills into a stream
                // collects into a map
                    //so each skill will have its own map [skill, number] which is its count
                s -> s, // here is the key i define
                s -> allAdventurers(guilds).filter(a -> a.getSkills().contains(s)).count(),
                //will give me a stream of every adventurer across all guilds
                //keep my adventurers who have that specific skill
                //counts the ones that REMAIN
                (a, b) -> a, // if the key is a duplicate just keep the first (im pretty sure this doesn''t matter, but java was giving me issues with not having it.
                () -> new EnumMap <> (Skill.class)
                // enum map is perfect for this since its for enums
        ));
    }
}


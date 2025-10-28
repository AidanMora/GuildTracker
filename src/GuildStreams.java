import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public final class GuildStreams {
    private GuildStreams(){}

    //flatten the streams into one stream, so I don't have like multiple nested streams in a single stream
    //cus I can't really do anything with that, I can't sort that.
    //In this case it's a stream of guild objects
    private static Stream<Adventurer> allAdventurers(List<Guild> guilds) {
        return guilds.stream()
                .flatMap(g -> g.getAdventurers().stream());
    }

    //filter adventurers by skill (across guilds)
    public static List<Adventurer> filteringBySkill(List<Guild> guilds, Skill skill) {
        return allAdventurers(guilds)
                .filter(a -> a.getSkills().contains(skill)) //get the skills, then filter adventurers by skills by guild
                .collect(Collectors.toList()); //final destination is List<Adventurer>
    }

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


import java.util.ArrayList;
import java.util.List;

/**@Author Aidan Mora
 * Date: 10/22/2025
 * Guild.java
 */

/**
 * Guild class, implements comparable
 */
public class Guild implements Comparable<Guild> {
    private String name;
    private List<Adventurer> adventurers;

    /**
     * Constructor for guild
     * @param name name of the guild
     * @param adventurers adventurers in array list that make up guild
     */
    public Guild(String name, ArrayList<Adventurer> adventurers) {
        this.name = name;
        this.adventurers = adventurers;
    }

    public Guild(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return "Guild: " + name;
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    @Override
    public int compareTo(Guild o) {
        return 0;
    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**@Author Aidan Mora
 * Date: 10/22/2025
 *
 */

public class Guild {
    private String name;
    private List<Adventurer> adventurers;

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
        return "This is a toString: " + name;
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }
}

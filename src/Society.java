import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by wasi131 on 6/05/2017.
 */
public class Society extends Politics {

    private long population;
    private Politics POLITICS;

    public Society(long population, Politics politics) {
        this.population = population;
        setGreatness(politics);
    }

    private void setGreatness(Politics politics) {
        this.POLITICS = politics;
        try {
            this.isGreat = politics.isGreat();
        } catch (CivilConflictException e) {
            this.isGreat = false;
        }
    }

    public Politics getPolitics(){
        return POLITICS;
    }

    public long getPopulation() {
        return population;
    }
}
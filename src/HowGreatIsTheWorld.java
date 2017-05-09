import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by wasi131 on 6/05/2017.
 */
public class HowGreatIsTheWorld {
    public static void main(String[] args) {

        Map<AllNations, Society> nationsOfTheWorld = new TreeMap<>();

        boolean greatPolitics = true;
        boolean ungreatPolitics = false;

        nationsOfTheWorld.put(AllNations.Kurdistan,
                new Society((long)(1000000 * (Math.random()*2 + 30)), new Politics(greatPolitics)));
        nationsOfTheWorld.put(AllNations.Taiwan,
                new Society(23520000, new Politics(greatPolitics)));
        nationsOfTheWorld.put(AllNations.Iceland,
                new Society(330823, new Politics(greatPolitics)));
        nationsOfTheWorld.put(AllNations.MostOtherNations,
                new Society(6946149177L, new Politics(ungreatPolitics)));

        List<Thread> countriesBecomingGreatAgain = new ArrayList<>();

        for (Map.Entry<AllNations, Society> society : nationsOfTheWorld.entrySet()){

            String name = society.getKey().toString();
            Society nation = society.getValue();
            long population = nation.getPopulation();

            Runnable populatonMobiliser = new Runnable() {
                @Override
                public void run() {
                    boolean isGreat = false;
                    for (long count = 0; !isGreat && count < population; count++) {
                        try {
                            isGreat = nation.isGreat();
                            System.out.println("Is " + name + " great? true");
                            System.out.println(name + " is great again!");
                        } catch (CivilConflictException e) {
                            System.out.println(name + "isn't great!");
                            e.getMessage();
                            nation.getPolitics().makeGreatAgain(population);
                        }
                    }
                }
            };

            try {
                System.out.println("Is "+ name + " great? " + nation.isGreat());
            } catch (CivilConflictException e) {
                Thread socialTransformation = new Thread(populatonMobiliser);
                socialTransformation.start();
                countriesBecomingGreatAgain.add(socialTransformation);
            }
        }
    }
}
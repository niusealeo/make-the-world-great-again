import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by wasi131 on 6/05/2017.
 */
public class Politics{
    
    protected boolean isGreat;
    private boolean socialCohesion;
    private List<Thread> activeCitizensMakingItGreatAgain;

    public Politics(boolean isGreat) {
        this.setGreatness(isGreat);
        activeCitizensMakingItGreatAgain = new ArrayList<>();
    }

    public Politics() {
    }

    private void setGreatness(boolean isGreat) {
        this.isGreat = isGreat;
        this.socialCohesion = isGreat;
    }

    protected boolean isGreat() throws CivilConflictException {
        if (!isGreat) throw new CivilConflictException("The people are distressed, unhappy and oppressed!");
        else return isGreat;
    }

    protected void makeGreatAgain(long population) {
        if (socialCohesion) setGreatness(socialCohesion);
        else {

            Double citizenPart = Math.pow(population,-1);

            Runnable empowerment = new Runnable() {
                @Override
                public void run() {
                    makeSocialCohesionGreatAgain();
                }

                private void makeSocialCohesionGreatAgain() {
                    ThreadLocalRandom tlr = ThreadLocalRandom.current();
                    while (!socialCohesion) {
                        if (tlr.nextDouble() < citizenPart)
                            socialCohesion = true;
                    }
                }
            };

            Thread activeCitizen = new Thread(empowerment);
            activeCitizen.start();
            activeCitizensMakingItGreatAgain.add(activeCitizen);
        }
    }
}
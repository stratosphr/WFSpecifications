package petrinets;

/**
 * Created by stratosphr on 09/03/15.
 */
public class WFNet extends PetriNet {

    private Place source;
    private Place sink;

    public Place getSource() {
        for (Place p : places) {
            if (p.getPreset().isEmpty()) {
                return p;
            }
        }
        return null;
    }

    public Place getSink() {
        for (Place p : places) {
            if (p.getPostset().isEmpty()) {
                return p;
            }
        }
        return null;
    }

}

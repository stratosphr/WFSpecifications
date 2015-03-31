package petrinets;

import java.util.ArrayList;

/**
 * Created by stratosphr on 09/03/15.
 */
public class PetriNet {

    protected ArrayList<Place> places;
    protected ArrayList<Transition> transitions;
    private ArrayList<Flow> flows;

    public PetriNet() {
        places = new ArrayList<Place>();
        transitions = new ArrayList<Transition>();
        flows = new ArrayList<Flow>();
    }

    public void addPlace(Place place) {
        places.add(place);
    }

    public void addTransition(Transition transition) {
        transitions.add(transition);
    }

    public void addFlow(Flow flow) {
        flows.add(flow);
        flow.getSource().addPost(flow.getTarget());
    }

    @Override
    public String toString() {
        String ret = "";
        for (Flow f : flows) {
            ret += f + "\n";
        }
        return ret;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public ArrayList<Node> getNodes() {
        ArrayList<Node> nodes = new ArrayList<Node>();
        for (Place p : places) {
            nodes.add(p);
        }
        for (Transition t : transitions) {
            nodes.add(t);
        }
        return nodes;
    }

}

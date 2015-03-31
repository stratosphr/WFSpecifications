package petrinets;

/**
 * Created by stratosphr on 09/03/15.
 */
public class Flow {

    private Node target;
    private Node source;

    public Flow(Node source, Node target) {
        this.source = source;
        this.target = target;
    }

    public Node getSource() {
        return source;
    }

    public Node getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return source + " --> " + target;
    }
}

package petrinets;

import java.util.ArrayList;

/**
 * Created by stratosphr on 09/03/15.
 */
public class Node {

    private ArrayList<Node> preset;
    private ArrayList<Node> postset;
    private String name;

    public Node(String id) {
        this.name = id;
        preset = new ArrayList<Node>();
        postset = new ArrayList<Node>();
    }

    @Override
    public String toString() {
        return name;
    }

    public void addPost(Node target) {
        postset.add(target);
        target.addPre(this);
    }

    private void addPre(Node source) {
        preset.add(source);
    }

    public ArrayList<Node> getPostset() {
        return postset;
    }

    public ArrayList<Node> getPreset() {
        return preset;
    }

}

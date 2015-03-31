package codegeneration.prolog;

import tools.StringTools;

/**
 * Created by stratosphr on 30/03/15.
 */
public class PlList extends PlTerm {

    private PlTerm[] elements;

    public PlList() {
        this(new PlTerm[0]);
    }

    public PlList(PlTerm[] elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "[" + StringTools.join(elements, ", ") + "]";
    }

}

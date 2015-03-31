package specifications;

import tools.StringTools;

/**
 * Created by stratosphr on 30/03/15.
 */
public class DisjunctionFormula extends CompoundFormula {

    public DisjunctionFormula() {
        super();
    }

    public DisjunctionFormula(Formula[] children) {
        super(children);
    }

    @Override
    public String toString() {
        return "or(" + StringTools.join(children, ", ") + ")";
    }

}

package specifications;

import tools.StringTools;

/**
 * Created by stratosphr on 30/03/15.
 */
public class ConjunctionFormula extends CompoundFormula {

    public ConjunctionFormula() {
        super();
    }

    public ConjunctionFormula(Formula[] formulas) {
        super(formulas);
    }

    @Override
    public String toString() {
        return "and(" + StringTools.join(children, ", ") + ")";
    }

}

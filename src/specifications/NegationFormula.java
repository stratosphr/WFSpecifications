package specifications;

import tools.StringTools;

/**
 * Created by stratosphr on 30/03/15.
 */
public class NegationFormula extends CompoundFormula {

    public NegationFormula() {
        super();
    }

    public NegationFormula(Formula child) {
        setChild(child);
    }

    public void setChild(Formula child){
        this.children = new Formula[]{child};
    }

    @Override
    public void addChild(Formula child) {
        System.err.println("Unable to add child to instance of NegationFormula. Use setChild(Formula child) instead.");
    }

    @Override
    public void addChildren(Formula[] children) {
        System.err.println("Unable to add children to instance of NegationFormula. Use setChild(Formula child) instead.");
    }

    @Override
    public String toString() {
        return "not(" + StringTools.join(children, ", ") + ")";
    }

}

package specifications;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by stratosphr on 30/03/15.
 */
public abstract class CompoundFormula extends Formula {

    protected Formula[] children;

    public CompoundFormula() {
    }

    public CompoundFormula(Formula[] children) {
        addChildren(children);
    }

    public void addChild(Formula child) {
        addChildren(new Formula[]{child});
    }

    public void addChildren(Formula[] children) {
        ArrayList<Formula> allChildren = new ArrayList();
        if (this.children != null) {
            allChildren.addAll(Arrays.asList(this.children));
        }
        allChildren.addAll(Arrays.asList(children));
        this.children = allChildren.toArray(new Formula[0]);
    }

    public Formula[] getChildren() {
        return children;
    }

}

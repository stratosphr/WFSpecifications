package codegeneration.prolog;

import tools.StringTools;

/**
 * Created by stratosphr on 30/03/15.
 */
public class PlConjunction extends PlCompoundBooleanExpression {

    public PlConjunction(PlTerm[] children) {
        super(children);
    }

    @Override
    public String toString() {
        return "(" + StringTools.join(children, ", ") + ")";
    }

}

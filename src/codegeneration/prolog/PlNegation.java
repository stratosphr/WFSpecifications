package codegeneration.prolog;

import tools.StringTools;

/**
 * Created by stratosphr on 30/03/15.
 */
public class PlNegation extends PlCompoundBooleanExpression {

    public PlNegation(PlTerm child){
        super(new PlTerm[]{child});
    }

    @Override
    public String toString() {
        return "\\+ " + children[0];
    }

}

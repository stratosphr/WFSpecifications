package codegeneration.prolog;

import tools.StringTools;

/**
 * Created by stratosphr on 30/03/15.
 */
public class PlCompoundBooleanExpression extends PlBooleanExpression {

    protected PlTerm[] children;

    public PlCompoundBooleanExpression(PlTerm[] children){
        this.children = children;
    }

    public void setChildren(PlCompoundBooleanExpression[] children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return StringTools.join(children, " ");
    }

}

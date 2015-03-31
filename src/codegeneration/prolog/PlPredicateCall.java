package codegeneration.prolog;

import tools.StringTools;

/**
 * Created by stratosphr on 30/03/15.
 */
public class PlPredicateCall extends PlBooleanExpression {

    private String name;
    private PlTerm[] parameters;

    public PlPredicateCall(String name){
        this(name, new PlTerm[0]);
    }

    public PlPredicateCall(String name, PlTerm[] parameters) {
        this.name = name;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return name + ((parameters.length == 0) ? "" : "(" + StringTools.join(parameters, ", ") + ")");
    }

}

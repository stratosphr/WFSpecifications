package codegeneration.prolog;

import tools.StringTools;

/**
 * Created by stratosphr on 30/03/15.
 */
public class PlPredicateDeclaration {

    private String name;
    private PlTerm[] parameters;
    private PlBooleanExpression[] body;

    public PlPredicateDeclaration(String name) {
        this(name, new PlTerm[0], new PlBooleanExpression[0]);
    }

    public PlPredicateDeclaration(String name, PlTerm[] parameters) {
        this(name, parameters, new PlBooleanExpression[0]);
    }

    public PlPredicateDeclaration(String name, PlTerm[] parameters, PlBooleanExpression[] body) {
        this.name = name;
        this.parameters = (parameters == null) ? new PlTerm[0] : parameters;
        this.body = (body == null) ? new PlBooleanExpression[0] : body;
    }

    @Override
    public String toString() {
        return name + ((parameters.length == 0) ? ((body.length == 0) ? "." : ":-\n\t" + StringTools.join(body, ",\n\t") + ".") : "(" + StringTools.join(parameters, ", ") + ")" + ((body.length == 0) ? "." : ":-\n\t" + StringTools.join(body, ",\n\t") + "."));
    }

}

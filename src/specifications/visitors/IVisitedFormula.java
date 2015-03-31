package specifications.visitors;

import codegeneration.prolog.PlCompoundBooleanExpression;

/**
 * Created by stratosphr on 10/03/15.
 */
public interface IVisitedFormula {

    public PlCompoundBooleanExpression accept(SicstusFormulaVisitor visitor);

}

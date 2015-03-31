package specifications;

import codegeneration.prolog.PlCompoundBooleanExpression;
import specifications.visitors.IVisitedFormula;
import specifications.visitors.SicstusFormulaVisitor;

/**
 * Created by stratosphr on 30/03/15.
 */
public abstract class Formula implements IVisitedFormula {

    @Override
    public PlCompoundBooleanExpression accept(SicstusFormulaVisitor visitor) {
        if(this instanceof ConjunctionFormula){
            return visitor.visit((ConjunctionFormula) this);
        }else if(this instanceof DisjunctionFormula){
            return visitor.visit((DisjunctionFormula) this);
        }else if(this instanceof NegationFormula){
            return visitor.visit((NegationFormula) this);
        }else{
            return visitor.visit((TransitionFormula) this);
        }
    }

}

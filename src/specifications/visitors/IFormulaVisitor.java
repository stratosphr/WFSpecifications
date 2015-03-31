package specifications.visitors;

import specifications.ConjunctionFormula;
import specifications.DisjunctionFormula;
import specifications.NegationFormula;
import specifications.TransitionFormula;

/**
 * Created by stratosphr on 10/03/15.
 */
public interface IFormulaVisitor {

    public Object visit(ConjunctionFormula conjunctionFormula);

    public Object visit(DisjunctionFormula disjunctionFormula);

    public Object visit(TransitionFormula transitionFormula);

    public Object visit(NegationFormula negationFormula);

}
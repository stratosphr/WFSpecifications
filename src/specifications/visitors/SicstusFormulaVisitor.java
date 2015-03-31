package specifications.visitors;

import codegeneration.prolog.*;
import specifications.*;

/**
 * Created by stratosphr on 10/03/15.
 */
public class SicstusFormulaVisitor implements IFormulaVisitor {

    @Override
    public PlCompoundBooleanExpression visit(ConjunctionFormula conjunctionFormula) {
        PlConjunction ret = new PlConjunction(new PlTerm[]{});
        PlCompoundBooleanExpression[] children = new PlCompoundBooleanExpression[conjunctionFormula.getChildren().length];
        int i = 0;
        for (Formula child : conjunctionFormula.getChildren()) {
            children[i++] = (PlCompoundBooleanExpression) child.accept(this);
        }
        ret.setChildren(children);
        return ret;
    }

    @Override
    public PlCompoundBooleanExpression visit(DisjunctionFormula disjunctionFormula) {
        PlDisjunction ret = new PlDisjunction(new PlTerm[]{});
        PlCompoundBooleanExpression[] children = new PlCompoundBooleanExpression[disjunctionFormula.getChildren().length];
        int i = 0;
        for (Formula child : disjunctionFormula.getChildren()) {
            children[i++] = (PlCompoundBooleanExpression) child.accept(this);
        }
        ret.setChildren(children);
        return ret;
    }

    @Override
    public PlCompoundBooleanExpression visit(TransitionFormula transitionFormula) {
        return new PlCompoundBooleanExpression(new PlTerm[]{
                new PlTerm("VT_" + transitionFormula.getName()),
                new PlTerm("#>"),
                new PlTerm("0")
        });
    }

    @Override
    public PlCompoundBooleanExpression visit(NegationFormula negationFormula) {
        PlCompoundBooleanExpression ret;
        if (negationFormula.getChildren().length == 0) {
            ret = new PlCompoundBooleanExpression(new PlTerm[]{});
        } else {
            ret = new PlConjunction(new PlTerm[]{
                    new PlNegation(negationFormula.getChildren()[0].accept(this))
            });
        }
        return ret;
    }

}

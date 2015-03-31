package codegeneration.prolog.finitedomains;

import codegeneration.prolog.PlList;
import codegeneration.prolog.PlPredicateCall;
import codegeneration.prolog.PlTerm;

/**
 * Created by stratosphr on 30/03/15.
 */
public class PlFDSum extends PlPredicateCall {

    public PlFDSum(PlList members, PlTerm operator, PlTerm result) {
        super("sum", new PlTerm[]{
                members,
                operator,
                result
        });
    }

}

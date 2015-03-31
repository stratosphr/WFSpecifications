package codegeneration.prolog.finitedomains;

import codegeneration.prolog.PlList;
import codegeneration.prolog.PlPredicateCall;
import codegeneration.prolog.PlTerm;

/**
 * Created by stratosphr on 30/03/15.
 */
public class PlFDDomain extends PlPredicateCall {

    public PlFDDomain(PlList vars, PlTerm inf, PlTerm sup) {
        super("domain", new PlTerm[]{
                vars,
                inf,
                sup
        });
    }

}

package codegeneration.prolog.finitedomains;

import codegeneration.prolog.PlList;
import codegeneration.prolog.PlPredicateCall;
import codegeneration.prolog.PlTerm;

/**
 * Created by stratosphr on 30/03/15.
 */
public class PlFDLabeling extends PlPredicateCall{

    public PlFDLabeling(PlList vars) {
        super("labeling", new PlTerm[]{
                new PlList(),
                vars
        });
    }

}

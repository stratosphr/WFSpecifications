package codegeneration.prolog;

import tools.StringTools;

/**
 * Created by stratosphr on 30/03/15.
 */
public class PlTerm {

    private final String name;

    public PlTerm(){
        this.name = "";
    }

    public PlTerm(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}

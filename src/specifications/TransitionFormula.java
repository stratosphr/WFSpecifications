package specifications;

/**
 * Created by stratosphr on 30/03/15.
 */
public class TransitionFormula extends Formula {

    private String name;

    public TransitionFormula(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}


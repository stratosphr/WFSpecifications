package specifications;

/**
 * Created by stratosphr on 30/03/15.
 */
public class Specification {

    private Formula formula;
    private SpecificationType type;

    public Specification(SpecificationType type, Formula f){
        this.type = type;
        this.formula = f;
    }

    public SpecificationType getType() {
        return type;
    }

    public Formula getFormula() {
        return formula;
    }

}

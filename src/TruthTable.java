import java.util.List;
import java.util.HashMap;

public class TruthTable {
    private List <Parameter> parameters;
    private HashMap <boolean[],Boolean> values;

    public TruthTable(List<Parameter> parameters, HashMap<boolean[],Boolean> values){
            this.values=values;
            this.parameters=parameters;
    }
    public HashMap<boolean[], Boolean> getValues() {
        return values;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public boolean equals(TruthTable otherTable){
        return this.equals(otherTable);
    }
}

import java.util.List;

public class Statement {

    private TruthTable truthTable;

    public Statement (String expression) {

    }

    private Statement (TruthTable truthTable){
        this.truthTable = truthTable;
    }
    public TruthTable getTruthTable() {
        return truthTable;
    }
    public List<Parameter> getParameters(){
        return truthTable.getParameters();
    }

    public boolean equals ( Statement other){
        return truthTable.equals(other.getTruthTable());
    }
}

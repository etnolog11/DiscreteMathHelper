
public class Parameter {

    final private String name;

    public Parameter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean[] getValues(boolean trueToFalse) {
        return trueToFalse ? new boolean[]{true, false} : new boolean[]{false, true};
    }

    public boolean equals(Parameter other){
        return this.name.equals(other.getName());
    }

    @Override
    public String toString() {
        return name;
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiPredicate;

class Operations {
    static HashMap <String, BiPredicate> shortNames = new HashMap<String,BiPredicate>();
    static {
        shortNames.put("and",(BiPredicate<Boolean, Boolean>) (aBoolean, aBoolean2) ->  aBoolean && aBoolean2);

    }
    public static Statement process(Statement first,Statement second, String operation){
        TruthTable originalFirst = first.getTruthTable();
        TruthTable originalSecond = second.getTruthTable();
        List<Parameter> newParams = new ArrayList<Parameter>(originalFirst.getParameters());
        //add new parameters if there are any
        for (Parameter parameter:originalSecond.getParameters()){
            if(!newParams.contains(parameter)){
                newParams.add(parameter);
            }
        }
        List<boolean[]> newKeys = new ArrayList<boolean[]>();
        //if there are new parameters generate new keys else copy the old ones.
        if (originalFirst.getParameters().size()!= newParams.size()){
            int keySize=newParams.size();
            int keysSize = 2<<keySize-1;
            boolean [] lastKey = new boolean [keySize];
            for (int i = 0; i < keysSize ; i++) {
                boolean [] currentKey = new boolean [keySize];
                for (int positonInKey = 0; positonInKey < keySize; positonInKey++) {
                    int finalposition= keySize-positonInKey-1;//Invert the key
                    currentKey[finalposition]= (i % ((2 << positonInKey) / 2) == 0) != lastKey[finalposition];
                }
                lastKey = currentKey.clone();
                newKeys.add(currentKey);
            }
        }
        else {
            newKeys= new ArrayList<>(first.getTruthTable().getValues().keySet());
        }
        HashMap<boolean[],Boolean> newAnswers =new HashMap<boolean[], Boolean>();
        for (boolean[] keys:newKeys){
            
        }
        TruthTable newTruthTable= new TruthTable(newParams,newAnswers);
        return new Statement("sffd");
    }

}

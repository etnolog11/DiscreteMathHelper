import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;

class Operations {
    static HashMap <String, BiPredicate> shortNames = new HashMap<String,BiPredicate>();
    static {
        shortNames.put("and",(BiPredicate<Boolean, Boolean>) (aBoolean, aBoolean2) ->  aBoolean && aBoolean2);

    }
    //TODO check if all of the key counts have INT and not SHORT
    private static TruthTable addMissingParameters(TruthTable oldTable, List<boolean[]> newKeys,List<Parameter> newParams){
        HashMap<Integer,Integer> transformIndexFromNewToOld = new HashMap<>();
        HashMap<Integer,Integer> transformIndexFromOldToNew = new HashMap<>();
        List<Parameter> oldParams = oldTable.getParameters();
        //create transform dictionary
        for (int i = 0; i < oldParams.size() ; i++) {
            for(int j = 0; j < newParams.size();j++){
                if (oldParams.get(i).equals(newParams.get(j))){
                    transformIndexFromNewToOld.put(j,i);
                    transformIndexFromOldToNew.put(i,j);
                }
            }
        }
        /*
        for every final key find the corresponding original key and get the value to that key
        */
        HashMap<boolean[],Boolean> newValues = new HashMap<boolean[],Boolean>();
        boolean[] oldkey= new boolean[oldParams.size()];
        for (boolean[] key:newKeys) {
            for (int i = 0; i < oldParams.size(); i++) {
                oldkey[i]= key [transformIndexFromOldToNew.get(i)];
            }
            newValues.put(key,oldTable.getValues().get(oldkey));
        }
        return new TruthTable(newParams,newValues);
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

        if (newParams.size()!=originalFirst.getParameters().size()){
            originalFirst=addMissingParameters(originalFirst, newKeys,newParams);
        }
        if(newParams.size()!=originalSecond.getParameters().size()){
            originalSecond=addMissingParameters(originalSecond, newKeys,newParams);
        }
        HashMap<boolean[],Boolean> newAnswers =new HashMap<boolean[], Boolean>();
        /*TODO fuse to tables. First make a map of keys with parameter in different orders and then apply BiPredicate on a key and mapped key to get the final value
         make sure the order matches with new keys and parameters*/
        for (boolean[] keys:newKeys){

        }
        TruthTable newTruthTable= new TruthTable(newParams,newAnswers);
        return new Statement("sffd");
    }

}

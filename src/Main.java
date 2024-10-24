import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiPredicate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

        public static void keys (int keySize){
            int keysSize = 2<<keySize-1;
            boolean [] lastKey = new boolean [keySize];
            for (int i = 0; i < keysSize ; i++) {
                boolean [] currentKey = new boolean [keySize];
                for (int positonInKey = 0; positonInKey < keySize; positonInKey++) {
                    int finalposition= keySize-positonInKey-1;//Invert the key
                    currentKey[finalposition]= (i % ((2 << positonInKey) / 2) == 0) != lastKey[finalposition];
                }
                lastKey = currentKey.clone();
                System.out.println(Arrays.toString(currentKey));
            }
        }
        public static void main(String[] args) {
            keys(3);
        }
}
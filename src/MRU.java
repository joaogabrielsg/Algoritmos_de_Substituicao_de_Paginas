/**
 * Created by joaogabriel on 08/07/17.
 */

import java.util.ArrayList;
import java.util.List;

public class MRU {
    public static int hint(ArrayList<Reference> referenceStandart, int frames){

        ArrayList<Integer> memory = new ArrayList<>(frames);
        ArrayList<Integer> list = new ArrayList<>(frames);

        int hints = 0;

        for (Reference reference: referenceStandart) {

            if (memory.contains(reference.value)){
                hints++;
                list.remove(list.indexOf(reference.value));
                list.add(reference.value);
            }else{
                if (memory.size() < frames){

                    memory.add(reference.value);
                    list.add(reference.value);

                }else {
                    Integer element = list.get(0);
                    memory.set(memory.indexOf(element), reference.value);

                    list = new ArrayList<>(list.subList(1, frames));
                    list.add(reference.value);
                }
            }
        }
        return hints;
    }
}

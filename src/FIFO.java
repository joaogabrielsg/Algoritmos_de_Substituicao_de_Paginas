import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaogabriel on 08/07/17.
 */
public class FIFO {
    public static int hint(ArrayList<Reference> referenceStandart, int frames){

        ArrayList<Integer> memory = new ArrayList<>(frames);
        ArrayList<Integer> list = new ArrayList<>(frames);

        int hints = 0;

        for (Reference reference: referenceStandart) {

            if (memory.contains(reference.value)){
                hints++;
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

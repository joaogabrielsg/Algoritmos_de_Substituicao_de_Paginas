/**
 * Created by joaogabriel on 10/07/17.
 */


import java.util.ArrayList;

public class Best {
    public static int hint(ArrayList<Reference> references, int frames){

        ArrayList<Integer> memory = new ArrayList<>(frames);
        ArrayList<Integer> list = new ArrayList<>(frames);

        int hits = 0;
        int faults = 0;

        for (int i = 0; i < references.size(); i++) {
            Reference reference = references.get(i);
            if (memory.contains(reference.value)){
                hits++;
            } else {
                faults++;
                if (memory.size() < frames) {

                    memory.add(reference.value);
                    list.add(reference.value);

                } else {

                    ArrayList<Reference> referenceSubList = new ArrayList<>(references.subList(i, references.size() - 1));
                    ArrayList<Integer> listSubList = (ArrayList<Integer>) list.clone();

                    for(Reference reference1: referenceSubList) {
                        if (listSubList.size() == 1) {
                            break;
                        } else {
                            if (listSubList.contains(reference1.value)){
                                listSubList.remove(reference1.value);
                            }
                        }
                    }

                    Integer element = listSubList.get(0);

                    memory.set(memory.indexOf(element), reference.value);

                    list.remove(element);
                    list.add(reference.value);
                }
            }
        }

        return hits;
    }
}

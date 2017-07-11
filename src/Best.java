/**
 * Created by joaogabriel on 10/07/17.
 */

import java.util.ArrayList;

public class Best {
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

                    ArrayList<Reference> referenceSubList = new ArrayList<>(referenceStandart.subList(referenceStandart.indexOf(reference), referenceStandart.size() - 1));
                    ArrayList<Integer> listSubList = list;

                    for(Reference reference1: referenceSubList){
                        if (listSubList.size() == 1){
                            break;
                        }else {
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

        return hints;
    }
}

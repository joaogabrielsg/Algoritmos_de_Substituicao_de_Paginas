import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaogabriel on 08/07/17.
 */
public class SubstitutionAlgorithm {

    public int frames;
    public ArrayList<String> memory;
    public List<String> list;

    public SubstitutionAlgorithm(int frames) {
        this.frames = frames;
        this.memory = new ArrayList<String>(frames);
        this.list = new ArrayList<String>(frames);
    }

    public int hint(ArrayList<String> referenceStandart){

        memory.clear();
        list.clear();

        int hints = 0;

        for (String index: referenceStandart) {
            switch (index){
                case "45":
                    break;
                case "82":
                    break;
                case "87":
                    break;
                default:
                    if (memory.contains(index)){
                        hints++;
                    }else{
                        if (memory.size() < frames){

                            memory.add(index);
                            list.add(index);

                        }else {
                            String element = list.get(0);
                            memory.set(memory.indexOf(element), index);

                            list = list.subList(1, frames);
                            list.add(index);
                        }
                    }
            }
        }
        return hints;
    }
}

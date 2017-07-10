import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaogabriel on 08/07/17.
 */
public class SecondChance {

    public ArrayList<Integer> memory;
    public List<Page> list;

    public int hints = 0;
    public int quantityFrames = 0;

    public SecondChance(int frames) {
        this.memory = new ArrayList<>(frames);
        this.list = new ArrayList<>(frames);
        this.hints = 0;
        this.quantityFrames = 0;
    }

    public void clearBitRAtList(int time){
        if (quantityFrames == time){
            quantityFrames = 0;
            for (Page page: list) {
                page.R = 0;
            }
        }
    }

    public void setPageInMemory(Reference reference){
        hints++;
        for(Page page: list){
            if(page.value == reference.value.intValue()){
                Page newPage = new Page(reference);
                list.set(list.indexOf(page), newPage);
            }
        }
    }


    public void addPageInMemory(int frames, Reference reference){
        //Has space in memory
        if (memory.size() < frames){

            memory.add(reference.value);
            Page newPage = new Page(reference);
            list.add(newPage);

        //There is no space in the memory
        }else {
            while (list.get(0).R != 0){
                Integer firstValue = list.get(0).value;

                list = new ArrayList<>(list.subList(1, frames));
                list.add(new Page(0, 0, firstValue));
            }

            Integer element = list.get(0).value;
            memory.set(memory.indexOf(element), reference.value);

            list = new ArrayList<>(list.subList(1, frames));
            Page newPage = new Page(reference);
            list.add(newPage);
        }
    }


    public static int hint(ArrayList<Reference> referenceStandart, int frames, int time){

        SecondChance secondChance = new SecondChance(frames);

        for(Reference reference: referenceStandart){

            if(secondChance.memory.contains(reference.value)){
                secondChance.setPageInMemory(reference);
            }else {
                secondChance.addPageInMemory(frames, reference);
            }

            secondChance.quantityFrames++;
            secondChance.clearBitRAtList(time);
        }
        return secondChance.hints;
    }
}

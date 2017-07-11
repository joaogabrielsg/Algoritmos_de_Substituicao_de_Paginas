import java.util.ArrayList;
import java.util.List;

/**
 * Created by joaogabriel on 09/07/17.
 */
public class NUR {
    public ArrayList<Integer> memory;
    public List<Page> list;

    public int hints = 0;
    public int quantityFrames = 0;

    public NUR(int frames) {
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
                if (page.M > newPage.M){
                    newPage.M = page.M;
                }
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

            int smallerClassPage = 5;
            int indexsmallerClassPage = 0;

            for (Page page: list){
                if(page.getPageClass() < smallerClassPage){
                    indexsmallerClassPage = list.indexOf(page);
                    smallerClassPage = page.getPageClass();
                }
            }

            Page index = list.get(indexsmallerClassPage);

            int index2 = memory.indexOf(index.value);
            memory.set(index2, reference.value);

            list.remove(indexsmallerClassPage);
            Page newPage = new Page(reference);
            list.add(newPage);
        }
    }

    public static int hint(ArrayList<Reference> referenceStandart, int frames, int time){

        NUR nur = new NUR(frames);


        for(Reference reference: referenceStandart){

            if(nur.memory.contains(reference.value)){
                nur.setPageInMemory(reference);
            }else {
                nur.addPageInMemory(frames, reference);
            }

            nur.quantityFrames++;
            nur.clearBitRAtList(time);
        }

        return nur.hints;
    }
}
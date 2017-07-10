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
            if(page.value == reference.value){
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

//        for (String index: referenceStandart) {
//            switch (index){.
//                case "45":
//                    quantityFrames++;
//                    if (quantityFrames == time){
//                        quantityFrames = 0;
//                        for (Page page: list) {
//                            page.R = 0;
//                        }
//                    }
//                    break;
//                case "82":
//                    Page pageRead = new Page(1, 0, list.get(position).value);
//                    list.set(position, pageRead);
//                    break;
//                case "87":
//                    Page pageWrite = new Page(1, 1, list.get(position).value);
//                    list.set(position, pageWrite);
//                    break;
//                default:
//                    if (memory.contains(index)){
//                        hints++;
//                        for(Page page: list){
//                            if(page.value == index){
//                                Page newPage = new Page(1, 0, index);
//                                list.set(list.indexOf(page), newPage);
//                                position = list.indexOf(newPage);
//                            }
//                        }
//                    }else{
//                        if (memory.size() < frames){
//
//                            memory.add(index);
//                            Page newPage = new Page(1, 0, index);
//                            list.add(newPage);
//                            position = list.indexOf(newPage);
//                        }else {
//                            int classR = 0;
//                            int classM = 0;
//                            while (list.size() == frames){
//                                for(Page page: list){
//                                    if(page.R == classR && page.M == classM){
//                                        list.remove(page);
//                                        break;
//                                    }
//                                }
//                            }
//
//                            String element = list.get(0).value;
//                            memory.set(memory.indexOf(element), index);
//
//                            list = list.subList(1, frames);
//                            Page newPage = new Page(1, 0, index);
//                            list.add(newPage);
//                            position = list.indexOf(newPage);
//                        }
//                    }
//            }
//        }

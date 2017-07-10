/**
 * Created by joaogabriel on 08/07/17.
 */
public class Page {

    public int R;
    public int M;
    public Integer value;

    public Page(int r, int m, Integer value) {
        R = r;
        M = m;
        this.value = value;
    }

    public Page(Reference reference) {
        this.value = reference.value;
        switch (reference.access){
            case "82":
                this.R = 1;
                this.M = 0;
                break;

            case "87":
                this.R = 1;
                this.M = 1;
                break;
        }
    }

    public int getPageClass(){
        switch (this.R){
            case 0:
                return this.M == 0 ? 0 : 1;

            case 1:
                return this.M == 0 ? 2 : 3;

            default:
                return -1;
        }
    }
}

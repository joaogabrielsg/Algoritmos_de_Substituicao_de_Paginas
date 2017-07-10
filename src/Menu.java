/**
 * Created by joaogabriel on 08/07/17.
 */

import java.util.ArrayList;
import java.util.Scanner;
import org.jfree.ui.RefineryUtilities;

public class Menu {
    public static void main(String[] argv){

        ArrayList<Integer> hintsTotalFIFO = new ArrayList<>();
        ArrayList<Integer> hintsTotalMRU = new ArrayList<>();
        ArrayList<Integer> hintsTotalSecondChance = new ArrayList<>();
        ArrayList<Integer> hintsTotalNUR = new ArrayList<>();

        Scanner ler = new Scanner(System.in);

        System.out.printf("Informe o nome de arquivo texto:\n");
        String nome = ler.nextLine();

        System.out.printf("\nConteúdo do arquivo texto:\n");

//        for(int i = 60; i<=75; i++) {
//            int hints = NUR.hint(File.readFile(nome), i, 500);
//            System.out.println("frame" + i + ": " + hints);
//        }

        for(int i = 60; i<=75; i++){
            System.out.print("frames" + String.valueOf(i) + ": ");

            int hints = FIFO.hint(File.readFile(nome), i);
            int hintsMRU = MRU.hint(File.readFile(nome), i);
            int hintsSecondChance = SecondChance.hint(File.readFile(nome), i, 500);
            int hintsNUR = NUR.hint(File.readFile(nome), i, 500);


            System.out.println(hints);
            hintsTotalFIFO.add(Integer.valueOf(hints));
            hintsTotalMRU.add(Integer.valueOf(hintsMRU));
            hintsTotalSecondChance.add(Integer.valueOf(hintsSecondChance));
            hintsTotalNUR.add(Integer.valueOf(hintsNUR));
        }

        LineChart chart = new LineChart(60, hintsTotalFIFO, hintsTotalMRU, hintsTotalSecondChance, hintsTotalNUR);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}

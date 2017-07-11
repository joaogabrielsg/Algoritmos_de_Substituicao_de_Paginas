/**
 * Created by joaogabriel on 08/07/17.
 */

import java.util.ArrayList;
import java.util.Scanner;
import org.jfree.ui.RefineryUtilities;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JFrame.*;

public class Menu {
    public static void main(String[] argv){

        ArrayList<Integer> hintsTotalFIFO = new ArrayList<>();
        ArrayList<Integer> hintsTotalMRU = new ArrayList<>();
        ArrayList<Integer> hintsTotalSecondChance = new ArrayList<>();
        ArrayList<Integer> hintsTotalNUR = new ArrayList<>();
        ArrayList<Integer> hintsTotalBest = new ArrayList<>();

        Scanner ler = new Scanner(System.in);

        System.out.printf("Informe o nome de arquivo texto:\n");
        String nome = ler.nextLine();

        System.out.printf("Quantidade de frames inicial:\n");
        String framesStart = ler.nextLine();

        System.out.printf("Quantidade de frames final:\n");
        String framesEnd = ler.nextLine();

        System.out.printf("Tempo para zerar o bit R:\n");
        String time = ler.nextLine();

        System.out.printf("\nResultado:\n");

        System.out.println("          FIFO         MRU          SC         NUR        Best");
        System.out.println("--------------------------------------------------------------");



        for(int i = Integer.valueOf(framesStart); i <= Integer.valueOf(framesEnd); i++){
            System.out.print("frames" + String.valueOf(i) + ": ");

            int hints = FIFO.hint(File.readFile(nome), i);
            int hintsMRU = MRU.hint(File.readFile(nome), i);
            int hintsSecondChance = SecondChance.hint(File.readFile(nome), i, Integer.valueOf(time));
            int hintsNUR = NUR.hint(File.readFile(nome), i, Integer.valueOf(time));
            int hintsBest = Best.hint(File.readFile(nome), i);


            System.out.print(hints);
            System.out.print("       " + hintsMRU);
            System.out.print("       " + hintsSecondChance);
            System.out.print("       " + hintsNUR);
            System.out.println("       " + hintsBest);


            hintsTotalFIFO.add(Integer.valueOf(hints));
            hintsTotalMRU.add(Integer.valueOf(hintsMRU));
            hintsTotalSecondChance.add(Integer.valueOf(hintsSecondChance));
            hintsTotalNUR.add(Integer.valueOf(hintsNUR));
            hintsTotalBest.add(Integer.valueOf(hintsBest));


        }

        LineChart chart = new LineChart(60, hintsTotalFIFO, hintsTotalMRU, hintsTotalSecondChance, hintsTotalNUR, hintsTotalBest);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }

}

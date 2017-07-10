/**
 * Created by joaogabriel on 08/07/17.
 */

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import org.jfree.chart.*;
import org.jfree.data.*;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.RefineryUtilities;

public class Menu {
    public static void main(String[] argv){

        ArrayList<Integer> hintsTotalFIFO = new ArrayList<>();
        ArrayList<Integer> hintsTotalMRU = new ArrayList<>();

        Scanner ler = new Scanner(System.in);

        System.out.printf("Informe o nome de arquivo texto:\n");
        String nome = ler.nextLine();

        System.out.printf("\nConteúdo do arquivo texto:\n");

//        int hints = NUR.hint(File.readFile(nome), 5, 30);
//        System.out.print(hints);

        for(int i = 60; i<=75; i++){
            System.out.print("frames" + String.valueOf(i) + ": ");

            int hints = FIFO.hint(File.readFile(nome), i);
            int hintsMRU = MRU.hint(File.readFile(nome), i);

            System.out.println(hints);
            hintsTotalFIFO.add(Integer.valueOf(hints));
            hintsTotalMRU.add(Integer.valueOf(hintsMRU));
        }

        LineChart chart = new LineChart(60, hintsTotalFIFO, hintsTotalMRU);
        chart.pack( );
        RefineryUtilities.centerFrameOnScreen( chart );
        chart.setVisible( true );
    }
}

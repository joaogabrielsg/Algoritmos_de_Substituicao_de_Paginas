/**
 * Created by joaogabriel on 11/07/17.
 */

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Table  extends JFrame{
    JPanel painelFundo;
    JTable tabela;
    JScrollPane barraRolagem;

//    Object [][] dados = {
//            {"Ana Monteiro", "48 9923-7898", "ana.monteiro@gmail.com"},
//            {"João da Silva", "48 8890-3345", "joaosilva@hotmail.com"},
//            {"Pedro Cascaes", "48 9870-5634", "pedrinho@gmail.com"}
//    };

    public void createTable(Object [][] dados){

        String [] colunas = {"FIFO", "MRU", "SC", "NUR", "Best"};

        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(1, 1));
        tabela = new JTable(dados, colunas);
        barraRolagem = new JScrollPane(tabela);
        painelFundo.add(barraRolagem);

        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 120);
        setVisible(true);
    }
}

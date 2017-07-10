/**
 * Created by joaogabriel on 09/07/17.
 */
import java.awt.Color;
import java.awt.BasicStroke;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.plot.XYPlot;

import java.util.ArrayList;

public class LineChart extends ApplicationFrame {

    public LineChart(int startFrame, ArrayList<Integer> hintsFIFO, ArrayList<Integer> hintsMRU) {
        super("Parent`s Job");
        JFreeChart xylineChart = ChartFactory.createXYLineChart(
                "Frames vs Hints" ,
                "Hints" ,
                "Frames" ,
                (XYDataset) createDataset(startFrame, hintsFIFO, hintsMRU),
                PlotOrientation.VERTICAL ,
                true , true , false);

        ChartPanel chartPanel = new ChartPanel( xylineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        final XYPlot plot = xylineChart.getXYPlot( );

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesPaint( 2 , Color.YELLOW );
        renderer.setSeriesStroke( 0 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 1.0f ) );
        plot.setRenderer( renderer );
        setContentPane( chartPanel );
    }

    private XYDataset createDataset(int startFrame, ArrayList<Integer> hintsFIFO, ArrayList<Integer> hintsMRU) {

            final XYSeries FIFO = new XYSeries( "FIFO" );
            double frames = (double) startFrame;
            for(Integer hint: hintsFIFO) {
                FIFO.add((double) hint, frames);
                frames++;
            }

            frames = (double) startFrame;
            final XYSeries MRU = new XYSeries( "MRU" );
            for(Integer hint: hintsMRU) {
                MRU.add((double) hint, frames);
                frames++;
            }

            final XYSeriesCollection dataset = new XYSeriesCollection( );
            dataset.addSeries( FIFO );
            dataset.addSeries( MRU );
            return dataset;
    }
}

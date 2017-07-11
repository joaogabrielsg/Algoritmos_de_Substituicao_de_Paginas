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
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.renderer.xy.XYItemRenderer;

import java.util.ArrayList;

public class LineChart extends ApplicationFrame {

    public LineChart(int startFrame, ArrayList<Integer> hintsFIFO, ArrayList<Integer> hintsMRU, ArrayList<Integer> hintsSecondChance, ArrayList<Integer> hintsNUR, ArrayList<Integer> hintsBest) {
        super("Parent`s Job");

        JFreeChart xylineChart = createPanel(startFrame, hintsFIFO, hintsMRU, hintsSecondChance, hintsNUR, hintsBest);

        ChartPanel chartPanel = new ChartPanel( xylineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 1200 , 700 ) );
        final XYPlot plot = xylineChart.getXYPlot( );

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
        renderer.setSeriesPaint( 0 , Color.RED );
        renderer.setSeriesPaint( 1 , Color.GREEN );
        renderer.setSeriesPaint( 2 , Color.YELLOW );
        renderer.setSeriesPaint( 3 , Color.BLUE );
        renderer.setSeriesPaint(4, Color.black);
        renderer.setSeriesStroke( 0 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 1 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 2 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 3 , new BasicStroke( 1.0f ) );
        renderer.setSeriesStroke( 4 , new BasicStroke( 1.0f ) );
        plot.setRenderer( renderer );
        setContentPane( chartPanel );
    }

    private JFreeChart createPanel(int startFrame, ArrayList<Integer> hintsFIFO, ArrayList<Integer> hintsMRU, ArrayList<Integer> hintsSecondChance, ArrayList<Integer> hintsNUR, ArrayList<Integer> hintsBest){
        JFreeChart jfreechart = ChartFactory.createScatterPlot(
                "Frames vs Hints", "Frames", "Hints", (XYDataset) createDataset(startFrame, hintsFIFO, hintsMRU, hintsSecondChance, hintsNUR, hintsBest),
                PlotOrientation.VERTICAL, true, true, false);

        XYPlot xyPlot = (XYPlot) jfreechart.getPlot();

        NumberAxis domain = (NumberAxis) xyPlot.getDomainAxis();
        domain.setRange(startFrame, hintsFIFO.size() + startFrame);
        domain.setTickUnit(new NumberTickUnit(1.0));
        domain.setVerticalTickLabels(true);

        NumberAxis range = (NumberAxis) xyPlot.getRangeAxis();
        range.setRange(hintsFIFO.get(0), hintsMRU.get(hintsMRU.size() - 1));
        range.setTickUnit(new NumberTickUnit(1000.0));

        return  jfreechart;
    }

    private XYDataset createDataset(int startFrame, ArrayList<Integer> hintsFIFO, ArrayList<Integer> hintsMRU, ArrayList<Integer> hintsSecondChance, ArrayList<Integer> hintsNUR, ArrayList<Integer> hintsBest) {

        final XYSeries fifo = new XYSeries( "FIFO" );
        double frames = (double) startFrame;
        for(Integer hint: hintsFIFO) {
            fifo.add(frames, (double) hint);
            frames++;
        }

        frames = (double) startFrame;
        final XYSeries mru = new XYSeries( "MRU" );
        for(Integer hint: hintsMRU) {
            mru.add(frames, (double) hint);
            frames++;
        }

        frames = (double) startFrame;
        final XYSeries secondChance = new XYSeries( "Second Chance" );
        for(Integer hint: hintsSecondChance) {
            secondChance.add(frames, (double) hint);
            frames++;
        }

        frames = (double) startFrame;
        final XYSeries nur = new XYSeries( "NUR" );
        for(Integer hint: hintsNUR) {
            nur.add(frames, (double) hint);
            frames++;
        }

        frames = (double) startFrame;
        final XYSeries best = new XYSeries( "Best" );
        for(Integer hint: hintsBest) {
            best.add(frames, (double) hint);
            frames++;
        }

        final XYSeriesCollection dataset = new XYSeriesCollection( );
        dataset.addSeries( fifo );
        dataset.addSeries( mru );
        dataset.addSeries( secondChance );
        dataset.addSeries( nur );
        dataset.addSeries(best);

        return dataset;
    }
}

package me.rybka.dmytro.controller;

import me.rybka.dmytro.service.CommunicatingVesselsService;
import org.primefaces.model.chart.*;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Random;

@ManagedBean
public class ChartView implements Serializable {

    public static final int MAX_VOLUME = 100;
    public static final int MIN_VOLUME = 1;
    public static final String COMMUNICATING_VESSELS_TITLE = "Communicating Vessels";
    public static final String BLOCK_HEIGHT_LABEL = "Block height";
    public static final String BLOCKS_WIDTH_LABEL = "Blocks width";
    public static final int MIN_UNIT = 1;
    public static final int MAX_UNIT = 10;
    public static final String CALCULATED_VOLUME_TITLE = "Calculated volume";
    public static final String WATER_VOLUME_LABEL = "Water volume";
    public static final String BLOCKS_LABEL = "Blocks";
    public static final String HISTORY_ENTRY_NUMBER = "1"; //might be used as a history of volume calculation

    @Inject
    private CommunicatingVesselsService communicatingVesselsService;

    private BarChartModel barModel;
    private HorizontalBarChartModel horizontalBarModel;

    private int blocksArray[] = generateArray();

    @PostConstruct
    public void init() {
        createBarModels();
    }

    public BarChartModel getBarModel() {
        return barModel;
    }

    public HorizontalBarChartModel getHorizontalBarModel() {
        return horizontalBarModel;
    }


    private BarChartModel initBarModel() {
        BarChartModel model = new BarChartModel();
        ChartSeries blocks = initBarChart();
        model.addSeries(blocks);
        return model;
    }


    /**
     * Initializes bar chart of blocs.
     *
     * @return chartSeries
     */
    private ChartSeries initBarChart() {
        ChartSeries blocks = new ChartSeries();
        blocks.setLabel(BLOCKS_LABEL);
        int index = 0;
        for (int block : blocksArray) {
            blocks.set(index, block);
            index++;
        }
        return blocks;
    }

    /**
     * Creates random array if integers.
     *
     * @return array of integer with length 10
     */
    private int[] generateArray() {
        int arr[] = new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = generateBlock();
        }
        return arr;
    }

    /**
     * Generates block height.
     *
     * @return block height.
     */
    private int generateBlock() {
        Random generator = new Random();
        return generator.nextInt(10) + 1;
    }

    private void createBarModels() {
        createBarModel();
        createHorizontalBarModel();
    }

    private void createHorizontalBarModel() {
        horizontalBarModel = new HorizontalBarChartModel();

        ChartSeries volume = new ChartSeries();
        volume.setLabel(WATER_VOLUME_LABEL);
        volume.set(HISTORY_ENTRY_NUMBER, communicatingVesselsService.calculateCapacity(blocksArray));

        horizontalBarModel.addSeries(volume);

        horizontalBarModel.setTitle(CALCULATED_VOLUME_TITLE);
        horizontalBarModel.setLegendPosition("e");
        horizontalBarModel.setAnimate(true);
        horizontalBarModel.setShowDatatip(true);
        horizontalBarModel.setShowPointLabels(true);

        Axis xAxis = horizontalBarModel.getAxis(AxisType.X);
        xAxis.setMin(MIN_VOLUME);
        xAxis.setMax(MAX_VOLUME);

        Axis yAxis = horizontalBarModel.getAxis(AxisType.Y);
        yAxis.setLabel(WATER_VOLUME_LABEL);
    }

    private void createBarModel() {
        barModel = initBarModel();

        barModel.setTitle(COMMUNICATING_VESSELS_TITLE);
        barModel.setLegendPosition("ne");
        barModel.setAnimate(true);
        barModel.setShowDatatip(true);
        barModel.setShowPointLabels(true);

        Axis xAxis = barModel.getAxis(AxisType.Y);
        xAxis.setLabel(BLOCK_HEIGHT_LABEL);

        Axis yAxis = barModel.getAxis(AxisType.X);
        yAxis.setLabel(BLOCKS_WIDTH_LABEL);

        yAxis.setMin(MIN_UNIT);
        yAxis.setMax(MAX_UNIT);
    }
}
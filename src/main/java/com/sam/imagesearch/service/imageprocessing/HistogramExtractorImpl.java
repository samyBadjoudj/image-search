package com.sam.imagesearch.service.imageprocessing;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

/**
 * Created by sbadjoudj
 */
public class HistogramExtractorImpl implements HistogramExtractor {

    @Override
    public HashMap<Integer, double[]> getRGBHistogram(BufferedImage image) {

        double[] redHistogram = new double[256];
        double[] greenHistogram = new double[256];
        double[] blueHistogram = new double[256];

        for(int x=0; x<image.getWidth(); x++) {
            for(int y=0; y<image.getHeight(); y++) {
                int red = new Color(image.getRGB (x, y)).getRed();
                int green = new Color(image.getRGB (x, y)).getGreen();
                int blue = new Color(image.getRGB (x, y)).getBlue();
                redHistogram[red]++; greenHistogram[green]++; blueHistogram[blue]++;
            }
        }

        HashMap<Integer, double[]> histograms = new HashMap<>();
        histograms.put(HistogramExtractor.RED,redHistogram);
        histograms.put(HistogramExtractor.GREEN,greenHistogram);
        histograms.put(HistogramExtractor.BLUE, blueHistogram);

        return histograms;

    }
}

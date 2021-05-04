package com.company;
import java.awt.geom.Rectangle2D;
/**
 * This class provides the common interface and operations for fractal
 * generators that can be viewed in the Fractal Explorer.
 */
public abstract class FractalGenerator {
    public static double getCoord(double rangeMin, double rangeMax,
                                  int size, int coord) {
        assert size > 0;
        assert coord >= 0 && coord < size;
        double range = rangeMax - rangeMin;
        return rangeMin + (range * (double) coord / (double) size);
    }
    /**
     * Sets the specified rectangle to contain the initial range suitable for
     * the fractal being generated.
     */
    public abstract void getInitialRange(Rectangle2D.Double range);
    /**
     * Updates the current range to be centered at the specified coordinates,
     * and to be zoomed in or out by the specified scaling factor.
     */
    public void recenterAndZoomRange(Rectangle2D.Double range,
                                     double centerX, double centerY, double scale) {
        double newWidth = range.width * scale;
        double newHeight = range.height * scale;
        range.x = centerX - newWidth / 2;
        range.y = centerY - newHeight / 2;
        range.width = newWidth;
        range.height = newHeight;
    }
    public abstract int numIterations(double x, double y);
}

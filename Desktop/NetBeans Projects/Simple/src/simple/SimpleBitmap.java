/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.JPanel;

public class SimpleBitmap extends JPanel {
    
    private static final int BITMAP_WIDTH = 512;
    private static final int BITMAP_HEIGHT = 512;
    private BufferedImage image;
    
    public SimpleBitmap(){
        int w = BITMAP_WIDTH;
        int h = BITMAP_HEIGHT;
        int imageType = BufferedImage.TYPE_INT_RGB;
        this.image = new BufferedImage(w, h, imageType);
    } //SimpleBitmap()
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        int w = this.getWidth();
        int h = this.getHeight();
        
        AffineTransform scale = new AffineTransform();
        scale.setToScale(((double) w) / BITMAP_WIDTH, ((double) h) / BITMAP_HEIGHT);
        
        WritableRaster raster = this.image.getRaster();
        
        int[] black = {0, 0, 0};
        int[] yellow = {255, 255, 0};
        
        double xMin = 0;
        double xMax = BITMAP_WIDTH;
        double yMin = 0;
        double yMax = BITMAP_HEIGHT;
        
        double uMin = -1.5;
        double uMax = 1.5;
        double vMin = -1.5;
        double vMax = 1.5;
        
        for(int row = 0; row < BITMAP_HEIGHT; row++){
            double y = row;
            for(int column = 0; column < BITMAP_WIDTH; column++){
                double x = column;
                
                double u = uMin + (uMax - uMin) * (x - xMin) / (xMax - xMin);
                double v = vMin + (vMax - vMin) * (y - yMin) / (yMax - yMin);
                
                Complex z = new Complex(0, 0);
                Complex c = new Complex(u, v);
                
                int count = 0;
                
                while (z.magnitudeSquared() < 4 && count < 56){
                    z = z.multiply(z);
                    z = z.add(c);
                    count++;
                } //while
                
                if(count == 56){
                    raster.setPixel(row, column, yellow);
                } //if
                else {
                    raster.setPixel(row, column, black);
                } //else
            } //for
        } //for

        
//        for (int j = 0; j < h; j++){
//            for (int i = 0; i < w; i++){
//                if (i < j) {
//                    raster.setPixel(i, j, yellow);
//                } //if
//                else {
//                    raster.setPixel(i, j, black);
//                } //else
//            } //for
//        } //for
        g2d.drawImage(image, scale, this);
    } //paintComponent(Graphics)
}

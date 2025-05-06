package it.polimi;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.InputStream;

public class CustomFrame extends JFrame implements PropertyChangeListener {

    String str = "Hello";

    public void paint(Graphics g) {
        g.drawString(str, 200, 50);

        int x = 200;
        int y = 100;
        int rectwidth = 50;
        int rectheight = 100;

        //myDrawImage(g);
        //g.drawRect(x, y, rectwidth, rectheight);
        //drawCards(g);
    }

/*
    private void myDrawImage(Graphics g){

        ClassLoader cl = this.getClass().getClassLoader();
        InputStream url = cl.getResourceAsStream("cardboard-1.jpg");
        BufferedImage img= null;
        try {
            img = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        g.drawImage(img, 10,30, 200,200, null);

    }

 */


    private void drawCards(Graphics g) {
        ClassLoader cl = this.getClass().getClassLoader();

        String[] cardNames = new String[]{
                "GT-cards_I_IT_012.jpg", "GT-cards_I_IT_013.jpg"
        };

        int x = 10;
        int y = 30;
        for (String item : cardNames) {

            BufferedImage img= null;
            InputStream is = cl.getResourceAsStream(item);
            //System.out.println(is);
            try {
                img = ImageIO.read(is);
            } catch (IOException e) {
                //not for now..
            }

            //int w = img.getWidth();
            //int h = img.getHeight();

            int w = 200;
            int h = 200;
            x+=w;
            g.drawImage(img, x,30, w,h, null);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //System.out.println("evt  " + evt);
        String s = (String) evt.getNewValue();
        str = s;
        System.out.println("str:" + str);

    }
}

package it.polimi;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class CustomFrame extends JFrame {

    public void paint(Graphics g) {
        g.drawString("Hello", 200, 50);
        int x = 200;
        int y = 100;
        int rectwidth = 50;
        int rectheight = 100;

        Color c = Color.red;
        g.setColor(c);
        x=100;
        g.drawRect(x, y, rectwidth, rectheight);
        myDrawImage(g);
    }

    private void myDrawImage(Graphics g){

        ClassLoader cl = this.getClass().getClassLoader();
        //InputStream url = cl.getResourceAsStream("cardboard-1.jpg");
        InputStream url = cl.getResourceAsStream("example.png");

        BufferedImage img= null;
        try {
            img = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        g.drawImage(img, 10,30, 200,200, null);

    }

}

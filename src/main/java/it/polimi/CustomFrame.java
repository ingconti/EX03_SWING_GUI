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


    }
}

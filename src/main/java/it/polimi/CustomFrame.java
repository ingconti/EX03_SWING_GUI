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

    String msg = "Hello";

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);

        for (DrawableCard dc: renderingMessage.drawableCards){

            Image img = imgFrom(dc.cardId);
            if (img != null){
                g.drawImage(img, dc.x,dc.y, 200,200, null);
            }
        }
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


    private void drawCards(Graphics g) {
        ClassLoader cl = this.getClass().getClassLoader();

        String[] cardNames = new String[]{
                "GT-cards_I_IT_012.jpg", "GT-cards_I_IT_013.jpg"
        };

        int x = 10;
        int y = 100;
        for (String item : cardNames) {

            BufferedImage img= null;
            InputStream is = cl.getResourceAsStream(item);
            //System.out.println(is);
            try {
                img = ImageIO.read(is);
            } catch (IOException e) {
                //not for now..
            }

            int w = img.getWidth();
            int h = img.getHeight();

            //int w = 100;
            //int h = 100;
            g.drawImage(img, x,y, w,h, null);
            x+=w;

        }
    }


    RenderingMessage renderingMessage;
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        //String s = (String) evt.getNewValue();
        //msg = s;
        renderingMessage = (RenderingMessage)evt.getNewValue();
        msg = renderingMessage.toString();
        this.repaint();
    }


    private BufferedImage imgFrom(int id){

        // ... stesso codice x leggere da disco.
        ClassLoader cl = this.getClass().getClassLoader();
        BufferedImage img= null;
        String item = "GT-cards_I_IT_0" + id + ".jpg";
        InputStream is = cl.getResourceAsStream(item);
        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            //not for now..
        }

        return  img;
    }



}

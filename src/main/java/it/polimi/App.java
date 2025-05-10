package it.polimi;

import javax.swing.*;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;


public class App 
{

     static SmallModel smallModel = new SmallModel();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        CustomFrame f = new CustomFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(850,650);
        f.setVisible(true);
        mockNetworkMessages();

        smallModel.setListener(f);
    }

    private static void mockNetworkMessages(){

        ArrayList<DrawableCard> cardList1 = new ArrayList<>();
        cardList1.add(new DrawableCard(12, 100, 100));

        RenderingMessage renderingMessage1 =
                new RenderingMessage(cardList1, null);

        ArrayList<DrawableCard> cardList2 = new ArrayList<>();
        cardList2.add(new DrawableCard(13, 200, 100));
        cardList2.add(new DrawableCard(14, 300, 200));

        RenderingMessage renderingMessage2 =
                new RenderingMessage(cardList2, null);

        ArrayList<RenderingMessage> sceneList = new ArrayList<>();
        sceneList.add(renderingMessage1);
        sceneList.add(renderingMessage2);


        Timer timer = new Timer("mock");
        TimerTask task = new TimerTask() {
            public void run() {

                if (sceneList.size()>0) {
                    // was: String s = sceneList.getFirst();
                    RenderingMessage s = sceneList.getFirst();
                    sceneList.remove(0);
                    System.out.println(s);
                    //was: smallModel.setTimeStr(s);
                    smallModel.setRenderingMessage(s);
                }
            }
        };



        long delay = 0;
        long period = 2000L;
        timer.schedule(task, delay, period);
    }

}

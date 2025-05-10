package it.polimi;

import javax.swing.*;
import java.time.LocalDateTime;
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

        ArrayList<String> sceneList = new ArrayList<String>();
        sceneList.add("splash");
        sceneList.add("myDrawImage");
        sceneList.add("drawCards");

        Timer timer = new Timer("mock");
        TimerTask task = new TimerTask() {
            public void run() {
                if (sceneList.size()>0) {
                    String s = sceneList.getFirst();
                    sceneList.remove(0);
                    System.out.println(s);
                    smallModel.setTimeStr(s);
                }
            }
        };


        long delay = 0;
        long period = 2000L;
        timer.schedule(task, delay, period);
    }

}

package it.polimi;

import javax.swing.*;
import java.time.LocalDateTime;
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

    }

    private static void mockNetworkMessages(){
        Timer timer = new Timer("mock");
        TimerTask task = new TimerTask() {
            public void run() {
                LocalDateTime now = LocalDateTime.now();
                String s = now.toString();
                System.out.println(s);
                smallModel.setTimeStr(s);
            }

        };

        long delay = 0;
        long period = 1000L;
        timer.schedule(task, delay, period);
    }

}

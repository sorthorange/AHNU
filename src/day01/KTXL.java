package day01;

import javax.swing.*;
import java.awt.*;

public class KTXL extends JPanel implements Runnable{
    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        Graphics2D d = (Graphics2D)g;
        BasicStroke s = new BasicStroke(8.0f);
        d.setStroke(s);
        d.drawRoundRect(350,100,100,50,10,10);
        d.drawRoundRect(300,150,200,200,10,10);
        d.fillOval(375,200,50,50);
        d.fillRoundRect(385,230,30,75,10,10);
    }
    @Override
    public void run() {
        while(true)
        {
            //业务执行

            //睡眠方法
            try
            {
                Thread.sleep(10);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            //调用重绘方法
            //repaint();
        }
    }
}

package day01;

import javax.swing.*;
import java.awt.*;

public class MyStarPanel extends JPanel implements Runnable{

    int []xx = new int[100];
    int []yy = new int[100];

    public MyStarPanel()
    {
        for(int i=0;i<100;i++)
        {
            xx[i]=(int)(Math.random()*800);
            yy[i]=(int)(Math.random()*600);

        }
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        this.setBackground(Color.BLACK);

        g.setColor(Color.YELLOW);
        g.fillOval(100,100,100,100);

        Font ft = new Font("微软雅黑",Font.BOLD,28);//设置大小
        g.setFont(ft);
        //g.setColor(Color.);
        for(int i=0;i<100;i++)
        {
            //int x=(int)(Math.random()*800);
            //int y=(int)(Math.random()*600);

            int R=(int)(Math.random()*255);
            int G=(int)(Math.random()*255);
            int B=(int)(Math.random()*255);
            Color randcolor = new Color(R,G,B);

            g.setColor(randcolor);
            g.drawString("♂",xx[i],yy[i]);
        }
        //g.drawString("*",100,100);
    }


    @Override
    public void run() {
        while(true)
        {
            //业务执行
            for(int i=0;i<100;i++)
            {
                xx[i]++;
                yy[i]++;
                if(xx[i]>800)
                    xx[i]=0;
                if(yy[i]>600)
                    yy[i]=0;
            }
            //睡眠方法
            try
            {
                Thread.sleep(10);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            //调用重绘方法
            repaint();
        }
    }
}

package day01;

import javax.swing.*;
import java.awt.*;

public class MyBallPanel extends JPanel implements Runnable{

    private int x[];
    private int y[];
    private int x_add[];
    private int y_add[];
    private int R;
    private int G;
    private int B;
    private Color colors[];
    private int point;

    public MyBallPanel()
    {
        x=new int[5];
        y=new int[5];
        colors=new Color[5];
        x_add=new int[5];
        y_add=new int[5];
        point=0;
        for(int i=0;i<5;i++)
        {
            R = (int)(Math.random()*255);
            G = (int)(Math.random()*255);
            B = (int)(Math.random()*255);
            colors[i]=new Color(R,G,B);
            x[i]=(int)(Math.random()*700);
            y[i]=(int)(Math.random()*500);
            x_add[i]=(int)(Math.random()*10);
            y_add[i]=(int)(Math.random()*10);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.setBackground(Color.BLACK);

        //Color randcolor = new Color(R,G,B);

        for(int i=0;i<5;i++)
        {
            g.setColor(colors[i]);
            g.fillOval(x[i], y[i], 50, 50);
        }
        g.setFont(new Font("微软雅黑",Font.BOLD,25));
        g.setColor(Color.white);
        g.drawString(String.valueOf(point),0,20);
    }

    @Override
    public void run() {
        while(true)
        {
            //业务执行
            for(int i=0;i<5;i++)
            {
                x[i]+=x_add[i];
                y[i]+=y_add[i];
                if(x[i]<=0||x[i]>=710)
                {
                    R = (int)(Math.random()*255);
                    G = (int)(Math.random()*255);
                    B = (int)(Math.random()*255);
                    colors[i]=new Color(R,G,B);
                    x_add[i] = -x_add[i];
                    point+=10;
                }
                //x_add=-0;
                if(y[i]<=0||y[i]>=510)
                {
                    y_add[i] = -y_add[i];
                    R = (int)(Math.random()*255);
                    G = (int)(Math.random()*255);
                    B = (int)(Math.random()*255);
                    colors[i]=new Color(R,G,B);
                    point+=10;
                }
            }

                //y_add=-0;
            //线程睡眠
            try {
                Thread.sleep(10);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            //重绘方法
            repaint();
        }
    }
}

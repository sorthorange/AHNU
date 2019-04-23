package day02;

import day01.MyBallPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyWordPanel extends JPanel implements Runnable, KeyListener {
    private int x[];
    private int y[];
    private char c[];
    private int speed;
    private int score;
    public MyWordPanel()
    {
        speed = 15;
        score = 0;
        x=new int[10];
        y=new int[10];
        c=new char[10];
        for(int i=0;i<10;i++)
        {
            x[i]=(int)(Math.random()*700);
            y[i]=-(int)(Math.random()*500);
            c[i]=(char)(int)(Math.random()*26+'A');
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int i=0;i<10;i++)
        {
            g.setFont(new Font("微软雅黑",Font.BOLD,25));
            g.setColor(Color.RED);
            g.drawString(c[i]+"",x[i],y[i]);
            g.drawString("分数："+String.valueOf(score),0,20);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        for(int i=0;i<10;i++)
        {
            if(key==c[i])
            {
                x[i]=(int)(Math.random()*700);
                y[i]=-(int)(Math.random()*500);
                c[i]=(char)(int)(Math.random()*26+'A');
                score+=10;
                if(score==200)
                    speed=10;
                if(score==300)
                    speed=8;
                if(score==500)
                    speed=5;
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while(true)
        {
            //业务执行
            for(int i=0;i<10;i++)
            {
                y[i]++;
                if(y[i]>=500)
                {
                    y[i]=0;
                    c[i]=(char)(int)(Math.random()*26+'A');
                }
            }
            //线程睡眠
            try {
                Thread.sleep(speed);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            //重绘方法
            repaint();
        }
    }
}

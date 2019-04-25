package day03;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;

public class MyGamePanel extends JPanel implements Runnable,MouseMotionListener {

    private static BufferedImage back;
    private int backY=0;
    static BufferedImage ws[];
    private Hero hero=new Hero();
    static BufferedImage bullets;
    private Bullet bs[]={};



    static {
        try {
            back=ImageIO.read(MyGamePanel.class.getResource("img/background.png"));
            bullets=ImageIO.read(MyGamePanel.class.getResource("img/bullets.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ws=new BufferedImage[10];
        for(int i=0;i<10;i++)
        {
            try {
                ws[i]=ImageIO.read(MyGamePanel.class.getResource("img/ws0"+i+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(back,0,backY,null);
        g.drawImage(back,0,backY-768,null);
        g.drawImage(hero.img,hero.x,hero.y,hero.width,hero.height,null);
        for(int i=0;i<bs.length;i++)
        {
            Bullet bt=bs[i];
            g.drawImage(bt.img,bt.x,bt.y,bt.width,bt.height,null);
        }
    }

    private void shootAction()
    {
        Bullet bt = new Bullet(hero.x+hero.width/2,hero.y);
        bs= Arrays.copyOf(bs,bs.length+1);
        bs[bs.length-1]=bt;
    }

    @Override
    public void run() {
        while(true)
        {
            //业务执行
            backY++;
            if(backY>=768)
                backY=0;
            hero.step();
            shootAction();
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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int xx=e.getX();
        int yy=e.getY();
        hero.Move(xx,yy);
    }
}

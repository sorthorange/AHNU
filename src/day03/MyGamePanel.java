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
    static BufferedImage ws[]=new BufferedImage[10];
    static BufferedImage enemy[]=new BufferedImage[5];
    static BufferedImage heart[]=new BufferedImage[9];
    private Hero hero=new Hero();
    static BufferedImage bullets;
    private Bullet bs[]={};
    private int shootindex=0;
    private Enemy enemys[]={};
    private int enemyindex=0;
    private Heart hearts[]={};
    private int heartindex=0;



    static {
        try {
            back=ImageIO.read(MyGamePanel.class.getResource("img/background.png"));
            bullets=ImageIO.read(MyGamePanel.class.getResource("img/bullets.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0;i<10;i++)
        {
            try {
                ws[i]=ImageIO.read(MyGamePanel.class.getResource("img/ws0"+i+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(int i=0;i<5;i++)
        {
            try {
                enemy[i]=ImageIO.read(MyGamePanel.class.getResource("img/flys"+i+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for(int i=0;i<9;i++)
        {
            try {
                heart[i]=ImageIO.read(MyGamePanel.class.getResource("img/qq0"+i+".png"));
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
        for(int i=0;i<enemys.length;i++)
        {
            Enemy e=enemys[i];
            g.drawImage(e.img,e.x,e.y,e.width,e.height,null);
        }
        for(int i=0;i<hearts.length;i++)
        {
            Heart h=hearts[i];
            g.drawImage(h.img,h.x,h.y,h.width,h.height,null);
        }
    }

    @Override
    public void run() {
        while(true)
        {
            //业务执行
            backY++;
            if(backY>=768)
                backY=0;
            stepAction();
            shootAction();
            enemyAction();
            heartAction();
            //线程睡眠
            try {
                Thread.sleep(5);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            //重绘方法
            repaint();
        }
    }

    private void shootAction()
    {
        shootindex++;
        if(shootindex%50==0)
        {
            Bullet bt = new Bullet(hero.x+hero.width/2,hero.y);
            bs= Arrays.copyOf(bs,bs.length+1);
            bs[bs.length-1]=bt;
        }
    }

    private void enemyAction()
    {
        enemyindex++;
        if(enemyindex%100==0)
        {
            Enemy e=new Enemy();
            enemys= Arrays.copyOf(enemys,enemys.length+1);
            enemys[enemys.length-1]=e;
        }
    }

    private void heartAction()
    {
        heartindex++;
        if(heartindex%400==0)
        {
            Heart h=new Heart();
            hearts= Arrays.copyOf(hearts,hearts.length+1);
            hearts[hearts.length-1]=h;
        }
    }

    private void stepAction()
    {
        hero.step();
        for(int i=0;i<bs.length;i++)
        {
            bs[i].step();;
        }
        for(int i=0;i<enemys.length;i++)
        {
            enemys[i].step();
        }
        for(int i=0;i<hearts.length;i++)
        {
            hearts[i].step();
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

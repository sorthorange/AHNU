package day02;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Observer;

public class MyTomPanel extends JPanel implements Runnable,MouseListener {

    BufferedImage back;
    BufferedImage eat_button;
    BufferedImage cymbal_button;
    BufferedImage drink_button;
    BufferedImage fart_button;
    BufferedImage pie_button;
    BufferedImage scratch_button;
    BufferedImage angry_button;
    BufferedImage footleft_button;
    BufferedImage footright_button;
    BufferedImage knockout_button;
    BufferedImage stomach_button;
    String eat[];
    String cymbal[];
    String drink[];
    String fart[];
    String pie[];
    String scratch[];
    String angry[];
    String footleft[];
    String footright[];
    String knockout[];
    String stomach[];
    int index;
    int count;
    int count_re[];
    int type;

    public MyTomPanel()
    {
        index=0;
        count=40;
        type=0;
        count_re=new int[]{0,40,13,81,28,24,56,26,30,30,81,34};
        eat = new String[40];
        cymbal = new String[13];
        drink = new String[81];
        fart = new String[28];
        pie = new String[24];
        scratch = new String[56];
        angry = new String[26];
        footleft = new String[30];
        footright = new String[30];
        knockout = new String[81];
        stomach = new String[34];
        for(int i=0;i<40;i++)
        {
            if(i<10)
                eat[i]="Animations/Eat/eat_0"+i+".jpg";
            else
                eat[i]="Animations/Eat/eat_"+i+".jpg";
        }
        for(int i=0;i<13;i++)
        {
            if(i<10)
                cymbal[i]="Animations/Cymbal/cymbal_0"+i+".jpg";
            else
                cymbal[i]="Animations/Cymbal/cymbal_"+i+".jpg";
        }
        for(int i=0;i<81;i++)
        {
            if(i<10)
                drink[i]="Animations/Drink/drink_0"+i+".jpg";
            else
                drink[i]="Animations/Drink/drink_"+i+".jpg";
        }
        for(int i=0;i<28;i++)
        {
            if(i<10)
                fart[i]="Animations/Fart/fart_0"+i+".jpg";
            else
                fart[i]="Animations/Fart/fart_"+i+".jpg";
        }
        for(int i=0;i<24;i++)
        {
            if(i<10)
                pie[i]="Animations/Pie/pie_0"+i+".jpg";
            else
                pie[i]="Animations/Pie/pie_"+i+".jpg";
        }
        for(int i=0;i<56;i++)
        {
            if(i<10)
                scratch[i]="Animations/Scratch/scratch_0"+i+".jpg";
            else
                scratch[i]="Animations/Scratch/scratch_"+i+".jpg";
        }
        for(int i=0;i<26;i++)
        {
            if(i<10)
                angry[i]="Animations/Angry/angry_0"+i+".jpg";
            else
                angry[i]="Animations/Angry/angry_"+i+".jpg";
        }
        for(int i=0;i<30;i++)
        {
            if(i<10)
                footleft[i]="Animations/Footleft/footleft_0"+i+".jpg";
            else
                footleft[i]="Animations/Footleft/footleft_"+i+".jpg";
        }
        for(int i=0;i<30;i++)
        {
            if(i<10)
                footright[i]="Animations/Footright/footright_0"+i+".jpg";
            else
                footright[i]="Animations/Footright/footright_"+i+".jpg";
        }
        for(int i=0;i<81;i++)
        {
            if(i<10)
                knockout[i]="Animations/Knockout/knockout_0"+i+".jpg";
            else
                knockout[i]="Animations/Knockout/knockout_"+i+".jpg";
        }
        for(int i=0;i<34;i++)
        {
            if(i<10)
                stomach[i]="Animations/stomach/stomach_0"+i+".jpg";
            else
                stomach[i]="Animations/stomach/stomach_"+i+".jpg";
        }
        count=1;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        try {
            eat_button = ImageIO.read(MyTomPanel.class.getResource("Buttons/eat.png"));
            cymbal_button = ImageIO.read(MyTomPanel.class.getResource("Buttons/cymbal.png"));
            drink_button = ImageIO.read(MyTomPanel.class.getResource("Buttons/drink.png"));
            fart_button = ImageIO.read(MyTomPanel.class.getResource("Buttons/fart.png"));
            pie_button = ImageIO.read(MyTomPanel.class.getResource("Buttons/pie.png"));
            scratch_button = ImageIO.read(MyTomPanel.class.getResource("Buttons/scratch.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(back,0,0,512,768,null);
        g.drawImage(eat_button,50,350,60,60,null);
        g.drawImage(cymbal_button,50,450,60,60,null);
        g.drawImage(drink_button,50,550,60,60,null);
        g.drawImage(fart_button,402,350,60,60,null);
        g.drawImage(pie_button,402,450,60,60,null);
        g.drawImage(scratch_button,402,550,60,60,null);
    }

    @Override
    public void run() {
        while(true)
        {
            //业务执行
            index++;
            if(index>=count)
            {
                index = 0;
                count = 0;
                type=0;
            }
            String temp[] = new String[0];
            switch (type)
            {
                case 1:
                    temp=eat;
                    break;
                case 2:
                    temp=cymbal;
                    break;
                case 3:
                    temp=drink;
                    break;
                case 4:
                    temp=fart;
                    break;
                case 5:
                    temp=pie;
                    break;
                case 6:
                    temp=scratch;
                    break;
                case 7:
                    temp=angry;
                    break;
                case 8:
                    temp=footleft;
                    break;
                case 9:
                    temp=footright;
                    break;
                case 10:
                    temp=knockout;
                    break;
                case 11:
                    temp=stomach;
                    break;
            }

            if(type==0)
            {
                try {
                    back = ImageIO.read(MyTomPanel.class.getResource(eat[0]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                try {
                    back = ImageIO.read(MyTomPanel.class.getResource(temp[index]));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            //线程睡眠
            try {
                Thread.sleep(count);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            //重绘方法
            repaint();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if(mx>40&&mx<60+60&&my>340&&my<360+60)
        {
            type=1;
            index=0;
            count=count_re[type];
        }
        if(mx>40&&mx<60+60&&my>440&&my<460+60)
        {
            type=2;
            index=0;
            count=count_re[type];
        }
        if(mx>40&&mx<60+60&&my>540&&my<560+60)
        {
            type=3;
            index=0;
            count=count_re[type];
        }
        if(mx>392&&mx<412+60&&my>340&&my<360+60)
        {
            type=4;
            index=0;
            count=count_re[type];
        }
        if(mx>392&&mx<412+60&&my>440&&my<460+60)
        {
            type=5;
            index=0;
            count=count_re[type];
        }
        if(mx>392&&mx<412+60&&my>540&&my<560+60)
        {
            type=6;
            index=0;
            count=count_re[type];
        }
        if(mx>330&&mx<330+65&&my>560&&my<560+135)
        {
            type=7;
            index=0;
            count=count_re[type];
        }
        if(mx>256&&mx<256+65&&my>675&&my<675+68)
        {
            type=8;
            index=0;
            count=count_re[type];
        }
        if(mx>256-65&&mx<256&&my>675&&my<675+68)
        {
            type=9;
            index=0;
            count=count_re[type];
        }
        if(mx>115&&mx<115+282&&my>140&&my<140+250)
        {
            type=10;
            index=0;
            count=count_re[type];
        }
        if(mx>191&&mx<191+130&&my>560&&my<560+100)
        {
            type=11;
            index=0;
            count=count_re[type];
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

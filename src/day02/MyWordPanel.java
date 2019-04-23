package day02;

import javax.swing.*;

public class MyWordPanel extends JPanel implements Runnable{




    @Override
    public void run() {
        while(true)
        {
            //业务执行
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

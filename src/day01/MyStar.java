package day01;

import javax.swing.*;

public class MyStar {
    public static void main(String [] args)
    {
        JFrame frame = new JFrame();
        //MyStarPanel panel = new MyStarPanel();
        KTXL k = new KTXL();
        frame.add(k);

        Thread t= new Thread(k);
        t.start();

        frame.setSize(800,600);//设置窗口大小
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭模式
        frame.setLocationRelativeTo(null);//设置窗口居中
        frame.setVisible(true);//设置窗口可见
    }
}

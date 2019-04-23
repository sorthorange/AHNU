package day02;

import javax.swing.*;

public class MyTom {
    public static void main(String[]args)
    {
        JFrame frame = new JFrame("辣鸡游戏");
        MyTomPanel panel = new MyTomPanel();
        frame.add(panel);
        /*添加线程关联*/
        Thread t = new Thread(panel);
        t.start();
        frame.addMouseListener(panel);
        //设置窗口大小
        frame.setSize(512,768);
        //设置窗口关闭模式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口居中
        frame.setLocationRelativeTo(null);
        //设置窗口可见
        frame.setVisible(true);
    }
}

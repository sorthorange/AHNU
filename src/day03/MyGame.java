package day03;

import javax.swing.*;

public class MyGame {
    public static void main(String[]args)
    {
        JFrame frame = new JFrame("憨批");
        MyGamePanel panel = new MyGamePanel();
        frame.add(panel);
        /*添加线程关联*/
        Thread t = new Thread(panel);
        t.start();
        //鼠标监听
        frame.addMouseMotionListener(panel);
        //设置窗口大小
        frame.setSize(512,768);
        frame.setResizable(false);
        //设置窗口关闭模式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口居中
        frame.setLocationRelativeTo(null);
        //设置窗口可见
        frame.setVisible(true);
    }
}

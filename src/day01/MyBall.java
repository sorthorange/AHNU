package day01;

import javax.swing.*;

public class MyBall {
    public static void main(String[]args)
    {
        //建立对象
        JFrame frame = new JFrame("小弹球");
        MyBallPanel panel = new MyBallPanel();
        frame.add(panel);
        /*添加线程关联*/
        Thread t = new Thread(panel);
        t.start();
        //设置窗口大小
        frame.setSize(800,600);
        //设置窗口关闭模式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口居中
        frame.setLocationRelativeTo(null);
        //设置窗口可见
        frame.setVisible(true);
    }
}

package day02;

import javax.swing.*;

public class MyWord {
    public static void main(String[]args)
    {
        JFrame frame = new JFrame("辣鸡游戏");
        MyWordPanel panel = new MyWordPanel();
        frame.add(panel);
        /*添加线程关联*/
        Thread t = new Thread(panel);
        t.start();
        //添加键盘监听
        frame.addKeyListener(panel);
        //设置窗口大小
        frame.setSize(800,600);
        //设置窗口关闭模式
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口居中
        frame.setLocationRelativeTo(null);
        //设置窗口可见
        frame.setVisible(true);
        //焦点设置
        frame.setFocusable(true);
    }
}

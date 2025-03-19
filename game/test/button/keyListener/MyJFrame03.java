package game.test.button.keyListener;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class MyJFrame03 extends JFrame implements KeyListener {
    JButton jbtA = new JButton("A");

    public MyJFrame03() {
        //界面设置
        this.setSize(630, 680);//界面大小
        this.setTitle("拼图单机版_键盘监听_测试1.0");//界面标题
        this.setAlwaysOnTop(true);//界面置顶
        this.setLocationRelativeTo(null);//界面居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//界面关闭方式
        this.setLayout(null);//取消内容物默认居中


        //给整个界面窗体添加键盘监听
        //调用者this：本类对象，当前界面的对象，表示要给整个界面添加监听
        //addKeyListener：要给本界面添加键盘监听
        //参数this：当事件被触发后，执行本类中的对应代码
        this.addKeyListener(this);

        this.setVisible(true);//界面显示
    }

    @Override
    public void keyPressed(KeyEvent e)//按下按键不松
    {
        Random r = new Random();
        int code = e.getKeyCode();
        switch (code) {
            case 65 -> {
                System.out.println("按下A");
                JButton jbt = new JButton("A");
                jbt.setBounds(r.nextInt(100), r.nextInt(100), r.nextInt(200), r.nextInt(200));
                this.getContentPane().add(jbt);//添加按钮到界面
            }
            case 66 -> {
                JButton jbt = new JButton("B");
                jbt.setBounds(r.nextInt(200,300), r.nextInt(200,300), r.nextInt(200), r.nextInt(200));
                this.getContentPane().add(jbt);//添加按钮到界面
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e)//松开按键
    {
        Random r = new Random();
        int code = e.getKeyCode();
        switch (code) {
            case 65 -> {
                System.out.println("松开 A");
                jbtA.setSize(r.nextInt(120), r.nextInt(120));
                this.getContentPane().add(jbtA);//添加按钮到界面
            }
            case 66 -> {
                JButton jbtB = new JButton("B");
                jbtB.setSize(r.nextInt(120), r.nextInt(120));
                this.getContentPane().add(jbtB);//添加按钮到界面
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e)//一般不用（不能识别Alt+A之类的按键）
    {

    }
}

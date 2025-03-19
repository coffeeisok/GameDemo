package game.test.button.mouseListener;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class MyJFrame02 extends JFrame implements MouseListener {

    JButton jbt01 = new JButton("我是夯大力～");
    JButton jbt02 = new JButton("我不是夯大力嘿嘿嘿！");
    JButton jbt03 = new JButton("/Users/wucoffee/java/CODE/PuzzleGame/UI/image/animal/animal1/1.jpg");

    public MyJFrame02() {
        //界面设置
        this.setSize(603, 680);//界面大小
        this.setTitle("拼图单机版_鼠标监听_测试1.0");//界面标题
        this.setAlwaysOnTop(true);//置顶
        this.setLocationRelativeTo(null);//居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭方式
        this.setLayout(null);//取消内容物默认居中

        //按钮设置
        jbt01.setBounds(0, 0, 100, 80);
        jbt01.addMouseListener(this);//给按钮绑定鼠标事件
        this.getContentPane().add(jbt01);//将按钮添加到界面中

        jbt02.setBounds(201, 149, 100, 80);
        jbt02.addMouseListener(this);
        this.getContentPane().add(jbt02);

        this.setVisible(true);//显示界面
    }

    @Override//单机
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source == jbt01) {
            Random r = new Random();
            jbt01.setSize(r.nextInt(100), r.nextInt(30));
        } else if (source == jbt02) {
            Random r = new Random();
            jbt02.setSize(r.nextInt(100), r.nextInt(30));
        }
    }

    @Override//按下不松
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source == jbt01) {
            Random r = new Random();
            jbt01.setSize(r.nextInt(140), r.nextInt(90));
        } else if (source == jbt02) {
            Random r = new Random();
            jbt02.setSize(r.nextInt(140), r.nextInt(90));
        }
    }

    @Override//松开
    public void mouseReleased(MouseEvent e) {
        Object source = e.getSource();
        if (source == jbt01) {
            Random r = new Random();
            jbt01.setSize(r.nextInt(320), r.nextInt(249));
        } else if (source == jbt02) {
            Random r = new Random();
            jbt02.setSize(r.nextInt(320), r.nextInt(249));
        }

    }

    @Override//划入
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if (source == jbt01) {
            jbt01.setSize(120, 100);
        } else if (source == jbt02) {
            jbt02.setSize(120, 100);
        }

    }

    @Override//划出
    public void mouseExited(MouseEvent e) {
        Object source = e.getSource();
        if (source == jbt01) {
            Random r = new Random();
            jbt01.setSize(100,80);
        } else if (source == jbt02) {
            Random r = new Random();
            jbt02.setSize(100,80);
        }
    }
}

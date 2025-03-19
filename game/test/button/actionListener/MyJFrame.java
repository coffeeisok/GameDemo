package game.test.button.actionListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {

    JButton jbt01 = new JButton("点击我");//创建按钮对象
    JButton jbt02 = new JButton("别点我");//创建按钮对象

    public  MyJFrame(){
        //显示界面设置
        this.setSize(603,680);
        this.setTitle("拼图单机版_动作监听_测试1.0");
        this.setAlwaysOnTop(true);//置顶
        this.setLocationRelativeTo(null);//居中
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//关闭游戏
        this.setLayout(null);//取消图片默认居中

        //按钮设置
        jbt01.setBounds(0,0,100,50);//按钮位置&大小
        jbt01.addActionListener(this);

        jbt02.setBounds(400,100,100,50);//按钮位置&大小
        jbt02.addActionListener(this);

        this.getContentPane().add(jbt01);//把按钮添加到显示界面中
        this.getContentPane().add(jbt02);


        this.setVisible(true);

    }

    @Override//对接口ActionListener的方法的重写
    public void actionPerformed(ActionEvent e) {
        //对当前的按钮进行判断
        Object source = e.getSource();//获取当前被操作的按钮对象(Object-父类类型)
        if(source == jbt01){
            jbt01.setSize(200,100);
        } else if (source == jbt02) {
            Random r = new Random();
            jbt02.setBounds(r.nextInt(200),r.nextInt(200),r.nextInt(500),r.nextInt(500));
        }
    }
}

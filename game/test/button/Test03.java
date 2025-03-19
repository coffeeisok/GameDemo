package game.test.button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//按钮测试
public class Test03 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(603, 680);
        jFrame.setTitle("事件演示");
        jFrame.setAlwaysOnTop(true);
        jFrame.setLocationRelativeTo(null);//居中
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//3
        jFrame.setLayout(null);//取消图片默认居中

        JButton jbt = new JButton("点我！");//创建一个按钮对象
        jbt.setBounds(0, 0, 105, 105);//设置位置和宽高
        jbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击了！");
            }
        });//给按钮添加动作监听

        //把按钮添加到界面中
        jFrame.getContentPane().add(jbt);


        jFrame.setVisible(true);//显示界面
    }
}

package game.test;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
//*****  GameJFrame——游戏主界面  *****

public class gameJframe extends JFrame implements KeyListener, MouseListener {


    int[][] data = new int[4][4];
    //记录空白方块在二维数组中的位置
    int x = 0;
    int y = 0;

    JButton jbt01 = new JButton("我是夯大力～");


    public gameJframe() {
        //初始化界面窗口
        InitJFrame();
        //初始化菜单栏
        InitJMenuBar();
        //初始化数据（打乱数据）
        initData();
        //初始化图片（根据打乱之后的数据加载图片）
        initImage();


        //显示界面，写在末尾
        this.setVisible(true);
    }

    private void InitJFrame() {
        //设置主界面的大小
        this.setSize(603, 680);
        //设置界面标题
        this.setTitle("拼图单机版_V1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置窗口居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//一个窗口被关闭就会结束程序
        //取消默认居中放置（只有取消了，图片才会按照XY轴的形式添加组件）
        this.setLayout(null);

        //给整个界面添加键盘监听事件
        this.addKeyListener(this);

    }

    private void InitJMenuBar() {
        //创建整个菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        //创建菜单上面两个选项的对象——功能、关于我们
        JMenu functionJMenu = new JMenu("功能");
        JMenu aboutUsJMenu = new JMenu("关于我们");
        //创建选项下面的条目
        JMenuItem regameJMenuItem = new JMenuItem("重新开始");
        JMenuItem reloginJMenuItem = new JMenuItem("重新登陆");
        JMenuItem exitGameJMenuItem = new JMenuItem("退出游戏");

        JMenuItem weChatCardJMenuItem = new JMenuItem("微信名片");

        //将每个选项下的条目添加到选项中
        functionJMenu.add(regameJMenuItem);
        functionJMenu.add(reloginJMenuItem);
        functionJMenu.add(exitGameJMenuItem);

        aboutUsJMenu.add(weChatCardJMenuItem);

        //将菜单中的两个选项添加到菜单中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutUsJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initData() {
        //把一维数组中的元素打乱（0～15），遍历数组，得到每一个元素，
        //用每一个元素跟随机索引上的数据进行交换，再把4个一维数组添加到二维数组中

        //打乱一维数组
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);//获取随机索引
            //用遍历到的每一个数据跟索引上的数据交换
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        //添加到二维数组中
        //【核心算法】遍历一维数组得到每一个元素，把每一个元素依次添加到二维数组中
        for (int i = 0; i < tempArr.length; i++) {
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            } else {
                data[i / 4][i % 4] = tempArr[i];

            }
        }
    }

    private void initImage() {
        //*注：先加载的图片在界面上面
        //清屏
        this.getContentPane().removeAll();

        //按钮
        jbt01.setBounds(10, 10, 105, 105);
        jbt01.addMouseListener(this);//给按钮绑定鼠标事件
        this.getContentPane().add(jbt01);//将按钮添加到界面中


        //图片的长宽都是105像素
        //先添加每行的图片，每行的图片添加好后换下一行

        for (int i = 0; i < 4; i++)//第一行到最后一行
        {
            for (int j = 0; j < 4; j++) //从左至右添加图片
            {
                int num = data[i][j];//获取当前要加载的图片的序号
                //创建一个图片PictureIcon的对象
                ImageIcon icon = new ImageIcon("/Users/wucoffee/java/CODE/PuzzleGame/UI/image/animal/animal1/" + num + ".jpg");//图片位置默认为正中央
                //创建一个JLabel的对象（管理容器）
                JLabel jLabel = new JLabel(icon);
                //指定图片位置（一定要在添加之前）
                int index_i = 92;//图片位置的调整变量
                int index_j = 115;
                jLabel.setBounds(105 * j + index_i, 105 * i + index_j, 105, 105);
                //把管理容器添加到界面中

                //给图片加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));

                this.getContentPane().add(jLabel);
                //【小细节】：当num为某一值，路径中找不到的 num.jpg 会显示为空白
            }
        }

        //添加背景图片
        ImageIcon backImage = new ImageIcon("/Users/wucoffee/java/CODE/PuzzleGame/UI/image/background.png");
        JLabel backGround = new JLabel(backImage);
        backGround.setBounds(-3, 1, 610, 600);
        this.getContentPane().add(backGround);


        //刷新图片
        this.getContentPane().repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //向上移动是指空白向上移动
        //上左下右（箭头）：38，37，39，40
        //上左下右（wasd）:87,65,83,68
        int code = e.getKeyCode();
        if ((code == 38 || code == 87) && x > 0) {
            System.out.println("向上移动");
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;
            initImage();
        } else if ((code == 37 || code == 65) && y > 0) {
            System.out.println("向左移动");
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;
            initImage();
        } else if ((code == 39 || code == 83) && x < 3) {
            System.out.println("向下移动");
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;
            initImage();
        } else if ((code == 40 || code == 68) && y < 3) {
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;
            System.out.println("向右移动");
            initImage();
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        Object source = e.getSource();
        if (source == jbt01) {
            jbt01.setSize(120, 100);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}


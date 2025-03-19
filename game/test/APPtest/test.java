package game.test.APPtest;

import UI.GameJFrame;
import UI.LoginJFrame;
import UI.RegisterJFrame;

public class test {
    /*
     * 创建一个宽488像素，高500像素的 注册界面
     * 创建一个宽488像素，高430像素的 登录界面
     * 创建一个宽603像素，高680像素的 游戏主界面
     * */

    public static void main(String[] args) {
        //注册
        RegisterJFrame registerJFrame = new RegisterJFrame();
        //登陆
        LoginJFrame loginJFrame = new LoginJFrame();
        //游戏界面
        GameJFrame gameJFrame = new GameJFrame();
    }
}

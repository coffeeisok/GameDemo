package game.test.shuffleArray;

import java.util.Random;
//
//把一维数组中的元素打乱（0～15），再4个一组添加到二维数组中
//【方法一】:遍历一维数组得到每一个元素，把每一个元素依次添加到二维数组总
//
public class Test {
    public static void main(String[] args) {
        //把一维数组中的元素打乱（0～15）
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //遍历数组，得到每一个元素，用每一个元素跟随机索引上的数据进行交换
        Random r = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            //获取随机索引
            int index = r.nextInt(tempArr.length);
            //用遍历到的每一个数据跟索引上的数据交换
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        //遍历数组
        for (int i = 0; i < tempArr.length; i++) {
            System.out.print(tempArr[i] + ",");
        }
        System.out.println();
        //再4个一组添加到二维数组中
        int[][] data = new int[4][4];

        //【核心算法】遍历一维数组得到每一个元素，把每一个元素依次添加到二维数组总
        for (int i = 0; i < tempArr.length; i++) {

            data[i / 4][i % 4] = tempArr[i];
        }
        //遍历二维数组
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + ",");
            }
            System.out.println();
        }


    }
}

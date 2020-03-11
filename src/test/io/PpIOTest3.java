package test.io;

import java.io.*;

/**
 * 练习标准流程
 * 创建源  选择流  操作  释放资源
 */

public class PpIOTest3 {
    public static void main(String[] args) {
        //1.创建流
        File file = new File("D:/1.txt");

        //选择流
        OutputStream ops = null;
        try {
            ops = new FileOutputStream(file,true);
            //操作
            String a = "life just like a box of co,you never know what you going to get\r";
            byte [] datas=a.getBytes();//字符串--->字节数组（编码）
            ops.write(datas,0,datas.length);
            ops.flush();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //关闭资源
        finally {
            try{
                if (null != ops){
                    ops.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

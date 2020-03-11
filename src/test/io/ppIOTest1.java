package test.io;


import java.io.FileInputStream;
import java.io.FileOutputStream;


/**
 * 练习使用流读取文件的经典用法
 */
public class ppIOTest1 {
    public static void main(String[] args) {
//        try {
//            FileInputStream file = new FileInputStream("D:/GIT本地代码/hello/leetcode/src/test/io/1.txt");
//            char s1 = (char) file.read();
//            char s2 = (char) file.read();
//            char s3 = (char) file.read();
//            int a = file.read();
//            System.out.println(s1+" "+s2+" "+s3);
//            System.out.println(a);
//            file.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        FileInputStream file=null;
        FileOutputStream fop=null;
        try {
            file = new FileInputStream("D:/GIT本地代码/hello/leetcode/src/test/io/1.txt");
            StringBuilder res = new StringBuilder();
            int temp = 0;
            //当temp=-1的时候，说明读取到文件末尾了
            while ((temp = file.read()) != -1) {
                res.append((char) temp);
            }
            System.out.println(res);
            //为true时候，在文件尾部写入
            fop = new FileOutputStream("D:/GIT本地代码/hello/leetcode/src/test/io/2.txt",true);
            String test = "测试文件流写入";
            fop.write(test.getBytes());

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                //保证流对象一定会被关闭
                if (file != null){
                    file.close();
                }
                if (fop != null){
                    fop.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

}

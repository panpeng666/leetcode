package test.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 测试使用FileOutput和FileInput实现文件拷贝
 */
public class ppIOTest2 {
    public static void main(String[] args) {
        copyFile("D:/GIT本地代码/hello/leetcode/src/test/io/1.txt","D:/GIT本地代码/hello/leetcode/src/test/io/2.txt");
    }

    public static void copyFile(String address1,String adderss2){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        byte[] buffer = new  byte[1024];
        int temp = 0;
        try{
            fis = new FileInputStream(address1);
            fos = new FileOutputStream(adderss2,true);

            while ((temp=fis.read(buffer))!= -1){//read(byte[] b) 从该输入流读取最多 b.length个字节的数据为字节数组。
                fos.write(buffer,0,temp);//write(byte[] b) 将 b.length个字节从指定的字节数组写入此文件输出流。
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if (fis!=null){fis.close();}
            }catch (Exception e){
                e.printStackTrace();
            }
            try{
                if (fos != null){fos.close();}
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

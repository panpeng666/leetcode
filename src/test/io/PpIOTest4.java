package test.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 练习字符流 FileRead FileWrite 的使用
 */

public class PpIOTest4 {
    public static void main(String[] args) {
        copyStringFile("D:/GIT本地代码/hello/leetcode/src/test/io/1.txt","D:/GIT本地代码/hello/leetcode/src/test/io/2.txt");
    }

    public static void copyStringFile(String add1,String add2){
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            fileReader = new FileReader(add1);
            fileWriter = new FileWriter(add2);

            char[] chars = new char[1];
            int temp = -1;
            while ( (temp=fileReader.read(chars)) != -1){
                fileWriter.write(chars);
                fileWriter.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(null!=fileReader){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(null!=fileWriter) {
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }


    }
}

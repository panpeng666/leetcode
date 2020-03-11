package test.io;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * 练习apache  FileUtils  类
 */

public class PpIOTest7 {
    public static void main(String[] args) {
        try {

            System.out.println(FileUtils.readFileToString(new File("D:/GIT本地代码/hello/leetcode/src/test/io/1.txt"),"utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

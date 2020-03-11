package test.io;

import java.io.*;

/**
 * 缓冲字符流练习
 * BufferedReader / BufferedWriter
 * 进行文本文件的读写
 */

public class PpIOTest6 {
    public static void main(String[] args) {

    }


    public static void copyTextFile(String add1,String add2){
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        String temp = "";

        try {
            fr = new FileReader(add1);
            fw = new FileWriter(add2);
            br = new BufferedReader(fr);
            bw = new BufferedWriter(fw);


            while ((temp=br.readLine())!=null){
                bw.write(temp);
                bw.newLine();
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (bw != null){
                bw.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (br != null){
                br.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                if (fw!=null){
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                if (fr!=null){
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

package io;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @Auther: ccl
 * @Date: 2021/1/11 21:49
 * @Description:
 */
public class IOTest {

    // 读取文件
    @Test
    public void test1() {
        FileReader fr = null;
        try {
            // 1.创建File类对象实例
            File file = new File("src/io/test1.txt");
            // 注意点： 1.读取的文件必须存在 否则会抛异常。（这里处理了异常）

            // 2. 流的实例
            fr = new FileReader(file);
            // 3. 读取操作
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 4.资源关闭
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println();
        System.out.println("************************");

        // 读取多个
        try {
            File f = new File("src/io/test1.txt");
            fr = new FileReader(f);
            char[] cbuf = new char[5];
            int len = fr.read(cbuf);
            while (len != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
                len = fr.read(cbuf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 文件写入
    @Test
    public void test2() {
        FileWriter fw = null;
        try {
            File f = new File("src/io/test2.txt"); // 写入操作时，若没有此文件 则会自动创建一个
            // fw = new FileWriter(f);  // 若有文件，则直接替换
            fw = new FileWriter(f, true); // 若有文件，则在后面接着写
            fw.write("123456\n");
            fw.write("上山打老虎");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 读写一起
    @Test
    public void test3() {
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            File readFile = new File("src/io/test2.txt");
            File writeFile = new File("src/io/test3.txt");

            fileReader = new FileReader(readFile);
            fileWriter = new FileWriter(writeFile);

            char[] cbuf = new char[10];
            int len;
            while ((len = fileReader.read(cbuf)) != -1) {
                for (int i = 0; i < len; i++) {
                    fileWriter.write(cbuf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (fileReader != null)
                fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (fileWriter != null)
                fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package net;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Auther: ccl
 * @Date: 2021/1/14 22:46
 * @Description:
 */
public class TcpTest {
    /**
     * 1.创建一个服务端和一个客户端
     * 2.从客户端发送一张图片到服务端，并发送一些文本内容，
     * 3.服务端接收客户端传输的图片，并返回接收到内容的文本。
     */

    // 服务端
    @Test
    public void server() {
        ServerSocket ss = null;
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;
        FileOutputStream fos = null;
        try {
            //1.建立socket对象，服务端使用ServerSocket来建立
            ss = new ServerSocket(9999);
            //监听客户端
            socket = ss.accept();

            //2.获取输入输出流，输入流是客户端发送过来的；输出流是准备给客户端发送的
            is = socket.getInputStream();
            os = socket.getOutputStream();

            //3.这里假设客户端传送的就是图片
            fos = new FileOutputStream(new File("src/net/copy.png"));
            byte[] buff = new byte[20];
            int len;
            while ((len = is.read(buff)) != -1) {
                fos.write(buff, 0, len);
            }
            System.out.println("接收到客户端发送的数据！");

            //4.发送数据给客户端
            os.write("OK！已收到！".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5.关闭资源
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //客户端
    @Test
    public void client() {
        Socket socket = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        FileInputStream fis = null;
        ByteArrayOutputStream baos = null;
        try {
            //1.创建socket对象
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);

            //2.获取输入输出流
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            //3.传图片到服务端
            fis = new FileInputStream(new File("src/net/test.png"));
            byte[] buff = new byte[20];
            int len;
            while ((len = fis.read(buff)) != -1) {
                outputStream.write(buff, 0, len);
            }
            //4.传输完需要关闭一下socket的output，表示对服务端说我这个传完了
            socket.shutdownOutput();

            //5.接收服务端的消息
            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[30];
            int i;
            while ((i = inputStream.read(bytes)) != -1) {
                baos.write(bytes, 0, i);
            }
            System.out.println(baos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //6.关闭资源
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

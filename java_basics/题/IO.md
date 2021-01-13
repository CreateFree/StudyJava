# IO 

- 流的三种分类方式；

- 写出4个IO流的抽象基类、4个文件流、4个处理流；

- 字节流与字符流的区别与使用情景；

- 使用缓冲流实现a.jpg到b.jpg的复制操作；

- 转换流是那两个类，分别的作用是什么？请分别创建两个类的对象。






















---
答案：
- 按流向分：输入流、输出流  
  按数据单位分：字节流、字符流  
  按流的角色分：节点流、处理流  
  
- InputStream   FileInputStream     BufferedInputStream  
  OutputStream  FileOutputStream    BufferedOutputStream  
  Reader        FileReader          BufferedReader  
  Writer        FileWriter          BufferedWriter
  
- 字节流：操作非文本文件的流，也可以对文本文件进行复制；  
    read(byte[] buffer)  
  字符流：操作文本文件的流；
    read(char[] cbuffer)  
  其区别就在于处理单位上。
    
- 使用缓冲流实现a.jpg到b.jpg的复制操作；  
BufferedInputStream bis = null;  
BufferedOutputStream bos = null;  
try{
    bis = new BufferedInputStream(new File("a.jpg"));  
    bos = new BufferedOutputStream(new File("b.jgp"));  
    byte[] buffer = new byte[1024];  
    int len;  
    while((len = bis.read(buffer)) != -1){  
        bos.write(buffer,0,len)
    }  
}catch(IOException e){  
    e.printStackTrace();  
}finally{  
  if(bos != null){  
    try{  
      bos.close();  
    }catch(IOException e){  
      e.printStackTrace();  
    }       
  }  
  if(bis != null){  
    try{  
      bos.close();  
    }catch(IOException e){  
      e.printStackTrace();  
    }  
  }  
}  
   
-  转换流是那两个类，分别的作用是什么？请分别创建两个类的对象。  

InputStreamReader: 将输入的字节流转换为输入的字符流，解码。

OutputStreamWriter: 将输出的字节流转换为输出的字符流，编码。

InputStreamReader isr = new InputStreamReader(new FileInputStream("a.txt"),"utf-8");

OutputStreamWriter osr = new OutputStreamWriter(new FileOutputStream("b.txt"),"gbk");
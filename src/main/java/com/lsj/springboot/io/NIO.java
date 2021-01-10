package com.lsj.springboot.io;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by 10326 on 2021/1/8.
 */
public class NIO {

    public static void main(String[] args){

    }
    public static void method2(){
        InputStream in = null;
        try{
            in = new BufferedInputStream(new FileInputStream("src/nomal_io.txt"));
            byte [] buf = new byte[1024];
            int bytesRead = in.read(buf);
            while(bytesRead != -1) {
                for(int i=0;i<bytesRead;i++)
                    System.out.print((char)buf[i]);
                bytesRead = in.read(buf);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                if(in != null){
                    in.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * NIO——FileChannel
     * 当向buffer写入数据时，buffer会记录下写了多少数据。
     * 一旦要读取数据，需要通过flip()方法将Buffer从写模式切换到读模式。在读模式下，可以读取之前写入到buffer的所有数据。
     * 一旦读完了所有的数据，就需要清空缓冲区，让它可以再次被写入。
     * 有两种方式能清空缓冲区：调用clear()或compact()方法。clear()方法会清空整个缓冲区。compact()方法只会清除已经读过的数据。任何未读的数据都被移到缓冲区的起始处，新写入的数据将放到缓冲区未读数据的后面。
     */
    public static void method1(){
        RandomAccessFile aFile = null;
        try{
            aFile = new RandomAccessFile("src/nio.txt", "rw");
            //1.写入数据到Buffer
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);
            while(bytesRead != -1) {
                //2.调用flip()方法。一旦要读取数据，需要通过flip()方法将Buffer从写模式切换到读模式。在读模式下，可以读取之前写入到buffer的所有数据。
                buf.flip();
                //3.从Buffer中读取数据
                while(buf.hasRemaining()) {
                    System.out.print((char)buf.get());
                }
                //4.调用clear()方法或者compact()方法
                buf.compact();
                bytesRead = fileChannel.read(buf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile != null){
                    aFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}

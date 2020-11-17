package com.lsj.springboot.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.Socket;

/**
 * 消费者端的动态代理，如果你是把提供者和消费者写在两个工程中，则提供者端需要上面的接口和实现类，而消费者端只需要上面的接口。
 */
public class ConsumerProxy {
    /**
     * 消费者端的动态代理
     * @param interfaceClass 代理的接口类
     * @param host 远程主机IP
     * @param port 远程主机端口
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T consume(final Class<T> interfaceClass,final String host,final int port) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(),
                new Class[]{interfaceClass}, (proxy,method,args) -> {
                    //创建一个客户端套接字
                    Socket socket = new Socket(host, port);
                    try {
                        //创建一个对外传输的对象流，绑定套接字
                        ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
                        try {
                            //将动态代理的方法名写入对外传输的对象流中
                            output.writeUTF(method.getName());
                            //将动态代理的方法的参数写入对外传输的对象流中
                            output.writeObject(args);
                            //创建一个对内传输的对象流，绑定套接字
                            //这里是为了获取提供者端传回的结果
                            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                            try {
                                //从对内传输的对象流中获取结果
                                Object result = input.readObject();
                                if (result instanceof Throwable) {
                                    throw (Throwable) result;
                                }
                                return result;
                            } finally {
                                input.close();
                            }
                        } finally {
                            output.close();
                        }
                    } finally {
                        socket.close();
                    }
                }
        );
    }
}

package com.lsj.springboot.io;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * Created by 10326 on 2021/1/10.
 */
public class NettyNioServer {
    public void serve(int port) throws InterruptedException {
        final ByteBuf buffer = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Hi\r\n", Charset.forName("UTF-8")));
        // 第一步，创建线程池
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);// EventLoopGroup：一个Group包含多个EventLoop，可以理解为线程池 EventLoop：处理具体的Channel，一个EventLoop可以处理多个Channel
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{
            // 第二步，创建启动类 Bootstrap：netty的组件容器，用于把其他各个部分连接起来；如果是TCP的Server端，则为ServerBootstrap.
            ServerBootstrap b = new ServerBootstrap();
            // 第三步，配置各组件
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)//Channel：代表一个Socket的连接
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {// ChannelPipeline：每个Channel绑定一个pipeline，在上面注册处理逻辑handler
                            socketChannel.pipeline().addLast(new ChannelInboundHandlerAdapter(){// Handler：具体的对消息或连接的处理，有两种类型，Inbound和Outbound。分别代表消息接收的处理和消息发送的处理。
                                @Override
                                public void channelActive(ChannelHandlerContext ctx) throws Exception {
                                    ctx.writeAndFlush(buffer.duplicate()).addListener(ChannelFutureListener.CLOSE);
                                }
                            });
                        }
                    });
            // 第四步，开启监听
            ChannelFuture f = b.bind().sync();// ChannelFuture：注解回调方法
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully().sync();
            workerGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NettyNioServer server = new NettyNioServer();
        server.serve(5555);
    }
}

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
 * 1 ChannelOutboundHandler要在最后一个Inbound之前
 * Created by 10326 on 2021/1/10.
 */
public class NettyNioServerHandlerTest {
    final static ByteBuf buffer = Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Hi\r\n", Charset.forName("UTF-8")));

    public void serve(int port) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast("1",new InboundA());
                            pipeline.addLast("2",new OutboundA());
                            pipeline.addLast("3",new InboundB());
                            pipeline.addLast("4",new OutboundB());
                            pipeline.addLast("5",new OutboundC());
                            pipeline.addLast("6",new InboundC());
                        }
                    });
            ChannelFuture f = b.bind().sync();
            f.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully().sync();
            workerGroup.shutdownGracefully().sync();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NettyNioServerHandlerTest server = new NettyNioServerHandlerTest();
        server.serve(5555);
    }

    private static class InboundA extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf buf = (ByteBuf)msg;
            System.out.println("InboundA read"+buf.toString(Charset.forName("UTF-8")));
            super.channelRead(ctx, msg);
        }
    }

    private static class InboundB extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf buf = (ByteBuf)msg;
            System.out.println("InboundB read"+buf.toString(Charset.forName("UTF-8")));
            super.channelRead(ctx, msg);
            // 从pipeline的尾巴开始找outbound
            ctx.channel().writeAndFlush(buffer);
        }
    }

    private static class InboundC extends ChannelInboundHandlerAdapter {
        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            ByteBuf buf = (ByteBuf)msg;
            System.out.println("InboundC read"+buf.toString(Charset.forName("UTF-8")));
            super.channelRead(ctx, msg);
            // 这样会从当前的handler向前找outbound
            //ctx.writeAndFlush(buffer);
        }
    }

    private static class OutboundA extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            System.out.println("OutboundA write");
            super.write(ctx, msg, promise);
        }
    }

    private static class OutboundB extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            System.out.println("OutboundB write");
            super.write(ctx, msg, promise);
        }
    }

    private static class OutboundC extends ChannelOutboundHandlerAdapter {
        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            System.out.println("OutboundC write");
            super.write(ctx, msg, promise);
        }
    }
}

package com.lsj.springboot.arithmetic.loadBalancing;

import java.util.Map;

/**
 * 平滑加权轮询
 * 平滑加权是一个算法，很神奇的算法，我们有必要先对这个算法进行讲解。比如A服务器的权重是5，B服务器的权重是1，C服务器的权重是1。这个权重，我们称之为“固定权重”，
 * 既然这个叫“固定权重”，那么肯定还有叫“非固定权重”的，没错，“非固定权重”每次都会根据一定的规则变动。
 *
 * 第一次访问，ABC的“非固定权重”分别是 5 1 1（初始），因为5是其中最大的，5对应的就是A服务器，所以这次选到的服务器就是A，
 * 然后我们用当前被选中的服务器的权重-各个服务器的权重之和，也就是A服务器的权重-各个服务器的权重之和。也就是5-7=-2，没被选中的服务器的“非固定权重”不做变化，
 * 现在三台服务器的“非固定权重”分别是-2 1 1。
 *
 * 第二次访问，把第一次访问最后得到的“非固定权重”+“固定权重”，现在三台服务器的“非固定权重”是3，2，2，因为3是其中最大的，3对应的就是A服务器，所以这次选到的服务器就是A，
 * 然后我们用当前被选中的服务器的权重-各个服务器的权重之和，也就是A服务器的权重-各个服务器的权重之和。也就是3-7=-4，没被选中的服务器的“非固定权重”不做变化，
 * 现在三台服务器的“非固定权重”分别是-4 2 2。
 *
 * 第三次访问，把第二次访问最后得到的“非固定权重”+“固定权重”，现在三台服务器的“非固定权重”是1，3，3，这个时候3虽然是最大的，但是却出现了两个，我们选第一个，
 * 第一个3对应的就是B服务器，所以这次选到的服务器就是B，然后我们用当前被选中的服务器的权重-各个服务器的权重之和，也就是B服务器的权重-各个服务器的权重之和。也就是3-7=-4，
 * 没被选中的服务器的“非固定权重”不做变化，现在三台服务器的“非固定权重”分别是1 -4 3……以此类推，最终得到这样的表格：
 */
public class SmoothWeightRound {

    private static Servers servers = new Servers();

    public static String go() {
        Server maxWeightServer = null;

        int allWeight = servers.serverMap.values().stream().mapToInt(Server::getWeight).sum();

        for (Map.Entry<String, Server> item : servers.serverMap.entrySet()) {
            Server currentServer = item.getValue();
            if (maxWeightServer == null || currentServer.getCurrentWeight() > maxWeightServer.getCurrentWeight()) {
                maxWeightServer = currentServer;
            }
        }
        assert maxWeightServer != null;
        maxWeightServer.setCurrentWeight(maxWeightServer.getCurrentWeight() - allWeight);

        for (Map.Entry<String, Server> item : servers.serverMap.entrySet()) {
            Server currentServer = item.getValue();
            currentServer.setCurrentWeight(currentServer.getCurrentWeight() + currentServer.getWeight());
        }
        return maxWeightServer.getIp();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 15; i++) {
            System.out.println(go());
        }
    }

}

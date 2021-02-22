package com.lsj.springboot.loadBalancing;

public class Server {
    public Server(int weight, int currentWeight, String ip) {
        this.weight = weight;
        this.currentWeight = currentWeight;
        this.ip = ip;
    }

    private int weight;

    private int currentWeight;

    private String ip;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

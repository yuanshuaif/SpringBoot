package com.lsj.springboot.designMode.structural.combination;

public class Test {
    public static void main(String[] args){
        IFile file1,file2,file3,file4,file5,folder1,folder2,folder3,folder4;
        folder1 = new Folder("Sunny的资料");
        folder2 = new Folder("图像");
        folder3 = new Folder("文本");
        folder4 = new Folder("视频");

        file1 = new ImageFile("小龙女");
        file2 = new ImageFile("张无忌");
        file3 = new TextFile("九阴正经");
        file4 = new TextFile("葵花宝典");
        file5 = new VideoFile("笑傲江湖");

        folder2.createNewFile(file1);
        folder2.createNewFile(file2);
        folder3.createNewFile(file3);
        folder3.createNewFile(file4);
        folder4.createNewFile(file5);

        folder1.createNewFile(folder2);
        folder1.createNewFile(folder3);
        folder1.createNewFile(folder4);

        folder1.killVirus();

    }
}



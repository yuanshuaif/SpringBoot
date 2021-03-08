package com.lsj.springboot.designMode.structural.combination;

public interface IFile {
    //创建新文件，相当于add方法
    void createNewFile(IFile file);
    //相当于remove方法
    void deleteFile(IFile file);
    //相当于GetChild方法
    IFile getIFile(int index);
    // TODO 杀毒
    void killVirus();
}

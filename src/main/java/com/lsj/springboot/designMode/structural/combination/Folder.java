package com.lsj.springboot.designMode.structural.combination;

import java.util.ArrayList;
import java.util.List;

public class Folder implements IFile {

    private List<IFile> files = new ArrayList<>();

    private String name;

    public Folder(String name){
        this.name = name;
    }

    @Override
    public void createNewFile(IFile file) {
        files.add(file);
    }

    @Override
    public void deleteFile(IFile file) {
        files.remove(file);
    }

    @Override
    public IFile getIFile(int index) {
        return files.get(index);
    }

    @Override
    public void killVirus() {
        System.out.println("对" + name +  "文件夹杀毒");
        for (IFile iFile : files){
            iFile.killVirus();
        }
    }
}

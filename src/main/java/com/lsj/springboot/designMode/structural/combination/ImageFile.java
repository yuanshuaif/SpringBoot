package com.lsj.springboot.designMode.structural.combination;

public class ImageFile implements IFile {
    private String name;
    public ImageFile(String name){
        this.name = name;
    }
    @Override
    public void createNewFile(IFile file) {

    }

    @Override
    public void deleteFile(IFile file) {

    }

    @Override
    public IFile getIFile(int index) {
        return null;
    }

    @Override
    public void killVirus() {
        System.out.println("对"+ name +"文件进行杀毒");
    }
}

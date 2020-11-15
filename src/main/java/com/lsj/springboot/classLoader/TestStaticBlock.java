package com.lsj.springboot.classLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by 10326 on 2020/11/15.
 */
public class TestStaticBlock {
    static{
        System.out.println("static block init");
    }

    public static void main(String[] args){
        test();
    }


    public static void test(){
        Class<?> class0 = TestStaticBlock.class;
        try {
            System.out.println(class0.getClassLoader() instanceof MyClassLoader);
            Class<?> class1 = class0.getClassLoader().loadClass("com.lsj.springboot.classLoader.TestStaticBlock");
            ClassLoader classLoader = new MyClassLoader();
            Class<?> class2 = classLoader.loadClass("com.lsj.springboot.classLoader.TestStaticBlock");
            System.out.println(class1.equals(class2));
            /*我们虽然重写了ClassLoader的findClass()方法，但是并没有打破双亲委派模型。
            使用自定义类加载器加载TestStaticBlock最后还是被转发到了父类加载器，而从输出结果可以看出这个父类加载器就是class0.getClassLoader()。
            当然加载出来的类也会是同一个类。*/
           /* System.out.println(classLoader.getParent());
            System.out.println(class0.getClassLoader());*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //自定义一个类加载器从指定磁盘目录加载类
    public static class MyClassLoader extends ClassLoader {
        //不破坏双亲委派模型
        @Override
        protected Class<?> findClass(String name) {
            String myPath = "D:/dk/lsj/SpringBoot/src/main/java/" + name.replace(".","/") + ".class";
            System.out.println(myPath);
            byte[] classBytes = null;
            FileInputStream in = null;
            try {
                File file = new File(myPath);
                in = new FileInputStream(file);
                classBytes = new byte[(int) file.length()];
                in.read(classBytes);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Class<?> clazz = defineClass(name, classBytes, 0, classBytes.length);
            return clazz;
        }
        //破坏双亲委派模型
        // 以为这就结束了吗？naive。让我们看看运行结果：
        // java.io.FileNotFoundException: D:\myeclipseworkspace\class\java\lang\Object.class (系统找不到指定的路径。)
        // 由于我们打破了双亲委派模型，所以父类的加载（Object）也会交由我们自自定义的类加载器加载。而很明显在我们自定义的加载目录下是不会有Object.class这个文件的。
        // 如果不想打破双亲委派模型，就重写ClassLoader类中的findClass()方法即可，无法被父类加载器加载的类最终会通过这个方法被加载。
        // 而如果想打破双亲委派模型则需要重写loadClass()方法（当然其中的坑也不会少）。典型的打破双亲委派模型的框架和中间件有tomcat与osgi,如果相对java的类加载过程有更深入的了解学习这两个框架的源码会是不错的选择。
        @Override
        public Class<?> loadClass(String name)  throws ClassNotFoundException {
            String myPath = "D:/dk/lsj/SpringBoot/target/classes/" + name.replace(".","/") + ".class";
            System.out.println(myPath);
            byte[] classBytes = null;
            FileInputStream in = null;
            try {
                File file = new File(myPath);
                in = new FileInputStream(file);
                classBytes = new byte[(int) file.length()];
                in.read(classBytes);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Class<?> clazz = defineClass(name, classBytes, 0, classBytes.length);
            return clazz;
        }
    }
}

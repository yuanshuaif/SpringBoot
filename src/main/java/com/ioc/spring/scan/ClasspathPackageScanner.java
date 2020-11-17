package com.ioc.spring.scan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;


public class ClasspathPackageScanner implements PackageScanner {
    private Logger logger = LoggerFactory.getLogger(ClasspathPackageScanner.class);
    private String basePackage;
    private ClassLoader cl;

    /**
     * 初始化
     * @param basePackage
     */
    public ClasspathPackageScanner(String basePackage) {
        this.basePackage = basePackage;
        this.cl = getClass().getClassLoader();
    }
  /*  public ClasspathPackageScanner(String basePackage, ClassLoader cl) {
        this.basePackage = basePackage;
        this.cl = cl;
    }*/
    /**
     *获取指定包下的所有字节码文件的全类名
     */
    public List<String> getFullyQualifiedClassNameList() throws IOException {
        logger.info("开始扫描包{}下的所有类", basePackage);
        return doScan(basePackage, new ArrayList<>());
    }

    /**
     *doScan函数
     * @param basePackage
     * @param nameList
     * @return
     * @throws IOException
     */
    private List<String> doScan(String basePackage, List<String> nameList) throws IOException {
        String splashPath = StringUtil.dotToSplash(basePackage);
        URL url = cl.getResource(splashPath);   //file:/D:/javatool/SpringBoot/target/classes/com/ioc/spring/scan
        if(url == null){
            Thread.currentThread().getContextClassLoader().getResources(splashPath);
        }
        String filePath = StringUtil.getRootPath(url);
        List<String> names = null; // contains the name of the class file. e.g., Apple.class will be stored as "Apple"
        if (isJarFile(filePath)) {// 先判断是否是jar包，如果是jar包，通过JarInputStream产生的JarEntity去递归查询所有类
            if (logger.isDebugEnabled()) {
                logger.debug("{} 是一个JAR包", filePath);
            }
            names = readFromJarFile(filePath, splashPath);
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("{} 是一个目录", filePath);
            }
            names = readFromDirectory(filePath);
        }
        for (String name : names) {
            if (isClassFile(name)) {
                nameList.add(toFullyQualifiedName(name, basePackage));
            } else {
                doScan(basePackage + "." + name, nameList);
            }
        }
        if (logger.isDebugEnabled()) {
            for (String n : nameList) {
                logger.debug("找到{}", n);
            }
        }
        return nameList;
    }

    private String toFullyQualifiedName(String shortName, String basePackage) {
        StringBuilder sb = new StringBuilder(basePackage);
        sb.append('.');
        sb.append(StringUtil.trimExtension(shortName));
        //打印出结果
        System.out.println(sb.toString());
        return sb.toString();
    }

    private List<String> readFromJarFile(String jarPath, String splashedPackageName) throws IOException {
        if (logger.isDebugEnabled()) {
            logger.debug("从JAR包中读取类: {}", jarPath);
        }
        JarInputStream jarIn = new JarInputStream(new FileInputStream(jarPath));
        JarEntry entry = jarIn.getNextJarEntry();
        List<String> nameList = new ArrayList<String>();
        while (null != entry) {
            String name = entry.getName();
            if (name.startsWith(splashedPackageName) && isClassFile(name)) {
                nameList.add(name);
            }

            entry = jarIn.getNextJarEntry();
        }

        return nameList;
    }

    private List<String> readFromDirectory(String path) {
        File file = new File(path);
        String[] names = file.list();

        if (null == names) {
            return null;
        }

        return Arrays.asList(names);
    }

    private boolean isClassFile(String name) {
        return name.endsWith(".class");
    }

    private boolean isJarFile(String name) {
        return name.endsWith(".jar");
    }

    /**
     * https://www.cnblogs.com/juncaoit/p/7591778.html
     * 思路:
     * 1.有的web server在部署运行时会解压jar包，因此class文件会在普通的文件目录下。
     * 2.如果web server不解压jar包，则class文件会直接存在于Jar包中。
     * 3.对于前者，只需定位到class文件所在目录，然后将class文件名读取出即可；
     * 4.对于后者，则需先定位到jar包所在目录，然后使用JarInputStream读取Jar包，得到class类名。
     */
    public static void main(String[] args) throws Exception {
        PackageScanner scan = new ClasspathPackageScanner("jar");
        scan.getFullyQualifiedClassNameList();
    }
}

package com.ioc.spring.context;

import com.ioc.spring.annotation.IocResource;
import com.ioc.spring.annotation.IocService;
import com.ioc.spring.util.ClassUtil;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 模拟spring容器 管理对象的依赖注入
 */
public class SpringContext {
    private String path;
    /*String :beanId Object:serviceimpl*/
    ConcurrentHashMap<String,Object> initBean = null;
    ConcurrentHashMap<String,Object> creatingBean = new ConcurrentHashMap<>();// bean正在创建中，解决属性循环依赖的问题

    public SpringContext(String path){
        this.path = path;
    }


    /**
     * 根据beanid获取对应的bean
     * @param beanId
     * @return
     * @throws Exception
     */
    public Object getBean(String beanId) throws Exception{
        Object object = null;
        if(initBean != null && initBean.containsKey(beanId) && initBean.get(beanId) != null) {
            object = initBean.get(beanId);
        }else{
            List<Class> classes = findAnnoationService();
            if (classes == null || classes.isEmpty()) {
                throw new Exception("no found anything bean is useding initial..");
            }
            initBean = initBean(classes);
            if (initBean == null || initBean.isEmpty()) {
                throw new Exception("initial bean is empty or null");
            }
            object = initBean.get(beanId);
        }
        //初始化属性的依赖
        if(!creatingBean.containsKey(beanId)) {
            initAttribute(object, beanId);
        }
        return object;
    }

    /**
     * 初始化依赖的属性
     * @param object
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    private void initAttribute(Object object, String classBeanId)throws Exception{
        //获取object的所有类型
        Class<? extends Object> classinfo = object.getClass();
        //获取所有的属性字段
        Field[] fields = classinfo.getDeclaredFields();
        creatingBean.put(classBeanId, true);
        //遍历所有字段
        for(Field field : fields){
            //查找字段上有依赖的注解
            boolean falg = field.isAnnotationPresent(IocResource.class);
            if (falg){
                IocResource iocResource = field.getAnnotation(IocResource.class);
                if (iocResource!=null){
                    //获取属性的beanid
                    String beanId = "";
                    if (iocResource != null){
                        //如果定义了name属性 以实现的name属性为主否则以默认的规则为主
                        String value = iocResource.name();
                        if (value != null && !value.equals("")){
                            beanId = value;
                        }
                        else {
                            beanId = toLowerCaseFirstOne(field.getClass().getSimpleName());
                        }
                    }
                    //获取对应的object
                    Object attrObject = getBean(beanId);
                    if (attrObject!=null){
                        //访问私有字段
                        field.setAccessible(true);
                        //赋值
                        field.set(object,attrObject);
                        continue;
                    }
                }
            }
        }
    }

    /**
     * 初始化bean
     * @param classes
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public ConcurrentHashMap<String,Object> initBean(List<Class> classes) throws IllegalAccessException, InstantiationException{
        ConcurrentHashMap<String,Object> map = new ConcurrentHashMap<String, Object>();
        String beanId="";
        for(Class clazz : classes){
            Object object = clazz.newInstance();
            IocService annotation =(IocService)clazz.getDeclaredAnnotation(IocService.class);
            if (annotation!=null){
                //如果定义了name属性 以实现的name属性为主否则以默认的规则为主
                String value = annotation.name();
                if (value!=null && !value.equals("")){
                    beanId = value;
                }
                else {
                    beanId = toLowerCaseFirstOne(clazz.getSimpleName());
                }
            }

            //存储值
            map.put(beanId,object);
        }
        return map;
    }

    /**
     * 查找包路径下面所有添加注解的类 @IocService
     * @return
     * @throws Exception
     */
    private List<Class> findAnnoationService() throws Exception{
        if (path == null || path.equals("")){
            throw new Exception("scan package address is null or empty..");
        }
        //获取包下面所有的类
        List<Class<?>> classes = ClassUtil.getClasses(path);
        if (classes == null || classes.size() == 0){
            throw new Exception("not found service is added annoation for @iocservice");
        }
        List<Class> annoationClasses = new ArrayList<>();
        for (Class clazz : classes){
            //通过反射机制 查找增加了注解的类
            IocService iocService = (IocService) clazz.getDeclaredAnnotation(IocService.class);
            if (iocService != null){
                annoationClasses.add(clazz);
                continue;
            }
        }
        return annoationClasses;
    }


    /**
     * 首字母转换为小写
     * @param s
     * @return
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))){
            return s;
        }
        else{
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }
}

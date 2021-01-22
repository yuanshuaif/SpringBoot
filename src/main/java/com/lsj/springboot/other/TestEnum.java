package com.lsj.springboot.other;

/**
 * Created by Administrator on 2018/12/9.
 */
public class TestEnum {
    /**
     * 1.常量。
     * 在JDK1.5 之前，我们定义常量都是： public static final.... 。
     * 有了枚举，可以把相关的常量分组到一个枚举类型里
     */
    enum enumW{
        LSJ,LTJ,LY,DK
    }

    /**
     * 2.switch.
     * JDK1.6之前的switch语句只支持int,char,enum类型，使用枚举，能让我们的代码可读性更强。
     */
    enumW w = enumW.LSJ;
    public void change(){
        switch (w){
            case LSJ :
                w = enumW.LTJ;
                break;
            case LTJ :
                w = enumW.LY;
                break;
            case LY :
                w = enumW.DK;
                break;
            case DK :
                w = enumW.LSJ;
                break;
        }
    }
    /**
     * 3.向枚举中添加新方法
     * 如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。
     * 4.覆盖枚举的方法
     * toString()方法覆盖的例子。
     * 5.实现接口
     * 所有的枚举都继承自java.lang.Enum类。由于Java 不支持多继承，所以枚举对象不能再继承其他类。
     */

    interface Behaviour {
        String getInfo();
    }
    enum Color implements Behaviour{
        RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
        // 成员变量
        private String name;
        private int index;

        /**
         * 内部类构造方法的修饰词  private 和 不加
         * @param name
         * @param index
         */
        private Color(String name, int index){
            this.name = name;
            this.index = index;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
        // 普通方法  
        public static String getName(int index) {
            for (Color c : Color.values()) {// 枚举的循环
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return "Color{" +
                    "name='" + name + '\'' +
                    "- index=" + index +
                    '}';
        }
       @Override
       public String getInfo() {
           return this.name;
       }

    }
    static Color c = Color.RED;
    public static void main(String[] args){
        System.out.println(c.getName()+":"+c.getIndex()+":"+c.getName(2)+":"+c.toString()+":"+c.getInfo());
    }

}

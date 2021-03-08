package com.lsj.springboot.designMode.behavior.iterator;

/**
 * Created by 10326 on 2019/10/11.
 * 迭代器的抽象接口
 */
public interface Iterator<E> {

    boolean hasNext();

    E next();

    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

}

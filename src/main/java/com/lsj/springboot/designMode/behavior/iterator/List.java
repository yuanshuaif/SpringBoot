package com.lsj.springboot.designMode.behavior.iterator;

/**
 * Created by 10326 on 2019/10/11.
 */
public interface List<E> {

    int size();

    boolean add(E e);

    E remove(int index);

    Iterator<E> iterator();

}

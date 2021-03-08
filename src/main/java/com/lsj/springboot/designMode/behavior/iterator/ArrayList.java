package com.lsj.springboot.designMode.behavior.iterator;

import java.util.ConcurrentModificationException;
import java.util.NoSuchElementException;

/**
 * Created by 10326 on 2019/10/11.
 */
public class ArrayList<E> implements List<E>{

    Object[] elements;

    private int size;

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public ArrayList(){
        elements = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public ArrayList(int i){
        if(i > 0) {
            elements = new Object[i];
        }else if(i == 0){
            elements = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        }else{
            throw new RuntimeException("Illegal Capacity: "+ i);
        }
    }

    /**
     * 数组扩容复制
     * @param size
     */
    private void ensureCapacityInternal(int size){
        Object[] newElements = new Object[size]; //新数组长度
        for(int i = 0; i < elements.length; i++){     //复制
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e){
        ensureCapacityInternal(size + 1);
        elements[size++] = e;
        return true;
    }

    @Override
    public E remove(int index) {

        if(index >= size)
            throw new IndexOutOfBoundsException("Index: "+index+", Size: "+size);

        E oldValue = (E) elements[index];
        int numMoved = size - index - 1;// 需要移动的元素数

        if(numMoved > 0)
            System.arraycopy(elements, index + 1, elements, index, numMoved);// 数组移动

        elements[--size] = null;

        return oldValue;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iter();
    }

    private class Iter<E> implements Iterator<E>{

        int cursor;// 当前位置
        int lastRet = -1;//上一个位置

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {

            if(cursor >= size)
                throw new NoSuchElementException();

            Object[] elementData = ArrayList.this.elements;

            if(cursor >= elementData.length)
                throw new ConcurrentModificationException();

            lastRet = cursor++;
            return (E)elementData[lastRet];

        }

        /**
         * 必须next()才能remove，否则会抛出异常IllegalStateException
         */
        @Override
        public void remove() {

            if (lastRet < 0)
                throw new IllegalStateException();

            ArrayList.this.remove(lastRet);
            cursor = lastRet;
            lastRet = -1;//防止连续调用remove，所以将lastRet置为无效

        }
    }
}

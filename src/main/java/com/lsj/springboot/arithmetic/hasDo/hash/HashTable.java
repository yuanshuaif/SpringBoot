package com.lsj.springboot.arithmetic.hasDo.hash;

public class HashTable<K, V> {

    private int size;//元素个数
    private static int initialCapacity = 16;//HashTable的初始容量
    private Entry<K,V> table[];//实际存储数据的数组对象
    private static float loadFactor = 0.75f;//加载因子
    private int threshold;//阀值，能存的最大的数max = initialCapacity * loadFactor

    //构造指定容量和加载因子的构造器
    public HashTable(int initialCapacity, float loadFactor){
        if(initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity:"+initialCapacity);
        if(loadFactor <= 0)
            throw new IllegalArgumentException("Illegal loadFactor:"+loadFactor);
        this.loadFactor = loadFactor;
        threshold = (int)(initialCapacity * loadFactor);
        table = new Entry[threshold];
    }

    //使用默认参数的构造器
    public HashTable(){
        this(initialCapacity, loadFactor);
    }

    //放入元素
    public boolean put(K key,V value){
        //取得在数组中的索引值
        int hash = key.hashCode();
        Entry<K,V> temp = new Entry(key, value, hash);
        if(addEntry(temp, table)){
            size++;
            return true;
        }
        return false;
    }

    //添加元素到指定索引处
    private boolean addEntry(HashTable<K, V>.Entry<K, V> temp,
                             HashTable<K, V>.Entry<K, V>[] table) {
        //1.取得索引值
        int index = indexFor(temp.hash, table.length);
        //2.根据索引找到该位置的元素
        Entry<K,V> entry = table[index];
        //2.1非空，则遍历并进行比较
        if(entry != null){
            while(entry != null){
                if((temp.key == entry.key || temp.key.equals(entry.key)) && temp.hash == entry.hash) {
                    entry.value = temp.value;
                    return false;
                }else{
                    if(entry.next == null)
                        break;
                    entry = entry.next;
                }
            }
            //2.2链接在该索引位置处最后一个元素上
            addEntryLast(temp, entry);
        }else {
            //3.若空则直接放在该位置
            setFirstEntry(temp, index, table);
        }
        //4.插入成功，返回true
        return true;
    }

    //链接元素到指定索引处最后一个元素上
    private void addEntryLast(HashTable<K, V>.Entry<K, V> temp,
                              HashTable<K, V>.Entry<K, V> entry) {
        entry.next = temp;
        if(size >= threshold)
            reSize(table.length * 2);
    }

    //初始化索引处的元素值
    private void setFirstEntry(HashTable<K, V>.Entry<K, V> temp, int index,
                               HashTable<K, V>.Entry<K, V>[] table) {
        table[index] = temp;
        if(size >= threshold)
            reSize(table.length * 2);
    }

    //扩容容量
    private void reSize(int newSize) {
        Entry<K,V>[] newTable = new Entry[newSize];
        threshold = (int) (loadFactor * newSize);
        for(int i = 0;i < table.length; i++){
            Entry<K,V> entry = table[i];
            //数组中，实际上每个元素都是一个链表，所以要遍历添加
            while (entry != null){
                Entry<K, V> temp = entry;
                entry = entry.next;
                temp.next = null;
                reSize(temp, newTable);
            }
        }
        table = newTable;
    }

    //添加元素到指定索引处
    private void reSize(HashTable<K, V>.Entry<K, V> temp,
                             HashTable<K, V>.Entry<K, V>[] table) {
        //1.取得索引值
        int index = indexFor(temp.hash, table.length);
        //2.根据索引找到该位置的元素
        Entry<K,V> entry = table[index];
        //2.1非空，则遍历并进行比较
        if(entry != null){
            while(entry != null){
                if((temp.key == entry.key || temp.key.equals(entry.key)) && temp.hash == entry.hash) {
                    entry.value = temp.value;
                    break;
                }else{
                    if(entry.next == null)
                        break;
                    entry = entry.next;
                }
            }
            //2.2链接在该索引位置处最后一个元素上
            entry.next = temp;
        }else {
            table[index] = temp;
        }
    }


    //计算索引值
    private int indexFor(int hash, int tableLength) {
        //通过逻辑与运算，得到一个比tableLength小的值
        return hash & (tableLength - 1);
    }

    //取得与key对应的value值
    protected V get(K k){
        Entry<K,V> entry;
        int hash = k.hashCode();
        int index = indexFor(hash, table.length);
        entry = table[index];
        if(entry == null)
            return null;
        while(entry != null){
            if(entry.key == k || entry.key.equals(k))
                return entry.value;
            entry=entry.next;
        }
        return null;
    }

    //内部类，包装需要存在哈希表中的元素
    class Entry<K, V>{
        Entry<K, V> next;
        K key;
        V value;
        int hash;

        Entry(K k, V v, int hash){
            this.key = k;
            this.value = v;
            this.hash = hash;
        }
    }

    public static void main(String[] args){
        HashTable table = new HashTable(2, 0.75F);
        table.put(2, 7);
        table.put(1, 7);
        table.put(3, 7);
        table.put(4, 7);
        System.out.println(table.size);
    }

}

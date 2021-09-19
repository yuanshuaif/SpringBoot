package com.lsj.springboot.arithmetic.loadBalancing;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目690. 员工的重要性
 */
public class Weight {

    /**
     * 690. 员工的重要性
     * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
     * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
     * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
     *
     * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]],
     * 输出: 11
     * 解释: 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
     *
     * 1.一个员工最多有一个直系领导，但是可以有多个直系下属
     * 2.员工数量不超过2000。
     *
     * @param employees
     * @param id
     * @return
     */

    private int importance = 0;

    public int getImportance(List<Employee> employees, int id) {
        getSubImportance(employees, id);
        return importance;
    }

    public void getSubImportance(List<Employee> employees, int id){
        List<Integer> subordinates = null;
        for(Employee employee : employees){
            if(id == employee.id){
                importance += employee.importance;
                subordinates= employee.subordinates;
                if(subordinates != null) {
                    for (int subordinate : subordinates) {
                        getSubImportance(employees, subordinate);
                    }
                }
                break;
            }
        }
    }

    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };

    /**
     * 司龄越长中奖的概率越大
     * 如果司龄不是整数，可以四舍五入转换成整数，按整数取生成加权后的新数组
     *
     * 1.根据权重扩充数组得到一个新数组
     * 2.获取数组下标的随机数
     * 3.得到获奖员工
     */
    private static List<Person> persons = init();

    private static List<Person> init(){
        List<Person> persons = new ArrayList<>();
        Person person1 = new Person("lsj", 6);
        Person person2 = new Person("dk", 3);
        Person person3 = new Person("ltj", 1);
        Person person4 = new Person("ly", 2);
        Person person5 = new Person("ys", 8);
        Person person6 = new Person("lxz", 10);
        Person person7 = new Person("lyf", 1);
        Person person8 = new Person("lss", 4);
        Person person9 = new Person("xyz", 5);
        Person person10 = new Person("wqr", 20);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);
        persons.add(person4);
        persons.add(person5);
        persons.add(person6);
        persons.add(person7);
        persons.add(person8);
        persons.add(person9);
        persons.add(person10);
        return persons;
    }

    /**
     * 由原始数组得到加权重后的新数组
     * @param persons
     * @return
     */
    public static Person[] weightPersons(List<Person> persons){
        List<Person> peopleNew = new ArrayList<>();
        for(int i = 0; i < persons.size(); i++){
            Person person = persons.get(i);
            for(int j = 0; j <person.getWorkingLife(); j++){
                Person PersonNew = new Person(person.getName(), person.getWorkingLife());
                peopleNew.add(PersonNew);
            }
        }
        Person[] personArray = peopleNew.toArray(new Person[peopleNew.size()]);
        return personArray;
    }

    public static long randomNumber(int count){
        // Math.random()是令系统随机选取大于等于 0.0 且小于 1.0 的伪随机
        return Math.round(Math.random() * count);
    }

    public static Person winningPerson(List<Person> persons){
        Person[] weightPersons = weightPersons(persons);
        int random = (int) randomNumber(weightPersons.length - 1);
        return weightPersons[random];
    }


    public static void main(String[] args){
        /*for(int i = 0; i < 10000; i++) {
            long random = Math.round(Math.random() * 60);
            if(random <= 0 || random >= 60) {
                System.out.println(random);
            }
        }*/
        for(int i = 0; i < 100; i++) {
            Person person = winningPerson(persons);
            System.out.println("第i次抽奖：" + person);
        }
    }

    static class Person {

        private String name;
        private int workingLife;

        public Person(){

        }

        public Person(String name, int workingLife){
            this.name = name;
            this.workingLife = workingLife;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getWorkingLife() {
            return workingLife;
        }

        public void setWorkingLife(int workingLife) {
            this.workingLife = workingLife;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", workingLife='" + workingLife + '\'' +
                    '}';
        }
    }
}




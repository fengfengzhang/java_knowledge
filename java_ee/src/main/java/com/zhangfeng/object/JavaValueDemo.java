package com.zhangfeng.object;


class Student {
    int Age;

    @Override
    public String toString() {

        return String.valueOf(this.Age);
    }
}
public class JavaValueDemo {

    public static void test(Student s){
        s.Age = 13;
    }

    public static void test1(Student s){
        s = new Student();
    }

    public static void test2(Integer i){
        i = 4;
    }

    public static  void test3(String s){
        s = new String("124");
    }
    



    public static void main(String[] args) {
       /* Student s  = new Student();
        s.Age  =10;
        System.out.println(s);*/

        /*test(s);
        System.out.println(s);*/

        /*test1(s);
        System.out.println(s);*/

        /*Integer i = new Integer(5);
        System.out.println(i);
        test2(i);
        System.out.println(i);

        Integer i2 = new Integer(900);
        System.out.println(i2);
        test2(i2);
        System.out.println(i2);*/

        String s = "1";
        System.out.println(s);
        test3(s);
        System.out.println(s);

    }
}

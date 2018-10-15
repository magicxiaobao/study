package com.rokey.inheritance;

/**
 * @author chenyuejun
 * @create 2017-10-17 下午10:55.
 */
public class ChildClass extends FatherClass {

    private String childName;

    private Integer sex;

    public ChildClass() {

        System.out.println("11");
    }

    public ChildClass(String name, String childName, Integer sex) {

        super(name);
        this.childName = childName;
        this.sex = sex;
        System.out.println("ChildClass Constructor");
    }

    public static void main(String[] args) {

//        ChildClass childClass = new ChildClass();
          ChildClass childClass2 = new ChildClass("aa","bb", new Integer(1));
        System.out.println(childClass2);

    }

}

package com.rokey.basic;

/**
 * @author chenyuejun
 * @create 2017-09-12 下午3:03.
 */
public class Test1 {


    private static boolean flag = true;

    private static int count = 1;

    public static void main(String[] args) {
        if (count++ < 5) {

            System.out.println(count);
        }
        StaticStatementTest staticStatementTest = new StaticStatementTest();

	    Child child = new Child();
	    child.sayHello("aa");
	    child.setHobby("dota2");
	    String getChildHobby = child.getHobby();
	    getChildHobby = getChildHobby.replace("2", "3");
	    System.out.println(getChildHobby);
	    System.out.println(child.getHobby());
    }






}

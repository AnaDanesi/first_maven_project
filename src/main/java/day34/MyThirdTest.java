package day34;

import org.testng.annotations.Test;

/*
XML File
----
1) Create manually
2) Generate automatically

 */

public class MyThirdTest {

    @Test(priority = 1)
    void test1() {
        System.out.println("testing 1");
    }

    @Test(priority = 2)
    void test2() {
        System.out.println("testing 2");
    }

    @Test(priority = 3)
    void test3() {
        System.out.println("testing 3");
    }
}

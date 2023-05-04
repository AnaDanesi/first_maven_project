package day34;

/*
TestNG
--------
Test New Generation - java based unit testing tool.

Advantages:
-----
1) Test cases & test suites
2) Grouping of test cases.
3) Prioritize
4) Parameterization
5) parallel testing
6) Reports


java/maven project-->webdriver--> testng

1) by adding dependency
2) by installing testng plugin in eclipse


Install TestNG in eclipse
-------------
Help menu--> Eclipse market place-->Search for TestNG for eclipse--> Install

Window-->Preferences-->TestNG

Add testng dependency to pom.xml.

TestSuite--->Test cases---->Test steps
Package/xml-->classes---->TestMethods

****  we do not have main method...

Test case
-
1) open app
2) Login
3) close

priority - control the order of execution,  if not it is alphabetical

If you do not add @Test annotation then testng will not execute that method.
 */

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test()

public class MyFirstTest {

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

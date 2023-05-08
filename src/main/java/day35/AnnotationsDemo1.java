package day35;

/*
-------
Annotations
----
@Test

@BeforeMethod
@AfterMethod

@BeforeClass
@AfterClass

@BeforeTest
@AfterTest

@BeforeSuite
@AfterSuite



Suite-->Tests--->Classes--->Methods

XML -- Tests----Classes--->Methods

TC1
----
1) Login - @BeforeMethod
2) Search  -   @Test
3) Logout - @AfterMethod
4) Login
5) Advanced search  -- @Test
6) Logout

 */

import org.testng.annotations.*;
/*import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
*/

public class AnnotationsDemo1 {

    @BeforeMethod
    void login() {
        System.out.println("Login...");
    }

    @Test (priority = 1)
    void search() {
        System.out.println("Search test...");
    }

    @Test (priority = 2)
    void advancedsearch() {
        System.out.println("Advanced search...");
    }

    @AfterMethod
    void logout() {
        System.out.println("Logout...");
    }
}

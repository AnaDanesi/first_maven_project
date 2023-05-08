package day35;
/*
TC1
----
1) Login - @BeforeClass
2) Search  - @Test
3) Advanced search  - @Test
4) Logout  - @AfterClass
 */

import org.testng.annotations.*;

public class AnnotationsDemo2 {

    @BeforeClass
    void login()
    {
        System.out.println("Login...");
    }

    @Test(priority=1)
    void search()
    {
        System.out.println("Search...");
    }

    @Test(priority=2)
    void advancedsearch()
    {
        System.out.println("Advanced search...");
    }

    @AfterClass
    void logout()
    {
        System.out.println("Logout...");
    }
}

package day35;
/*
Dependecy methods
----------


Assertions
----------
validations

Hard assertions
----
access though 'Assert' class
all methods are static
if hard assertion got failed then rest of the statement will not be executed.

Soft assertions
-----------
access through 'SoftAssert' object

SoftAssert sa=new SoftAssert();
sa.assertTrue()

if soft assertion got failed then rest of the statements still execute.
 */
import org.testng.annotations.*;
public class DependentMethods {
    @Test(priority=1)
    void openapp()
    {
        Assert.assertTrue(true);
    }

    @Test(priority=2, dependsOnMethods= {"openapp"})
    void login()
    {
        Assert.assertTrue(true);
    }

    @Test(priority=3, dependsOnMethods= {"login"})
    void search()
    {
        Assert.assertTrue(false);
    }

    @Test(priority=4, dependsOnMethods= {"login","search"})
    void advsearch()
    {
        Assert.assertTrue(true);
    }

    @Test(priority=5, dependsOnMethods= {"login"})
    void logout()
    {
        Assert.assertTrue(true);
    }
}

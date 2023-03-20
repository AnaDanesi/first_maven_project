package day21YouTube;

/*
1)Find the sign-up button from the registration form in the facebook application (child)
//div[@id='reg_form_box']/child::div[11]/button

2)Locate Firstname from sign-up button in the same  page (parent)
//button[@id='u_6_s_7A']/parent::/parent::/child::/child::div[1]/div/div[1]

3)Identify the password from mobile number field in facebook (following)
//input[@id='u_0_r']/following::input[2]

4) Locate mobile number from new password field in facebook (preceding)
//input[@id='password_step_input']/preceding::input[2]

5)Locate surname from female radio button in facebook (ancestor)
//input[@id='u_0_4']/ancestor::div[2]/div[1]/div/div[2]
//input[@id='u_0_4']/ancestor::div[2]/input[@id='u_0_o']

6)Identify the search text box from the google search button present in the google search page (parent)
//div[@class='FPdoLc lJ9FBc']//input[@name='btnK']/parent::/parent::/parent::/div[1]

7) Identify the today's deals from de amazon search text box in amazon page (following)
//input[@id='twotabsearchtextbox']/following::a[normalize-space()='Ofertas']

8)Identify the Hello, signin from the amazon search text box present in the amazon home web page (following)
//input[@id='twotabsearchtextbox']/following::span[@id='nav-link-accountList-nav-line-1']

9)Identify ofertas link which is part of menu bar - amazon (descendant)
//div[@id='nav-xshop-container']/descendant::a[normalize-space()='Ofertas']

 */
public class Assignments {

    public static void main(String[] args) {


    }
}

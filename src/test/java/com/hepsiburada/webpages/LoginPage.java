package com.hepsiburada.webpages;

import com.hepsiburada.utilities.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy (id = "txtUserName")
    private WebElement userMail;

    @FindBy (id = "btnLogin")
    private  WebElement loginButton;

    @FindBy (id = "txtPassword")
    private WebElement userPassword;

    @FindBy (id = "btnEmailSelect")
    private WebElement eMailSelect;


    public void typeUserMail(String mail) {
        this.userMail.clear();
        this.userMail.sendKeys(mail);
    }

    public void clickLoginButton(){
        this.loginButton.click();
    }

    public void typeUserPassword(String password) {
        this.userPassword.clear();
        this.userPassword.sendKeys(password);
    }

    public void clickEMailSelect (){
        this.eMailSelect.click();
    }


    public LoginPage(WebDriver driver){ super(driver); }
}

package pages;

import org.openqa.selenium.By;

import static helper.Utility.driver;

public class WebPage {

    By input_username = By.cssSelector("#user-name");
    By input_pwd = By.cssSelector("#password");
    By btn_login = By.cssSelector("#login-button");

    public void goToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String username) {
        driver.findElement(input_username).sendKeys(username);
    }

    public void inputPwd(String pwd) {
        driver.findElement(input_pwd).sendKeys(pwd);
    }

    public void clickBtnLogin(){
        driver.findElement(btn_login).click();
    }
}

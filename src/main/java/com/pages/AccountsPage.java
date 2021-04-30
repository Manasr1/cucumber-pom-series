package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {
    private WebDriver driver;

    private By dashboardsection = By.cssSelector(" td:nth-child(n) div a span");

    public AccountsPage(WebDriver driver){
        this.driver = driver;
    }

    public int getAccountSectionCount() {
       return driver.findElements(dashboardsection).size();
    }

    public List<String> getAccountSectionList() {
        List<WebElement> ls = driver.findElements(dashboardsection);
        List<String> expectedAccountSection = new ArrayList<>();
        for (WebElement lst : ls) {
            String accountSection = lst.getText();
            System.out.println("Accounts section--" + accountSection);
            expectedAccountSection.add(accountSection);
        }
        return expectedAccountSection;
    }

    public String getAccountsPageTitle(){
        return driver.getTitle();
    }
}

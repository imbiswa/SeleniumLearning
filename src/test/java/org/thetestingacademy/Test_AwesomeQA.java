package org.thetestingacademy;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class Test_AwesomeQA {
    WebDriver driver = new ChromeDriver();

    @Description("Verify new user registration for awesomeQA")
    @Test(priority = 1)
    public void Verify_New_user_registration()
    {

        driver.get("https://awesomeqa.com/ui/index.php?route=account/register");
        driver.manage().window().maximize();

        if( driver.getPageSource().contains("Register Account"))
        {
            driver.findElement(By.id("input-firstname")).sendKeys("Biswajit");
            driver.findElement(By.id("input-lastname")).sendKeys("Mallick");
            driver.findElement(By.id("input-email")).sendKeys("rnbiswajitmallick52@gmail.com");
            driver.findElement(By.id("input-telephone")).sendKeys("9999888823");
            driver.findElement(By.id("input-password")).sendKeys("9999888877");
            driver.findElement(By.id("input-confirm")).sendKeys("9999888877");
            driver.findElement(By.name("agree")).click();
            driver.findElement(By.xpath("//input[@value='Continue']")).click();
        }

        if(driver.getPageSource().contains("Your Account Has Been Created!"))
        {
            Assert.assertTrue(true);
            System.out.println("New Account creation verified");
        }

        System.out.println("Test1 completed");
        driver.close();
    }


    @Description("verify that username is not being displayed on the dashboard")
    @Test(priority = 2  )
    public void Verify_username_on_dashboard() throws InterruptedException {

        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/#/login");
        driver.manage().window().maximize();
        Thread.sleep(300);
        driver.findElement(By.id("login-username")).sendKeys("qa123@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("QAtester@1234");
        driver.findElement(By.xpath("//span[@data-qa='ezazsuguuy']")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

      if (Objects.requireNonNull(driver.getPageSource()).contains("qa-test"))
        {
            System.out.println("Verified");

        }
       // driver.findElement(By.xpath("//button[@title='user-menu']")).click();
        //driver.findElement(By.xpath("//li[@data-qa='logout-btn']")).click();

        System.out.println("Test 3 completed");
        driver.close();


    }
}

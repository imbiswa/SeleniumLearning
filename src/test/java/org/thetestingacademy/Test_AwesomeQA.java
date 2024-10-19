package org.thetestingacademy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selenium1 {


    @Test
    public void Verify_New_user_registration()
    {
        WebDriver driver = new ChromeDriver();
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
        driver.close();
    }
}

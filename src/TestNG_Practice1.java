package Homeworks.TestNG_Practice_POM_PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Practice1 extends BaseDriver {

    @Test(priority = 0)
    public void login(){
        // Navigate to:  http://automationpractice.com/index.php
        driver.navigate().to("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

        // Click on sign in button
        locators.signInButton.click();

        // Enter the email address
        locators.emailBox.sendKeys(email);

        // Enter the password
        locators.passwordBox.sendKeys(password);

        // Click on Sign in button
        locators.submitSignInButton.click();
    }

    @Test(dependsOnMethods = "login", priority = 1)
    public void addressTestCase(){
        wait.until(ExpectedConditions.visibilityOf(locators.myAddressesButton));

        String address = "Bahnhofstr. 30";
        try{
            // Click add my first address
            locators.addMyFirstAddressButton.click();

            // Enter all the fields (Choose random items from the dropdown)
            clearTextBoxAndSendKeys(locators.firstnameTextBox, "Group");
            clearTextBoxAndSendKeys(locators.lastnameTextBox, "Two");
            clearTextBoxAndSendKeys(locators.address1TextBox, address);
            clearTextBoxAndSendKeys(locators.cityTextBox, "Weissenthurm");
            Select categories = new Select(locators.stateDropDown);
            categories.selectByIndex(random.nextInt(categories.getOptions().size()));
            clearTextBoxAndSendKeys(locators.postcodeTextBox,"12345");
            clearTextBoxAndSendKeys(locators.phoneTextBox,"1234567890");

            // Click on save button
            locators.submitAddressButton.click();

        } catch (Exception e){ // if there is no add my first address button
            // click on my addresses button
            locators.myAddressesButton.click();
        }

        //get address
        String addedAdress = locators.address1TextInMyAddresses.getText();
        // Verify your address is displayed in the website
        Assert.assertEquals(address,addedAdress);

    }

    @Test(dependsOnMethods = {"login","addressTestCase"}, priority = 2)
    public void updateTestCase(){

        // Click on the update button
        locators.updateAddressButton.click();

        // Change the first name and last name
        clearTextBoxAndSendKeys(locators.firstnameTextBox, "Group");
        clearTextBoxAndSendKeys(locators.lastnameTextBox, "Two");

        // Click on save button
        locators.submitAddressButton.click();

        // Verify first name and last name is updated
        String firstName = locators.firstnameTextInMyAddresses.getText();
        String lastName = locators.lastnameTextInMyAddresses.getText();

        Assert.assertEquals(firstName, "Group");
        Assert.assertEquals(lastName, "Two");

    }

    @Test(dependsOnMethods = {"login","addressTestCase"}, priority = 3)
    public void removeAddressTestCase(){

        // Click on the delete button
        locators.deleteButtonInMyAddresses.click();

        // Click on the okay
        driver.switchTo().alert().accept();

        // Verify address is removed from the website
        String text = locators.alertTextInMyAddresses.getText();

        Assert.assertTrue(text.contains("No addresses"));

    }



}




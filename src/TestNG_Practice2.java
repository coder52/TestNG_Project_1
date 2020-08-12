package Homeworks.TestNG_Practice_POM_PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG_Practice2 extends BaseDriver {

    @Test(priority = 3)
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

    @Test(dependsOnMethods = "login",priority = 4)
    public void itemInWishlistTestCase(){

        // Click on dresses
        waitAndClick(locators.dressesButton);

        // Click on any item
        locators.itemsInDresses.get(0).click();
        String selectedProductName = locators.productNames.get(0).getText();

        // Click on the add to wishlist
        waitAndClick(locators.wishListButton);
        //wait loader
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".disabled")));
        waitAndClick(locators.fancyBox);

        // Click on the user name on the top right  (Next to sign out button )
        waitAndClick(locators.userNameTopRight);

        // Click on "My WISHLIST" button
        waitAndClick(locators.myWishListButton);

        // Click on My WISHLIST text
        waitAndClick(locators.myWishListText);

        // Verify Item is in the wishlist
        String text = waitAndGetText(locators.itemNameInWishList);

        Assert.assertTrue(text.contains(selectedProductName));
    }

    @Test(dependsOnMethods ={"login","itemInWishlistTestCase"}, priority = 5)
    public void itemNotInWishlistTestCase() {

        // Click on X button under the Item picture
        waitClickWait(locators.xButtonUnderPicture);

        // Click on My WISHLIST text
        waitAndClick(locators.myWishListText);

        // Verify item is not in the wishlist anymore
        try{

            // check visibility of product
            String style = driver.findElement(By.cssSelector(".wlp_bought li[style=\"display: none;\"]"))
                    .getAttribute("style");
            Assert.assertEquals("display: none;", style);

        } catch (Exception e){

            String text = waitAndGetText(locators.noProductAllertText);
            Assert.assertEquals("No products", text);

        }

        // Click on the X button under the Delete column
        locators.xButtonUnderDelete.click();

        // Click on the OK button
        driver.switchTo().alert().accept();

    }

}




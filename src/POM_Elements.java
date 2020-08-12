package Homeworks.TestNG_Practice_POM_PageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class POM_Elements {

    public POM_Elements(WebDriver driver){

        PageFactory.initElements(driver, this);

    }

    @FindBy(css = ".login")
    public WebElement signInButton;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "passwd")
    public WebElement passwordBox;


    @FindBy(id = "SubmitLogin")
    public WebElement submitSignInButton;

    @FindBy(css = "a[title*=\"first address\"]")
    public WebElement addMyFirstAddressButton;

    @FindBy(css = "a[title*=\"Addresses\"]")
    public WebElement myAddressesButton;

    @FindBy(className = "address_address1")
    public WebElement address1TextInMyAddresses;

    @FindBy(id = "firstname")
    public WebElement firstnameTextBox;

    @FindBy(id = "lastname")
    public WebElement lastnameTextBox;

    @FindBy(id = "address1")
    public WebElement address1TextBox;

    @FindBy(id = "city")
    public WebElement cityTextBox;

    @FindBy(id = "id_state")
    public WebElement stateDropDown;

    @FindBy(id = "postcode")
    public WebElement postcodeTextBox;

    @FindBy(id = "phone")
    public WebElement phoneTextBox;

    @FindBy(id = "submitAddress")
    public WebElement submitAddressButton;

    @FindBy(css = "[title=\"Update\"]")
    public WebElement updateAddressButton;

    @FindBy(css = ".address_name:first-child")
    public WebElement firstnameTextInMyAddresses;

    @FindBy(css = ".address_name:last-child")
    public WebElement lastnameTextInMyAddresses;

    @FindBy(css = "[title=\"Delete\"]")
    public WebElement deleteButtonInMyAddresses;

    @FindBy(className = "alert")
    public WebElement alertTextInMyAddresses;

    @FindBy(css = "#block_top_menu > ul > li:nth-child(2)")
    public WebElement dressesButton;

    @FindBy(css = "[itemprop=\"name\"] a")
    public List<WebElement> itemsInDresses;

    @FindBy(css = "[itemprop=\"name\"]")
    public List<WebElement> productNames;

    @FindBy(id = "wishlist_button")
    public WebElement wishListButton;

    @FindBy(css = ".fancybox-close")
    public WebElement fancyBox;

    @FindBy(css = ".header_user_info [href*=my-account]")
    public WebElement userNameTopRight;

    @FindBy(css = ".icon-heart")
    public WebElement myWishListButton;

    @FindBy(css = "tbody td:nth-child(1)>a")
    public WebElement myWishListText;

    @FindBy(id = "s_title")
    public WebElement itemNameInWishList;

    @FindBy(css = ".icon-remove-sign")
    public WebElement xButtonUnderPicture;

    @FindBy(className = "alert-warning")
    public WebElement noProductAllertText;

    @FindBy(className= "icon-remove")
    public WebElement xButtonUnderDelete;
}

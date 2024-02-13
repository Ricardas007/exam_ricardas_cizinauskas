package lt.techin.exam.ricardas.cizinausas;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class PrestaShopPage extends BasePage {
    public PrestaShopPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".products.row > div:nth-of-type(1) > .js-product-miniature.product-miniature h3 > a")
    WebElement getProductFirstName;

    @FindBy(css = ".products.row > div:nth-of-type(2) > .js-product-miniature.product-miniature h3 > a")
    WebElement getGetProductSecondName;

    @FindBy(css = ".products.row [alt='Hummingbird printed t-shirt']")
    WebElement firstProductPicture;

    @FindBy(css = ".wishlist-button-product .material-icons")
    WebElement firstItemAddToWishlist;

    @FindBy(css = ".modal-text")
    WebElement firstItemWarningMessageCatch;

    @FindBy(css = ".products.row [alt='Brown bear printed sweater']")
    WebElement secondProductPicture;

    @FindBy(css = ".wishlist-button-product .material-icons")
    WebElement secondItemAddToWishlist;

    @FindBy(css = ".modal-text")
    WebElement secondItemWarningMessageCatch;

    @FindBy(css = ".show .btn-secondary")
    WebElement firstItemClickCansel;

    @FindBy(css = "select#group_1")
    WebElement sizeDropDown;

    @FindBy(css = ".add-to-cart.btn.btn-primary")
    WebElement addToCart;

    @FindBy(css = "h4")
    WebElement addToCartProductInShoppingCart;

    @FindBy(css = ".cart-content-btn .btn-primary")
    WebElement clickOnProceedToCheckoutButton;

    @FindBy(css = "[data-id_customization]")
    WebElement isCorrectItemNameIsInShoppingCart;

    @FindBy(css = ".cart-items .value")
    WebElement isCorrectItemSizeInShoppingCart;

    @FindBy(css = ".discount.discount-percentage")
    WebElement itemDiscountPersentage;

    public String getProductNameOne(){
        String nameText = getProductFirstName.getText();
        return nameText;
    }

    public String getProductNameTwo(){
        String nameText = getGetProductSecondName.getText();
        return nameText;
    }

    public String firstItemTowhishlist(){
        firstProductPicture.click();
        firstItemAddToWishlist.click();
        String name = firstItemWarningMessageCatch.getText();
        return name;
    }

    public String secondItemToWhislist(){
        secondProductPicture.click();
        secondItemAddToWishlist.click();
        String name = secondItemWarningMessageCatch.getText();
        return name;
    }

    public void itemClickCansel() {
        firstItemClickCansel.click();
    }

    public void selectFirstItemSize() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='4'", sizeDropDown);
        addToCart.click();
    }

    public void selectSecondItemSize() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='2'", sizeDropDown);
        addToCart.click();
    }

    public String selectProductItemMessageAddedToCart(){
        String message = addToCartProductInShoppingCart.getText();
        return message;
    }

    public void clickToProceedToCheckout() {
        clickOnProceedToCheckoutButton.click();
    }

    public String checkItemName() {
        String itemName = isCorrectItemNameIsInShoppingCart.getText();
        return itemName;
    }
    public String checkItemSize() {
        String itemSize = isCorrectItemSizeInShoppingCart.getText();
        return itemSize;
    }


    public String countItemDiscountPrice() {
       String itemDicountPersentage = itemDiscountPersentage.getText();
       return itemDicountPersentage;
    }
}

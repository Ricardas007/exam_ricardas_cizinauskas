package lt.techin.exam.ricardas.cizinausas;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

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


    public void firstItemClickCansel() {
        firstItemClickCansel.click();
    }

    public void selectItemSize() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='4'", sizeDropDown);
        addToCart.click();
    }
    public String selectProductItemMessageAddedToCart(){
//        Wait<WebDriver> wait1 = new FluentWait<>(driver)
//                .withTimeout(Duration.ofSeconds(5))
//                .pollingEvery(Duration.ofSeconds(1))
//                .ignoring(NoSuchElementException.class);
//        WebElement landscaoe = wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("#myModalLabel")));
        String landscaoe = addToCartProductInShoppingCart.getText();
        return landscaoe;
    }
}

package lt.techin.exam.ricardas.cizinauskas;

import jdk.jfr.Description;
import lt.techin.exam.ricardas.cizinausas.PrestaShopPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class PrestaShopTest extends BaseTest{

    @Test
    @Description("Checking product one is product in product list")
    void getFirstProduct(){
        PrestaShopPage prestaShop = new PrestaShopPage(driver);
        String productName = "Hummingbird printed t-shirt";
        String productName1 = productName.toLowerCase();
        String productFromEshop = prestaShop.getProductNameOne().toLowerCase();
        Assertions.assertEquals(productName1, productFromEshop,"Product name must match product from e-shop name");
    }

    @Test
    @Description("Checking product two is product in product list")
    void getSecondProductName(){
        PrestaShopPage prestaShop = new PrestaShopPage(driver);
        String productName = "HUMMINGBIRD PRINTED SWEATER";
        String productName2 = productName.toLowerCase();
        String productFromEshop = prestaShop.getProductNameTwo().toLowerCase();
        Assertions.assertEquals(productName2, productFromEshop,"Product name must match product from e-shop name");
    }

    @Test
    @Description("Select product add to wishlist(Heaet symbol)")
    void addToWishlistProductOne() {
        PrestaShopPage prestaShop = new PrestaShopPage(driver);
        String webMessage = "You need to be logged in to save products in your wishlist.";
        String actual = prestaShop.firstItemTowhishlist();
        Assertions.assertEquals(webMessage,actual,"If you not Signed in following message will appear: You need to be logged in to save products in your wishlist");

    }

    @Test
    @Description("Second product add to wishlist(Heart symbol)")
    void addToWhishlistProductTwo() {
        PrestaShopPage prestaShop = new PrestaShopPage(driver);
        String webMessage = "You need to be logged in to save products in your wishlist.";
        String actual = prestaShop.secondItemToWhislist();
        Assertions.assertEquals(webMessage,actual,"If you not Signed in following message will appear: You need to be logged in to save products in your wishlist");
    }
    @Test
    @Description("First product.Press cencel and select size and click add to cart")
    void addToCartProductOne() throws InterruptedException {
        PrestaShopPage prstaShop = new PrestaShopPage(driver);
        prstaShop.firstItemTowhishlist();
        prstaShop.firstItemClickCansel();
        prstaShop.selectItemSize();
        Thread.sleep(5000);
        String webElement = String.valueOf(prstaShop.selectProductItemMessageAddedToCart()).substring(1).trim();
        Assertions.assertEquals("Product successfully added to your shopping cart",webElement);
    }
}

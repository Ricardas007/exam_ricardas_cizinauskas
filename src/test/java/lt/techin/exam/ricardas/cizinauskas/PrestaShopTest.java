package lt.techin.exam.ricardas.cizinauskas;

import jdk.jfr.Description;
import lt.techin.exam.ricardas.cizinausas.PrestaShopPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


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
    @Description("First product.Press cancel and select size and click add to cart")
    void addToCartProductOne() throws InterruptedException {
        PrestaShopPage prestaShop = new PrestaShopPage(driver);
        prestaShop.firstItemTowhishlist();
        prestaShop.itemClickCansel();
        prestaShop.selectFirstItemSize();
        Thread.sleep(5000);
        String webElement = String.valueOf(prestaShop.selectProductItemMessageAddedToCart()).substring(1).trim();
        Assertions.assertEquals("Product successfully added to your shopping cart",webElement);
    }

    @Test
    @Description("Second product. Press cansel select size and click add to cart")
    void addToCartProductTwo() throws InterruptedException {
        PrestaShopPage prestaShop = new PrestaShopPage(driver);
        prestaShop.secondItemToWhislist();
        prestaShop.itemClickCansel();
        prestaShop.selectSecondItemSize();
        Thread.sleep(5000);
        String webElement = String.valueOf(prestaShop.selectProductItemMessageAddedToCart().substring(1)).trim();
        Assertions.assertEquals("Product successfully added to your shopping cart",webElement);
    }

    @Test
    @Description("Fist product. Proceed to checkout, check if correct item, size and discount in shopping cart")
    void proceedFirstItemToCheckOut() throws InterruptedException {
        PrestaShopPage prestaShop = new PrestaShopPage(driver);
        String expectedProductName = ("Hummingbird printed t-shirt").toLowerCase();
        String expectedProductSize = ("XL").toLowerCase();
        String expectedDicount = "20";
        prestaShop.firstItemTowhishlist();
        prestaShop.itemClickCansel();
        prestaShop.selectFirstItemSize();
        prestaShop.clickToProceedToCheckout();
        Thread.sleep(5000);
        String itemName = prestaShop.checkItemName().toLowerCase();
        Assertions.assertEquals(expectedProductName,itemName,"Product name must match product from the list");
        String itemSize = prestaShop.checkItemSize().toLowerCase();
        Assertions.assertEquals(expectedProductSize,itemSize,"Producr size must match product from the list");
        prestaShop.countItemDiscountPrice();
        String itemPercentageDiscount = prestaShop.countItemDiscountPrice().substring(1,3).trim();
        Assertions.assertEquals(expectedDicount,itemPercentageDiscount,"Poduct discount must match discount form the list");
    }

    //Not working this test correctly not read name, size, discount.
    @Test
    @Description("Fist product. Proceed to checkout, check if correct item, size and discount in shopping cart")
    void proceedSecondItemToCheckOut() throws InterruptedException {
        PrestaShopPage prestaShop = new PrestaShopPage(driver);
        String expectedProductName = ("HUMMINGBIRD PRINTED SWEATER").toLowerCase();
        String expectedProductSize = ("M").toLowerCase();
        String expectedDicount = "20";
        prestaShop.secondItemToWhislist();
        prestaShop.itemClickCansel();
        prestaShop.selectSecondItemSize();
        Thread.sleep(5000);
        String itemName = prestaShop.checkItemName().toLowerCase();
        System.out.println(itemName);

    }

}

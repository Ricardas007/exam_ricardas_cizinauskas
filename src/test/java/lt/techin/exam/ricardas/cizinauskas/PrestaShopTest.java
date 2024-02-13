package lt.techin.exam.ricardas.cizinauskas;

import lt.techin.exam.ricardas.cizinausas.PrestaShopPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class PrestaShopTest extends BaseTest{
    protected String productName1;
    protected String productName2;

    @Test
    void serchForAProduckt(){
        PrestaShopPage prestaShop = new PrestaShopPage(driver);
        String productName = "Hummingbird printed t-shirt";
        String productName1 = productName.toLowerCase();
        String productFromEshop = prestaShop.getProductName().toLowerCase();
        Assertions.assertEquals(productName1, productFromEshop,"Product name must match product from e-shop name");
//        System.out.println(prestProduct1);
    }
}


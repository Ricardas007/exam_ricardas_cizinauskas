package lt.techin.exam.ricardas.cizinausas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrestaShopPage extends BasePage {
    public PrestaShopPage(WebDriver driver) {
        super(driver);

    }
    @FindBy(css = ".products.row > div:nth-of-type(1) > .js-product-miniature.product-miniature h3 > a")
    WebElement getProductName;

    public String getProductName(){
        String nameText = getProductName.getText();
        return nameText;
    }
}

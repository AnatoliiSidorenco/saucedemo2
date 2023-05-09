import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;

public class InventoryPage extends BasePage{
    public InventoryPage(WebDriver driver) {
       super(driver);
    }

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;
    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> inventoryNames;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> inventoryPrices;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuBtn;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCart;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeLightAddToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement tShortAddToCart;
    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;



    public boolean inventoryListIsDisplayed(){
        return inventoryList.isDisplayed();
    }
    public int getItemsQuantity(){
        return inventoryItems.size();
    }

    public boolean allItemsAreDisplayed(){
        boolean displayed = true;
        for (WebElement item:inventoryItems) {
            if(!item.isDisplayed()){
                displayed = false;
            }
        }
        return displayed;
    }


    public boolean allItemNamesAreDisplayed(){
        boolean displayed = true;
        for (WebElement name:inventoryNames) {
            if(!name.isDisplayed()){
                displayed = false;
            }
        }
        return displayed;
        // 1. is displayed == true (for all items)
        // 2. not empty (for all items)
    }

    public boolean allNamesAreNotEmpty(){
        boolean notEmpty = true;
        for (WebElement name:inventoryNames) {
            if(name.getText().isEmpty()){
                notEmpty = false;
            }
        }
        return notEmpty;
    }

    public boolean allNamesStartWithSauceLabs(){
        boolean allContains = true;
       // int index = 1;
        for (WebElement name:inventoryNames) {
            if (!name.getText().startsWith("Sauce Labs")){
                allContains=false;
                System.out.println("Item with product number "+ (inventoryNames.indexOf(name)+1) +" does not start with Sauce Labs" );
            }
           // index++;
        }
        return allContains;
    }

    public void clickOnBurgerMenuBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenuBtn));
        burgerMenuBtn.click();
    }

    public void clickOnBackpackAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(backpackAddToCart));
        backpackAddToCart.click();
    }
    public void clickOnBikeLightAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(bikeLightAddToCart));
        bikeLightAddToCart.click();
    }

    public void clickOnTshirtAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(tShortAddToCart));
        tShortAddToCart.click();
    }

    public void clickOnCartItem(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartIcon.click();
    }

    public String getPriceOfFirstItem(){
        return inventoryPrices.get(0).getText();
    }
}

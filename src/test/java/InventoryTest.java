import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BaseTest{

    @Test
    public void itemElementsTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        // assert item quantity equals 6
        assertEquals(6, inventoryPage.getItemsQuantity());
        assertTrue(inventoryPage.allItemsAreDisplayed());
        assertTrue(inventoryPage.allItemNamesAreDisplayed());
        assertTrue(inventoryPage.allNamesAreNotEmpty());
        //all item names contains with "Sauce Labs"
        assertTrue("Not all names starts with Sauce Labs",inventoryPage.allNamesStartWithSauceLabs());
    }

}

import org.junit.Test;

import static org.junit.Assert.*;

public class CartTest extends BaseTest{

    @Test
    public void successAdding1Item(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        String backPackPriceFromInventory = inventoryPage.getPriceOfFirstItem();
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        assertEquals(1, cartPage.getItemsQuantity());
        //assert price from inventory == price from cart page
        assertEquals(backPackPriceFromInventory, cartPage.getPriceOfFirstAddedItem());
    }

    @Test
    public void successAdding3Item() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        //add 3 items to the cart
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnBikeLightAddToCart();
        inventoryPage.clickOnTshirtAddToCart();
        //assert that 3 items in the cart
        inventoryPage.clickOnCartItem();
        pause(1000);
        CartPage cartPage = new CartPage(driver);
        assertEquals(3, cartPage.getItemsQuantity());

        System.out.println("Моя сумма   " + cartPage.sumOfPriceInCart());
        cartPage.sumOfPriceInCart2(); // или ошибка выскочит если закоментировать replace $
    }

    //check cart is empty

    @Test
    public void emptyCart(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.cartIsEmpty());
    }
    @Test
    public void testSumOfItemsPriceInCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnBikeLightAddToCart();
        inventoryPage.clickOnTshirtAddToCart();
        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);

        System.out.println("Моя сумма   " + cartPage.sumOfPriceInCart());
        cartPage.sumOfPriceInCart2(); // или ошибка выскочит если закоментировать replace $
    }

}

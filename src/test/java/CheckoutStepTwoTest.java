import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutStepTwoTest extends BaseTest{






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
        cartPage.clickOnCheckoutButton();

        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterValueToFirstName("John");
        checkoutStepOnePage.enterValueToLastName("Black");
        checkoutStepOnePage.enterValueToZip("12345");
        checkoutStepOnePage.clickOnContinueButton();

        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        System.out.println("Моя сумма StepTwo  " + checkoutStepTwoPage.sumOfPriceInStepTwo());
        checkoutStepTwoPage.sumOfPriceInStepTwo1();

        System.out.println("Моя сумма Cart  " + cartPage.sumOfPriceInCart());

        assert cartPage.sumOfPriceInCart() == checkoutStepTwoPage.sumOfPriceInStepTwo(): "Сумма продуктов на странице корзины не равна сумме продуктов на странице оплаты.";

            if (cartPage.sumOfPriceInCart2() == checkoutStepTwoPage.sumOfPriceInStepTwo1()) {
                System.out.println("Сумма продуктов на странице корзины равна сумме продуктов на странице оплаты.");
            } else {
                System.out.println("Сумма продуктов на странице корзины НЕ равна сумме продуктов на странице оплаты.");
            }

    }
}

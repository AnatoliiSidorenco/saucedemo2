import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutStepTwoPage extends BasePage {

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemPricesStepTwo;

    public void clickOnFinishButton() {
        finishButton.click();
    }

    public double sumOfPriceInStepTwo() {
        double totalPrice = 0.0;

        for (WebElement priceElement : itemPricesStepTwo) {
            String priceText = priceElement.getText();
            priceText = priceText.replace("$", "");
            double price = Double.parseDouble(priceText);
            totalPrice += price;
        }

        return totalPrice;
    }

    public double sumOfPriceInStepTwo1() {

        double totalPrice = 0.0;

        // Итерация по найденным элементам и суммирование цен
        for (WebElement priceElement : itemPricesStepTwo) {
            String priceText = priceElement.getText();
            // Удаление символа доллара из строки цены
            priceText = priceText.replace("$", "");
            try {
                double price = Double.parseDouble(priceText);
                totalPrice += price;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка формата числа: " + priceText);
                // Обработка ошибки формата числа, если не удалось преобразовать строку в число
            }
        }

        return totalPrice;
    }

    public void sumIsEqual(Double a, Double b) {
        if (a == b) {
            System.out.println("Сумма продуктов на странице корзины равна сумме продуктов на странице оплаты.");
        } else {
            System.out.println("Сумма продуктов на странице корзины НЕ равна сумме продуктов на странице оплаты.");
        }
    }


}

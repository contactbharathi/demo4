package grpid4.pages;

import grpid4.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BasketPage  extends DriverManager {

    @FindBy(css = ".xs-8--none")
    private WebElement addToTrolleyBtn;

    @FindBy(css = ".button--full.xs-hidden.sm-block")
    private WebElement goToTrolleyBtn;


    @FindBy(css = ".ProductCard__titleLink__1PgaZ")
    private List<WebElement> productNameFromBasket;

    @FindBy(css = ".ProductCard__removeButton__2O6Cw")
    private WebElement removebtn;

    @FindBy(css = ".co_marginright_12")
    private WebElement removedlabel;

    public void addbasket(){

        addToTrolleyBtn.click();
        goToTrolleyBtn.click();

    }//addbasket


    public String productInBasketCheck(){

        System.out.println("the basket sizeis==>"+ productNameFromBasket.size());
        System.out.println("the actual is ==>"+ productNameFromBasket.get(1).getText());
        return productNameFromBasket.get(1).getText();
    }

    public void removeProduct(){
        removebtn.click();
        System.out.println("Removed label==>"+removedlabel.getText());
    }

    public String getRemovedMsgText(){

        return removedlabel.getText();
    }
}

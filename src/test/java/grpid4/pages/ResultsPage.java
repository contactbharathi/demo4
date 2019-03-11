package grpid4.pages;

import grpid4.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.openqa.selenium.By.cssSelector;

public class ResultsPage extends DriverManager {
    @FindBy(css = ".search-title__term")
    private WebElement headerText;

    @FindBy(css = ".ac-product-card__name")
    private List<WebElement> productNames;

    @FindBy(css = ".ac-product-price__amount")
    private List<WebElement> pricesOnProducts;


    public static String selectedProduct;

    public String getProductHeader() {
        return headerText.getText();
    }

    public void selectAnyProduct() {
        int totalProducts = productNames.size();


        Random random = new Random();
        int randomNumber = random.nextInt(totalProducts);


        WebElement selectedWebElement = productNames.get(randomNumber);
        selectedProduct = selectedWebElement.getText();
        System.out.println("The  random number is =>" + randomNumber);
        System.out.println("Selected Product Name  is =>" + selectedWebElement.getText());
        selectedWebElement.click();

    }

    /*********************************************************************************************

     Review option is clicked based on the string passed as argument to selectReview method
     ********************************************************************************************/

    public void filterByOption(String reviewString) {

        List<WebElement> ratings = driver.findElements(cssSelector(".filter-panel__inner *>li>label"));
        for (WebElement rating : ratings) {
            String ratingInString = rating.getText();
            System.out.println("The texts of all filterByOptions =>" + ratingInString);

            if (ratingInString.matches(reviewString)) {
                waitUntilClickable(rating).click();
               // rating.click();
                break;
            }//if

        }//for

    }//selectReview Method  Ends


    public List<Double> getAllRatings() {
        List<Double> actualRatingList = new ArrayList<>();

        sleep(4000);
        List<WebElement> ratings = driver.findElements(By.cssSelector(".ac-star-rating"));


        for (WebElement rating : ratings) {
            String ratingInString = rating.getAttribute("data-star-rating");
            double ratingInDouble = Double.parseDouble(ratingInString);
            System.out.println("The  ratings =>" + ratingInDouble);
            actualRatingList.add(ratingInDouble);
        }

        return actualRatingList;

    }//getAllRatings()


    public List<Double> getAllProductsPrices() {
        List<Double> collectedPriceList = new ArrayList<>();

        for (WebElement filterWebelement : pricesOnProducts) {
            double indiPrice = Double.parseDouble(filterWebelement.getText().replace("Â£", ""));
            collectedPriceList.add(indiPrice);
        }
        return collectedPriceList;
    }
    public List<String> getAllProductNames() {
        List<String> collectedPriceList = new ArrayList<>();


     //   waitUntilElementInvisible(By.cssSelector(".icon--loading"));
        for (WebElement filterWebelement : productNames) {

            String productName =  filterWebelement.getAttribute("data-product-name");

            collectedPriceList.add(productName);
        }
        return collectedPriceList;
    }

    /*******************************************************************************************

     SortBy option is clicked based on the option passed as an argument

     /**********************************With FindElements****************************************/
    public void   sortByOptionClick(String sortByString) {
        List<WebElement> ratings = driver.findElements(cssSelector(".sort-select>option"));
       sleep(4000);


        for (WebElement rating : ratings) {
            String ratingInString = rating.getText();
            System.out.println("sort by options"+ ratingInString);


            if (ratingInString.contains(sortByString)) {
                //waitUntilClickable(rating).click();
                rating.click();
                break;
            }//if
        }//for loop


    //    waitUntilElementInvisible(By.cssSelector(".icon--loading"));

    }//sortByOptionClick method ends

    public List<Double> collectingPricesList() {
        sleep(4000);
       // applyImpWait();
        //Selection all the Product Price displayed based on filter applied

        /*************Until Loading  Webelement Invisible**************************************************

         waitForInviOfELement("");    //need to get the locator from Developer bcozit is quickly disappear


         public Boolean waitForInviOfELement(String element){
         return ( new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOfElementLocated
         (By.cssSelector(element))));            }
         ****************************************************************************************************/

        List<WebElement> rateList = driver.findElements(cssSelector(".ac-product-price__amount"));
        List<Double> priceList = new ArrayList<Double>();//Empty Array list to have the Product Names

        /****Converting Price in String Data type  to  Double Data type*******************************/

        for (WebElement rating : rateList) {
            String priceInString = rating.getText();
            Double value = Double.parseDouble(priceInString.substring(1));
            priceList.add(value);//adding the values to the array for reference and for size
            System.out.println("Price before click size" + value);
        }
        return (priceList);

    }//collectingByPriceList method ends

    /*********************************************************************************************

     //sortByPrice --Sort the collected price  List  and compare with the price List before sorting

     //*********************************************************************************************/


    public List<Double> sortingTheList(List priceList){

        List<Double> tempPriceList = new ArrayList<Double>();//Empty Array list to have the Product Names
        tempPriceList.addAll(priceList);//copy from  priceList to another list called Temp to sort

         Collections.sort(tempPriceList);//tempPriceList sorted
        return tempPriceList;

    }//sortBy

}





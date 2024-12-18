package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import pages.CoinDeskAPIPage;
import pojoCoinDeskAPI.GetCoinDeskDetails;
import util.ConfigLoader;

public class CoinDeskAPISteps {

    private CoinDeskAPIPage coinDeskAPIPage;
    private Response response;
    GetCoinDeskDetails getCoinDeskDetails;

    @Given("the CoinDesk API is available")
    public void theCoinDeskAPIIsAvailable() {
        String baseUri = ConfigLoader.getProperty("baseGetUri");
        coinDeskAPIPage = new CoinDeskAPIPage(baseUri);
    }

    @When("I fetch the current Bitcoin price")
    public void iFetchTheCurrentBitcoinPrice() {
        response = coinDeskAPIPage.getCurrentBitcoinPrice();
    }

    @Then("the API should return status code {int}")
    public void theAPIShouldReturnStatusCode(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }

    @Then("the response should include a valid time updated field")
    public void theResponseShouldIncludeAValidTimeUpdatedField() {
        //Method to directly get the parameter from json object using json path
//        String updatedTime = response.jsonPath().getString("time.updated");
//        Assert.assertNotNull(updatedTime, "Updated time is missing in response");

        //Method to get the parameter details from pojo classes
        getCoinDeskDetails = response.as(GetCoinDeskDetails.class);
        System.out.println(getCoinDeskDetails.getTime().getUpdated());
        Assert.assertNotNull(getCoinDeskDetails.getTime().getUpdated(), "Updated time is missing in response");
    }

    @Then("the response should include valid chart name")
    public void theResponseShouldIncludeValidChartName(){
        getCoinDeskDetails = response.as(GetCoinDeskDetails.class);
        System.out.println(getCoinDeskDetails.getChartName());
        Assert.assertTrue(getCoinDeskDetails.getChartName().equalsIgnoreCase("Bitcoin"));
    }

    @Then("verify USD details")
    public void verifyUSDDetails(){
        getCoinDeskDetails = response.as(GetCoinDeskDetails.class);
        System.out.println(getCoinDeskDetails.getBpi().get("USD").getRate());
        System.out.println(getCoinDeskDetails.getBpi().get("USD").getCode());
        System.out.println(getCoinDeskDetails.getBpi().get("USD").getSymbol());
        System.out.println(getCoinDeskDetails.getBpi().get("USD").getDescription());
    }

    @Then("verify GBP details")
    public void verifyGBPDetails(){
        getCoinDeskDetails = response.as(GetCoinDeskDetails.class);
        System.out.println(getCoinDeskDetails.getBpi().get("GBP").getRate());
        System.out.println(getCoinDeskDetails.getBpi().get("GBP").getCode());
        System.out.println(getCoinDeskDetails.getBpi().get("GBP").getSymbol());
        System.out.println(getCoinDeskDetails.getBpi().get("GBP").getDescription());
    }

    @Then("verify EUR details")
    public void verifyEURDetails(){
        getCoinDeskDetails = response.as(GetCoinDeskDetails.class);
        System.out.println(getCoinDeskDetails.getBpi().get("EUR").getRate());
        System.out.println(getCoinDeskDetails.getBpi().get("EUR").getCode());
        System.out.println(getCoinDeskDetails.getBpi().get("EUR").getSymbol());
        System.out.println(getCoinDeskDetails.getBpi().get("EUR").getDescription());
    }

}

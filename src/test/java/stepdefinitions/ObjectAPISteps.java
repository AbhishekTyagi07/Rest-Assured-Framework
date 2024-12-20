package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.testng.Assert;
import pages.ObjectAPIPage;
import util.ConfigLoader;

import java.io.IOException;

public class ObjectAPISteps {

    private ObjectAPIPage objectPage;
    private Response response;
    public static String objectID;

    @Given("object api is available")
    public void object_api_is_available() {
        objectPage = new ObjectAPIPage();
    }
    @When("user adds the object in the list {string} {int} {double} {string} {string}")
    public void user_adds_the_object_in_the_list(String name, Integer year, Double price, String model, String disk) throws IOException {
        response = objectPage.addObject(name,year,price,model,disk);
    }
    @Then("object gets added and status code displayed as {int}")
    public void object_gets_added_and_status_code_displayed_as(Integer postStatusCode) {
        Assert.assertEquals(response.statusCode(), postStatusCode);
    }
    @Then("object id gets created")
    public void object_id_gets_created() {
        objectID = response.jsonPath().getString("id");
        Assert.assertNotNull(objectID,"Object id is not generated");
    }
    @Then("response should display createdAt time")
    public void response_should_display_created_at_time() {
        String createdTime = response.jsonPath().getString("createdAt");
        Assert.assertNotNull(createdTime,"Created time is not showing in the response");
    }
    @When("user check the object added in the list")
    public void user_check_the_object_added_in_the_list() throws IOException {
        response = objectPage.getObject(objectID);
    }
    @Then("added object should be displayed with status code as {int}")
    public void added_object_should_be_displayed_with_status_code_as(Integer getStatusCode) {
        Assert.assertEquals(response.statusCode(), getStatusCode);
    }
    @Then("id should match when user added the object")
    public void id_should_match_when_user_added_the_object() {
        String addedObjectID = response.jsonPath().getString("id");
        Assert.assertEquals(addedObjectID,objectID);
    }
    @When("user update the object details {string} {int} {double} {string} {string} {string}")
    public void user_update_the_object_details(String name, Integer year, Double price, String model, String disk, String color) throws IOException {
        response = objectPage.updateObject(objectID,name,year,price,model,disk,color);
    }
    @Then("object gets updated with status code as {int}")
    public void object_gets_updated_with_status_code_as(Integer updatedStatusCode) {
        Assert.assertEquals(response.statusCode(), updatedStatusCode);
    }
    @Then("response should display updatedAt time")
    public void response_should_display_updated_at_time() {
        String updatedObjectID = response.jsonPath().getString("id");
        Assert.assertEquals(updatedObjectID,objectID);
        String updatedTime = response.jsonPath().getString("updatedAt");
        Assert.assertNotNull(updatedTime,"Updated time is not showing in the response");
    }
    @When("user delete the existing object")
    public void user_delete_the_existing_object() throws IOException {
        response = objectPage.deleteObject(objectID);
    }
    @Then("object gets deleted with status code as {int}")
    public void object_gets_deleted_with_status_code_as(Integer deletedStatusCode) {
        Assert.assertEquals(response.statusCode(), deletedStatusCode);
    }
    @Then("response message should contain deleted content")
    public void response_message_should_contain_deleted_content() {
        String responseMessage = response.jsonPath().getString("message");
        Assert.assertTrue(responseMessage.contains("deleted"));
    }

}

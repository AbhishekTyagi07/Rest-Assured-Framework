package stepdefinitions;

import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {

    @Before("@WithoutAddObject")
    public void beforeScenario() throws IOException {

        if(ObjectAPISteps.objectID==null){
            ObjectAPISteps steps = new ObjectAPISteps();
            steps.object_api_is_available();
            steps.user_adds_the_object_in_the_list("Apple MacBook Pro 16", 2019, 1849.99, "Intel Core i9", "1 TB");
            steps.object_id_gets_created();
        }
    }
}

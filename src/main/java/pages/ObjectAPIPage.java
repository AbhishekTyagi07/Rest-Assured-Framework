package pages;

import io.restassured.response.Response;
import payloadBuilder.AddProductPayload;
import payloadBuilder.UpdateProductPayload;
import util.Common;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ObjectAPIPage extends Common {

    public ObjectAPIPage() {}

    public Response addObject(String name, Integer year, Double price, String model, String disk) throws IOException {
        return given()
                .spec(requestSpecification())
                .body(AddProductPayload.addProductPayload(name,year,price,model,disk))
                .when()
                .post()
                .then()
                .extract()
                .response();
    }

    public Response getObject(String id) throws IOException {
        return given()
                .spec(requestSpecification())
                .pathParam("objectID",id)
                .when()
                .get("/{objectID}")
                .then()
                .extract()
                .response();
    }

    public Response updateObject(String id, String name, Integer year, Double price, String model, String disk, String color) throws IOException {
        return given()
                .spec(requestSpecification())
                .pathParam("objectID",id)
                .body(UpdateProductPayload.updateProductPayload(name,year,price,model,disk,color))
                .when()
                .put("/{objectID}")
                .then()
                .extract()
                .response();
    }

    public Response deleteObject(String id) throws IOException {
        return given()
                .spec(requestSpecification())
                .pathParam("objectID",id)
                .when()
                .delete("/{objectID}")
                .then()
                .extract()
                .response();
    }

}

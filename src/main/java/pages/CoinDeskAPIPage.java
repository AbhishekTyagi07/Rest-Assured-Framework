package pages;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class CoinDeskAPIPage {

    private final String baseUri;

    public CoinDeskAPIPage(String baseUri) {
        this.baseUri = baseUri;
    }

    public Response getCurrentBitcoinPrice() {
        return given()
                .baseUri(baseUri)
                .when()
                .get()
                .then()
                .extract()
                .response();
    }

}

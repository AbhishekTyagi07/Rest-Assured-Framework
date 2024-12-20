package util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.*;
import io.restassured.specification.*;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Common {

    public static RequestSpecification req;
    String baseUri = ConfigLoader.getProperty("objectBaseUri");
    public RequestSpecification requestSpecification() throws IOException {

        if(req==null){
            PrintStream log = new PrintStream(Files.newOutputStream(Paths.get("Logger.txt")));
            req = new RequestSpecBuilder().setBaseUri(baseUri)
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON).build();
            return req;
        }
        return req;
    }
}

package dzr.hanom.Specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static dzr.hanom.helpers.CustomApiListener.allureWithCustomTemplates;
import static io.restassured.RestAssured.with;



public class Specs {

    public static RequestSpecification requestSpecification = with()
            .filter(allureWithCustomTemplates())
            .baseUri("https://reqres.in")
            .basePath("api/")
            .log().all()
            .contentType(ContentType.JSON);

}
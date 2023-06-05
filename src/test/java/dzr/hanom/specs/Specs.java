package dzr.hanom.specs;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

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

// Не создавал спецификации для ответа, т.к. по сути для этих тестов туда можно включить только логирование.
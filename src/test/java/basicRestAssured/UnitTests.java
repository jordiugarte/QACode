package basicRestAssured;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UnitTests {
    @Test
    public void verify_get_project() {
        given().
                auth().
                preemptive().
                basic("upb2021@upb.com", "12345").
                log().
                all().
                when().
                get("http://todo.ly/api/projects.json").
                then().
                log().
                all();
    }
}

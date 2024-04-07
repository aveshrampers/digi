package utility;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.List;

public class ReusableMethods extends BaseApi {
    static Response response;
    static JsonPath jsonPath;

    public static void baseRequest(String path) {
        RequestSpecification requestSpecification = RestAssured.given();
        response = requestSpecification.log().all().contentType("application/json").when().get(base_url + base_path + path);
        jsonPath = response.jsonPath();
    }

    public static void castAssertion(Integer sequel, String filmCrew, String pathValue, String listValue) throws AssertionError {
        List<Integer> value = jsonPath.getList(listValue);
        for (Integer s : value) {
            if (!s.equals(sequel)) {
                continue;
            }
            baseRequest("/" + s);
            JsonPath jsonPath1 = response.jsonPath();
            String direct = jsonPath1.get(pathValue);
            switch (sequel) {
                case 3:
                    Assert.assertEquals(direct, filmCrew);
                    break;
                case 5:
                    Assert.assertNotEquals(direct, filmCrew);
                    break;
                default:
                    Assert.fail("Assertion combination Film crew value " + filmCrew.toUpperCase() + " and sequel value " + sequel + " does not match.");
            }
        }
    }

    public static void countAssert(String pathValue, Integer count) {
        Integer value = jsonPath.getInt(pathValue);
        Assert.assertEquals(count, value);
    }
}
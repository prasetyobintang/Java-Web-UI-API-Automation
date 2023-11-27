package pages;

import helper.Endpoint;
import helper.Utility;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;

import java.io.File;
import java.util.List;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.*;

public class ApiPage {

    private static Response res;

    String setURL, global_user_id = null;

    public String setupURL(String url) {
        switch (url) {
            case "USER_REST":
                setURL = Endpoint.USER_REST;
                break;
            default:
                System.out.println("input right url");
        }
        return setURL;
    }

    public void hitGetListUser() {
        res = getListUsers(setURL);
    }

    public void validationStatusCode(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");
    }

    public void validationJSONSChema(String filename) {
        File JSONFile = Utility.getJSONSchemaFile(filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }
}


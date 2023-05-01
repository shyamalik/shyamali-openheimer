package com.openheimer.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import com.openheimer.api.models.CreateEmployeeModel;
import org.json.simple.JSONArray;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
public class EmployeeListTest {
    RequestSpecification requestSpecification;

    JSONArray jsonArray = new JSONArray();

    @BeforeSuite
    public void beforeSuite() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri("http://localhost:8080");
        requestSpecification = requestSpecBuilder.build();
    }

    @Test
    public void insertEmployeeListValidTest(){
        CreateEmployeeModel employeeOne = new CreateEmployeeModel("Mihiri","345-4511234","F",
                "14051989","20","150000");
        employeeOne.setRequestModel();
        jsonArray.add( employeeOne.getRequestModel());

        CreateEmployeeModel employeeTwo = new CreateEmployeeModel("Thilini","456-4511234","F",
                "14051999","10","174000");
        employeeTwo.setRequestModel();
        jsonArray.add( employeeTwo.getRequestModel());

        ValidatableResponse response = given()
                .spec(requestSpecification)
                .body(jsonArray.toString().toString()).log().all()
                .post("calculator/insertMultiple")
                .then().log().all(); //response log
        Assert.assertEquals(response.extract().statusCode(), 202);
    }

    @Test(dependsOnMethods = "insertEmployeeListValidTest")
    public void getTaxReliefTest(){
        ValidatableResponse response = given()
                .spec(requestSpecification)
                .get("calculator/taxRelief")
                .then().log().all();
        //Assert.assertEquals();
    }
}

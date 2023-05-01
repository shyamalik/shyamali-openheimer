package com.openheimer.api;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import com.openheimer.api.models.CreateEmployeeModel;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Random;

import static io.restassured.RestAssured.given;

public class EmployeeTest {

    RequestSpecification requestSpecification;

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
    public void insertEmployeeValidTest() {
//        JSONObject jsonObject = new JSONObject();
        Random random = new Random();
        Faker faker = new Faker();
        String natid = "005-" + String.format("%07d", random.nextInt(10000000));
        String name = faker.name();
        String gender = "F";
        String salary = "10";
        String tax = "5";
        String birthday = "22011999";

        CreateEmployeeModel createEmployeeModel = new CreateEmployeeModel(name,natid,gender,birthday,tax,salary);
        createEmployeeModel.setRequestModel();
        ValidatableResponse response = given()
                .spec(requestSpecification)
                .body(createEmployeeModel.getRequestModel().toString()).log().all()
                .post("calculator/insert")
                .then().log().all(); //response log
        Assert.assertEquals(response.extract().statusCode(), 202);
        Assert.assertEquals(response.extract().asString(), "Alright");
    }

    @Test
    public void insertEmployeeInvalidTest() {
//        JSONObject jsonObject = new JSONObject();
        Random random = new Random();
        Faker faker = new Faker();
        String natid = "005-" + String.format("%07d", random.nextInt(10000000));
        String name = faker.name();
        String gender = "F";
        String salary = "10";
        String tax = "5";
        String birthday = "22-01-1999";

        CreateEmployeeModel createEmployeeModel = new CreateEmployeeModel(name, natid, gender, birthday, tax, salary);
        createEmployeeModel.setRequestModel();
        ValidatableResponse response = given()
                .spec(requestSpecification)
                .body(createEmployeeModel.getRequestModel().toString()).log().all()
                .post("calculator/insert")
                .then().log().all();
        Assert.assertEquals(response.extract().body().jsonPath().get("error"),"Internal Server Error");
    }
}




















 /* @BeforeSuite
    public void beforeSuite(){
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri("http://localhost:8080/calculator/insert");
        requestSpecification = requestSpecBuilder.build();
        CreateEmployeeModel createEmployeeModel = new CreateEmployeeModel("Shyama","010-4561230",
                "22011996", "200", "2500", "25000");
        CreateEmployeeModel.setRequestModel();
        ValidatableResponse response = given()
                .spec(requestSpecification)
                .body(createEmployeeModel.getRequestModel().toString().log().all()
                        .post()

    }*/



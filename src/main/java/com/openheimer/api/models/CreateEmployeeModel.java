package com.openheimer.api.models;

import org.json.simple.JSONObject;

public class CreateEmployeeModel {
    private JSONObject jsonObject;
    String name, natid, gender, birthday, salary, tax;
    public CreateEmployeeModel(String name, String natid, String gender, String birthday, String tax, String salary){
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.natid = natid;
        this.salary = salary;
        this.tax = tax;
    }

    public void setRequestModel(){

        jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("gender", gender);
        jsonObject.put("birthday",birthday);
        jsonObject.put("natid", natid);
        jsonObject.put("salary", salary);
        jsonObject.put("tax", tax);
    }

    public JSONObject getRequestModel(){
        return jsonObject;}
}

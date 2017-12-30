package com.api.testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;
public class basics1get {

	@Test
	public  void main() {
		// TODO Auto-generated method stub
               
		RestAssured.baseURI="https://maps.googleapis.com";
		given().
		param("location","-33.8670522,151.1957362").
		param("radius","500").
		param("type","restaurant").
		param("keyword","cruise").
		param("key","AIzaSyCwN3vJabTZUHI9hqoBSju1QjJXNwIHpdo").
		when().
		get("/maps/api/place/nearbysearch/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("results[0].name",equalTo("Sydney Showboats")).and().
		body("results[0].place_id", equalTo("ChIJjRuIiTiuEmsRCHhYnrWiSok")).
		header("server","pablo");
	}

}

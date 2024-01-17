package api.endpoints;

//UserEndpoints.java 
//Created to perform Create, Read, Update, Delete requests to the User API 

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndPoints {

	//implementaion createuser method
	public static Response createUser(User payload){     //goto swagger api post request create user and try it out and execute it -H 'accept: application/json' \
		                                                                                                    //-H 'Content-Type: application/json' \
		                                                                                                 //above 2 we need to pass in given()
		Response response =given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.base_url);        //accessing baseurl from routes class
		return response;
	}
	//implementaion readuser method
	 public static Response readUser(String userName){     //in routes class for get url request username is parameterized and hence we need to use hear
		 
		 Response response =given()
		 .pathParam("username", userName)
		 .when()
		 .get(Routes.get_url);
		 return response;
	 }
	//implementaion updateuser method
        public static Response updateUser(String userName,User payload){   //for update we need 2 parameters 
		 
		 Response response =given()
		 .contentType(ContentType.JSON)
	     .accept(ContentType.JSON)
		 .body(payload)
		 .pathParam("username", userName)
		 .when()
		 .put(Routes.update_url);
		 return response;
	 }
      //implementaion deleteuser method
   	 public static Response deleteUser(String userName){     
   		 
   		 Response response =given()
   		 .pathParam("username", userName)
   		 .when()
   		 .delete(Routes.delete_url);
   		 return response;
   	 }
	
}

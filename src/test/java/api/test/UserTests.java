package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	@BeforeClass
	public void setUpData() {
		
		faker = new Faker();  //create fake data and pass it into userpayload 
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
	}
	
	//now we need to pass data into post request by creating tc
	@Test(priority=1)
	public void testPostUser()
	{
		Response response=UserEndPoints.createUser(userPayload);   //from userendpoints class we are calling createuser method and pass the above payload and return the response  
		response.then().log().all();   //store the response and log the response
		
		Assert.assertEquals(response.getStatusCode(),200);	
	}
	
	@Test(priority=2)
	public void testGetUserByName()
	{
		//logger.info("********** Reading User Info ***************");
		
		Response response=UserEndPoints.readUser(this.userPayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		//logger.info("**********User info  is displayed ***************");
	}
	@Test(priority=3)
	public void testUpdateUserByName()
	{
		//logger.info("********** Updating User ***************");
		
		//update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response=UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
		response.then().log().body();
				
		Assert.assertEquals(response.getStatusCode(),200);
		
		//logger.info("********** User updated ***************");
		//Checking data after update
		Response responseAfterupdate=UserEndPoints.readUser(this.userPayload.getUsername());
		Assert.assertEquals(responseAfterupdate.getStatusCode(),200);
			
	}
	
	@Test(priority=4)
	public void testDeleteUserByName()
	{
		//logger.info("**********   Deleting User  ***************");
		
		Response response=UserEndPoints.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(response.getStatusCode(),200);
		
		//logger.info("********** User deleted ***************");
	}
}

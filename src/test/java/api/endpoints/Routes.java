package api.endpoints;

/* 
Swagger URI --> https://petstore.swagger.io    // base URL 

Create user(Post) : https://petstore.swagger.io/v2/user
Get user (Get): https://petstore.swagger.io/v2/user/{username}      //baseurl+endpoint(user/{username})
Update user (Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}

*/

public class Routes {

	public static String base_url="https://petstore.swagger.io/v2" ;    //base url we re making static and public so that we can access it from anywhere
	 
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";     //{username} is pathparameter
    public static String update_url=base_url+"/user/{username}";
    public static String delete_url=base_url+"/user/{username}";
     
    
    //Store Model
    	//Here you can add Store url's
    
    
    //Pet Model
    	//Here you can add Pet url's
	 
}

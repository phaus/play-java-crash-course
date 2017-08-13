package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.HeaderNames.LOCATION;
import static play.mvc.Http.Status.BAD_REQUEST;
import static play.mvc.Http.Status.OK;
import static play.mvc.Http.Status.SEE_OTHER;
import static play.test.Helpers.GET;
import static play.test.Helpers.POST;
import static play.test.Helpers.contentAsString;
import static play.test.Helpers.route;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import play.Application;
import play.Logger;
import play.api.test.CSRFTokenHelper;
import play.inject.guice.GuiceApplicationBuilder;
import play.mvc.Http;
import play.mvc.Result;
import play.test.WithApplication;

public class UsersTest extends WithApplication {
	
    @Override
    protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
    }

    @Test
    public void testIndex() {
        Http.RequestBuilder request = new Http.RequestBuilder()
                .method(GET)
                .uri("/users");

        Result result = route(app, request);
        assertEquals(OK, result.status());
        assertTrue(contentAsString(result).contains("Email"));
    }
    
    @Test
    public void testCreate() {
    	
    		Map<String, String> data = new HashMap<>();
    		data.put("name", "testuser 1");
    		data.put("email", "testuser1@example.com");
        Http.RequestBuilder request =  CSRFTokenHelper.addCSRFToken(new Http.RequestBuilder())
                .method(POST)
                .bodyForm(data)
                .uri("/users");   
        Result result = route(app, request);
        assertEquals(SEE_OTHER, result.status());
        String locationHeader = result.headers().get(LOCATION);
        assertTrue(locationHeader.contains("/users"));
        Logger.info("locationHeader: {}", locationHeader);
        Http.RequestBuilder anotherRequest = new Http.RequestBuilder()
                .method(GET)
                .uri(locationHeader);
        Result anotherResult = route(app, anotherRequest);
        assertEquals(OK, anotherResult.status());        
    }
    
    @Test
    public void testFailedCreate() {
		Map<String, String> data = new HashMap<>();
		data.put("name", "testuser 1");
	    Http.RequestBuilder request = CSRFTokenHelper.addCSRFToken(new Http.RequestBuilder())
	            .method(POST)
	            .bodyForm(data)
	            .uri("/users");   
	    Result result = route(app, request);
	    assertEquals(BAD_REQUEST, result.status());  
        assertTrue(contentAsString(result).contains("Create User"));
    }
}

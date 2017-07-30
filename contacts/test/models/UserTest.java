package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.ebean.Ebean;
import play.Application;
import play.Logger;
import play.inject.guice.GuiceApplicationBuilder;
import play.test.WithApplication;

public class UserTest extends WithApplication {

	@Override
	protected Application provideApplication() {
        return new GuiceApplicationBuilder().build();
	}

	@Test
	public void testUser() {
		final String email = "foo@example.com";
		User user = new User();
		user.email = email;
		user.password = "secret";
		user.save();
		User savedUser = Ebean.find(User.class).where().eq("email", email).findUnique();
		assertEquals(savedUser.email, email);
		Logger.info("saveUser id: {}", savedUser.id);
		assertTrue(savedUser.id != null);
	}
}

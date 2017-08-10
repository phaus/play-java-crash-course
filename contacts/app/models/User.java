package models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.ebean.Finder;
import io.ebean.Model;
import play.Logger;
import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;


@Entity
public class User extends Model {

    public static Finder<UUID, User> find = new Finder<>(User.class);
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;
    
	@Required
	@Email
	public String email;
	@Required
	public String name;
	public String password;
	
	public void setEmail(final String email) {
		this.email = email;
		Logger.info("setting email to {}", email);
	}
	
	public String getEmail() {
		Logger.info("getting email {}", email);
		return email;
	}	
}

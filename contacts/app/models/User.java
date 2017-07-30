package models;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.ebean.Model;
import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;


@Entity
public class User extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID id;
    
	@Required
	@Email
	public String email;
	@Required
	public String name;
	public String password;
	
}

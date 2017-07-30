package models;

import javax.persistence.Entity;

import io.ebean.Model;

@Entity
public class User extends Model {

	public String email;
	public String password;
	
}

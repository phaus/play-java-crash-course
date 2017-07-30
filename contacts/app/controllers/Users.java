package controllers;

import java.util.UUID;

import javax.inject.Inject;

import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

public class Users extends Controller {

	private final Form<User> userForm;
	
	@Inject
	public Users(FormFactory formFactory) {
		this.userForm = formFactory.form(User.class);
	}
	
	public Result create() {
		return ok();
	}

	public Result save() {
		return ok();
	}
	
	public Result show(final UUID id) {
		return ok();
	}
	
}

package controllers;

import java.util.List;
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
	
	public Result index() {
		final List<User> users = User.find.query().order("name ASC").findList();
		return ok(views.html.Users.index.render(users));
	}
	
	public Result create() {
		return ok(views.html.Users.create.render(userForm));
	}

	public Result save() {
		final Form<User> filledUserForm = userForm.bindFromRequest();
		if (filledUserForm.hasErrors()) {
			flash("alert", "User could not be saved.");
			return badRequest(views.html.Users.create.render(filledUserForm));
		}	
		final User user = filledUserForm.get();
		user.save();
        flash("notice", "User was successfully saved.");
		return redirect(routes.Users.index());
	}
	
	public Result show(final UUID id) {
		User user = User.find.byId(id);
		return ok(views.html.Users.show.render(user));
	}
	
}

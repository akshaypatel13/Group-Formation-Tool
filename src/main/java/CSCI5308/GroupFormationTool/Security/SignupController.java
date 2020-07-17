package CSCI5308.GroupFormationTool.Security;

import java.util.ArrayList;
import java.util.List;

import CSCI5308.GroupFormationTool.PasswordValidation.PasswordValidationAbstractFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import CSCI5308.GroupFormationTool.AccessControl.*;
import CSCI5308.GroupFormationTool.PasswordValidation.IPasswordValidatorEnumerator;
import CSCI5308.GroupFormationTool.PasswordValidation.IPasswordValidatorPersistence;

@Controller
public class SignupController {

	private final String USERNAME = "username";
	private final String PASSWORD = "password";
	private final String PASSWORD_CONFIRMATION = "passwordConfirmation";
	private final String FIRST_NAME = "firstName";
	private final String LAST_NAME = "lastName";
	private final String EMAIL = "email";
	private static final Logger LOG = LogManager.getLogger();
	private IPasswordValidatorEnumerator passwordValidatorEnumerator;
	private IUser userInstance;

	@GetMapping("/signup")
	public String displaySignup(Model model) {
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView processSignup(@RequestParam(name = USERNAME) String bannerID,
			@RequestParam(name = PASSWORD) String password,
			@RequestParam(name = PASSWORD_CONFIRMATION) String passwordConfirm,
			@RequestParam(name = FIRST_NAME) String firstName, @RequestParam(name = LAST_NAME) String lastName,
			@RequestParam(name = EMAIL) String email) {

		IPasswordValidatorPersistence validatorDB = PasswordValidationAbstractFactory.instance()
				.createPasswordValidatorDBInstance();
		passwordValidatorEnumerator = PasswordValidationAbstractFactory.instance()
				.createPasswordEnumerator(validatorDB);
		PasswordValidationAbstractFactory.instance().setPasswordEnumeratorInstance(passwordValidatorEnumerator);
		userInstance = UserAbstractFactory.instance().createUserInstance();
		boolean success = false;
		List<String> errorMessages = new ArrayList<String>();
		if (userInstance.isBannerIDValid(bannerID) && userInstance.isEmailValid(email)
				&& userInstance.isFirstNameValid(firstName) && userInstance.isLastNameValid(lastName)
				&& password.equals(passwordConfirm)) {
			LOG.info("User data validated for registration");
			IUser u = UserAbstractFactory.instance().createUserInstance();
			u.setBannerID(bannerID);
			u.setPassword(password);
			u.setFirstName(firstName);
			u.setLastName(lastName);
			u.setEmail(email);
			IUserPersistence userDB = UserAbstractFactory.instance().createUserDBInstance();
			IPasswordEncryption passwordEncryption = SecurityAbstractFactory.instance()
					.createBCryptPasswordEncryption();
			passwordValidatorEnumerator = PasswordValidationAbstractFactory.instance().getPasswordValidatorEnumerator();

			success = u.createUser(userDB, passwordValidatorEnumerator, passwordEncryption, null, errorMessages);
			LOG.info("User Registerd in DB successfully for userId =" + u.getID());
		}
		ModelAndView m = new ModelAndView("login");
		if (success == false) {
			LOG.error("Invalid data, user registration failed");
			m = new ModelAndView("signup");
			m.addObject("errorMessage", "Invalid data, please check your values.");
			m.addObject("passwordInvalid", errorMessages);
		}
		return m;
	}
}
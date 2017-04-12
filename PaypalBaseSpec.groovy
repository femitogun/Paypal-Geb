package specs

import geb.spock.GebReportingSpec
import pages.HomePage
import pages.LoginMainPage
import pages.SelectAccountPage
import pages.BusinessAccountPage
import pages.PersonalAccountPage


abstract class PaypalBaseSpec extends GebReportingSpec {

	def login(loginValues) {
		to HomePage
		logIn.click()
		
		at LoginMainPage
		if (loginValues.email) {
			email = loginValues.email
		}
		if (loginValues.password) {
			password = loginValues.password
		}
		if (loginValues.loginButton) {
			loginButton.click()
		} else {
			if (loginValues.reset) {
				forgotten.click()
				//Do reset password stuff
			}
			if (loginValues.signup) {
				signUp.click()
				//Do signup stuff
			}
		}
	}
	
	def signup(signupValues) {
		to HomePage
		signUp.click()
		
		at SelectAccountPage
		if (signupValues.business) {
			business.click()
			next.click()
			at BusinessAccountPage
		} else {
			next.click()
			at PersonalAccountPage
			if (signupValues.email) {
				email = signupValues.email
			}
			if (signupValues.password) {
				password = signupValues.password
			}
			if (signupValues.confirmPassword) {
				confirmPassword = signupValues.confirmPassword
			}
			next.click()
		}
	}
}

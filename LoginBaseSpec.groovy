package specs

import geb.spock.GebReportingSpec
import pages.HomePage
import pages.LoginMainPage


abstract class LoginBaseSpec extends GebReportingSpec {
	
//	def loginValues
//	
//	def setup() {
//		loginValues = [
//		email:'fttest@test.com', password:'FTAutoTest1!', loginButton:true, reset:false, signup:false
//		]
//	}
	
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
}

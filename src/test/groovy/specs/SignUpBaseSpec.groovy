package specs

import geb.spock.GebReportingSpec
import pages.HomePage
import pages.SelectAccountPage
import pages.BusinessAccountPage
import pages.PersonalAccountPage

abstract class SignUpBaseSpec extends GebReportingSpec {
	
	def signupValues
	
	def setup() {
		signupValues = [
			personal:true, business:false, email:'adtest@test.com', password:'ADAutoTest1!', confirmPassword:'ADAutoTest1!'
		]
	}
	
	def signup() {
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

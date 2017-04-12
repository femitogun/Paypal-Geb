package specs

import pages.HomePage
import pages.LoginMainPage
import pages.SelectAccountPage
import pages.BusinessAccountPage
import pages.PersonalAccountPage
import spock.lang.Unroll
import spock.lang.IgnoreRest
import spock.lang.Ignore

@Unroll
class LoginSpec extends PaypalBaseSpec {
	
	def loginValues
	def signupValues
	
	def setup() {
		loginValues = [
		email:'fttest@test.com', password:'FTAutoTest1!', loginButton:true, reset:false, signup:false
		]
		
		signupValues = [
			personal:true, business:false, email:'adtest@test.com', password:'ADAutoTest1!', confirmPassword:'ADAutoTest1!'
		]
	}

	def "1 - Enter Email and Password"() {
		
		given:'A user has opted to login'
			loginValues.email
			loginValues.password 
			to HomePage
		
		when:'The user enters username and password'
			login(loginValues)
		
		then:'An appropriate error message is displayed'
			waitFor { notificationError.isDisplayed() 
			notificationError.text() == "Some of your info isn't correct. Please try again." }
	}
	
	def "2 - Invalid Email"() {
		
		given:'A user has opted to login'
			loginValues.email = ''
			loginValues.password 
			to HomePage
		
		when:'The user enters a blank email address and clicks login'
			login(loginValues)
		
		then:'An appropriate error message is displayed'
			waitFor {emailError.isDisplayed()
			emailError.text() == 'Required'}

	}

	def "3 - Invalid Password"() {
		
		given:'A user has opted to login'
			loginValues.email 
			loginValues.password = ''
			to HomePage
		
		when:'The user enters an email address of invalid format and clicks next'
			login(loginValues)
		
		then:'An appropriate error message is displayed'
			waitFor {passwordError.isDisplayed()
			passwordError.text() == 'Required'}
	}
	@Ignore
	def "4 - Click on sigup button"() {
		
		given:'A user has opted to login'
			loginValues.email
			loginValues.password = ''
			to HomePage
		
		when:'The user chooses to use the sign up option'
			login(loginValues)
		
		then:'User gives invalid signup details'
			waitFor {passwordError.isDisplayed()
			passwordError.text() == 'Required'}
	}
}

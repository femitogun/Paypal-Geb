package specs

import pages.HomePage
import pages.PersonalAccountPage
import spock.lang.Unroll
import spock.lang.IgnoreRest

class SignUpSpec extends PaypalBaseSpec {
	
	def signupValues
	
	def setup() {
		signupValues = [
			personal:true, business:false, email:'adtest@test.com', password:'ADAutoTest1!', confirmPassword:'ADAutoTest1!'
		]
	}
	
	def "1 - Blank Email"() {
		
		given:'A user has opted to signup and has selected to create a Personal Account'
			signupValues.email = ''
			to HomePage
		
		when:'The user leaves the email field blank and clicks next'
			signup(signupValues)
			at PersonalAccountPage
			email.click()
		
		then:'An appropriate error message is displayed'
			blankEmailError.isDisplayed()
			blankEmailError.text() == 'Required.'
	}
	
	@Unroll
	def "2 - Invalid Email"() {
		
		given:'A user has opted to signup and has selected to create a Personal Account'
			signupValues.email = emailAddress
			to HomePage
		
		when:'The user enters an email address of invalid format and clicks next'
			signup(signupValues)
			at PersonalAccountPage
			email.click()
		
		then:'An appropriate error message is displayed'
			invalidEmailError.isDisplayed()
			invalidEmailError.text() == 'Make sure your email address is correct.'
		
		where:
			emailAddress << ['fdgdsgfd', "test'test.com"]
	}
	
	@Unroll
	def "3 - Password Insufficent Length"() {
		
		given:'A user has opted to signup and has selected to create a Personal Account'
			signupValues.password = 'ADTest1'
			signupValues.confirmPassword = 'ADTest1'
			to HomePage
		
		when:'The user enters an email address of invalid format and clicks next'
			signup(signupValues)
			at PersonalAccountPage
			password.click()
		
		then:'An appropriate error message is displayed'
			passowrdError.isDisplayed()
			passowrdError.text() == '8 characters or longer.'
	}
}

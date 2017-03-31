package pages

import geb.Page

class PersonalAccountPage extends Page {
	
	static url = 'signup/account'
	
	static at = { browser.driver.currentUrl.endsWith(url) }

	static content = {
		email { $(id:'email') }
		password { $(id:'password') }
		confirmPassword { $(id:'confirmPassword') }
		
		//Error messages
		blankEmailError { $(id:'emailEmpty') }
		invalidEmailError { $(id:'emailFormat') }
		passowrdError { $('#passwordValidations li', 0) }
		
		next { $('[data-click="accountSubmit"]') }
	}
}

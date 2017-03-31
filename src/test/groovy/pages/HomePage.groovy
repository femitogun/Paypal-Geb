package pages

import geb.Page

class HomePage extends Page {
	
	static url = 'https://www.sandbox.paypal.com/'
	
	static at = { browser.driver.currentUrl == url }

	static content = {
		signUp { $('#signup-button') }
	}
}

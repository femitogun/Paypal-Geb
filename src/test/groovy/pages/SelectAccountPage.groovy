package pages

import geb.Page

class SelectAccountPage extends Page {
	
	static url = 'account-selection'
	
	static at = { browser.driver.currentUrl.endsWith(url) }

	static content = {
		business { $(id:'radio-business') }
		
		next { $('[href*="signup/account"]') }
	}
}

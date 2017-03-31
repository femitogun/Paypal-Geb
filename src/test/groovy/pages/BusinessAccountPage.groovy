package pages

import geb.Page

class BusinessAccountPage extends Page {
	
	static url = 'product-selection'
	
	static at = { browser.driver.currentUrl.endsWith(url) }

	static content = {
		
	}
}

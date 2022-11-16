package com.kms
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.windows.keyword.builtin.ClickElementOffsetKeyword

import internal.GlobalVariable
import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import java.lang.Integer


class LeavePage {

	/**
	 * verifyMyLeave
	 */
	@Keyword
	static int verifyMyLeave(String leaveInfo) {
		//[CAN - Bereavement, 2022-11-14 to 2022-11-15, Take PTO, 12.00, 2.0, Pending Approval (2.0)]
		String[] lstLeaveInfo = leaveInfo.split(',')
		println(lstLeaveInfo.toArrayString())
		List<WebElement> lst = WebUiBuiltInKeywords.findWebElements(findTestObject('Main/tblFilteredRows'), GlobalVariable.G_Timeout)
		String strStatus = ''
		String strDate = ''
		String strLeaveType = ''
		String strComment = ''
		String strLeaveBalance = ''
		String strNumDay = ''

		int intRowNumber = 0

//		println(lst.size())
		for (int i = 1; i <= lst.size(); i++) {
			strStatus = WebUiBuiltInKeywords.getText(findTestObject('Main/tblFilteredCell', [('rowNumber') : i, ('cellNumber') : 7]))
			println(strStatus)
			println(lstLeaveInfo[5].toString())
			if(strStatus == lstLeaveInfo[5].toString()) {
				strDate = WebUiBuiltInKeywords.getText(findTestObject('Main/tblFilteredCell', [('rowNumber') : i, ('cellNumber') : 2]))
				println(strDate)
				println(lstLeaveInfo[1].toString())
				if(strDate == lstLeaveInfo[1].toString()) {
					strLeaveType = WebUiBuiltInKeywords.getText(findTestObject('Main/tblFilteredCell', [('rowNumber') : i, ('cellNumber') : 4]))
					println(strLeaveType)
					println(lstLeaveInfo[0].toString())
					if(strLeaveType == lstLeaveInfo[0].toString()) {
						strComment = WebUiBuiltInKeywords.getText(findTestObject('Main/tblFilteredCell', [('rowNumber') : i, ('cellNumber') : 8]))
						println(strComment)
						println(lstLeaveInfo[2].toString())
						if(strComment == lstLeaveInfo[2].toString()) {
							strLeaveBalance = WebUiBuiltInKeywords.getText(findTestObject('Main/tblFilteredCell', [('rowNumber') : i, ('cellNumber') : 5]))
							println(strLeaveBalance)
							println(lstLeaveInfo[3].toString())
							if(strLeaveBalance == lstLeaveInfo[3].toString()) {
								strNumDay = WebUiBuiltInKeywords.getText(findTestObject('Main/tblFilteredCell', [('rowNumber') : i, ('cellNumber') : 6]))
								println(strNumDay)
								println(lstLeaveInfo[4].toString())
								if(strNumDay == lstLeaveInfo[4].toString()) {
									intRowNumber = i
								}
							}
						}
					}
				}
			}
		}
		return intRowNumber
	}

	/**
	 * Refresh browser
	 */
	@Keyword
	static boolean deletePendingLeave(int intRowNumber, String strMessage) {
		boolean isDeleted = false
		if(intRowNumber>0) {
			println(intRowNumber)
			clickElement(findTestObject('Main/tblFilteredCell', [('rowNumber') : intRowNumber, ('cellNumber') : 9]))
			if(WebUiBuiltInKeywords.verifyElementText(findTestObject('Leave/lblToastMessage'), strMessage)) {
				isDeleted = true
			}
		}
		return isDeleted
	}


	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	static clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}
}
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

import com.kms.MainPage
import com.kms.LeavePage

'TEST DATA'
def pageName = 'Leave'
def pageTitle = 'Leave List'
def isActionPage = true
def autoExpand = false
def fieldName = 'Leave Type'
def fieldValue = 'CAN - Bereavement'
def isCurrentDate = true
def nextAddDays = 0
def resultMessage = 'Successfully Saved'
String leaveInfo = ''
def remainDaysBefore = 0
def pendingLeaveRow = 0

'TEST STEPS'
'Step 1 - Open browser and login in OrangeHRM page'
MainPage.loginPageSuccessful()

'Step 2 - Go to Leave page'
MainPage.accessPageSuccessful(pageName, pageTitle)

'Step 3 - Go to Apply'
pageName = 'Apply'
pageTitle = 'Apply Leave'
MainPage.accessSubPageSuccessful(pageName, pageTitle, isActionPage)

'Step 4 - Select value for Leave Type'
MainPage.selectFromDropdownSuccessful(fieldName, fieldValue, autoExpand)
leaveInfo += fieldValue + ','

fieldName = 'Leave Balance'
remainDaysBefore = MainPage.getElementText(findTestObject('Leave/lbl_Value', [('fieldName') : fieldName]))

'Step 5 - Select from date'
fromDate = MainPage.setDate(findTestObject('Leave/dtpFromDateField'), isCurrentDate, nextAddDays)

'Step 6 - Select to date'
isCurrentDate = false
nextAddDays = 1
toDate = MainPage.setDate(findTestObject('Leave/dtpToDateField'), isCurrentDate, nextAddDays)
if(fromDate == toDate) {
	leaveInfo += toDate.toString() + ','
}else {
	leaveInfo += fromDate.toString() + ' to ' + toDate.toString() + ','
}

'Step 7 - Input comment'
fieldName = 'Comments'
fieldValue = 'Take PTO'
MainPage.inputTextSuccessful(findTestObject('Main/txaFieldName', [('labelName') : fieldName]), fieldValue)
leaveInfo += fieldValue + ','

'Step 8 - Select value for Partial Days'
fieldName = 'Partial Days'
fieldValue = 'All Days'
MainPage.selectFromDropdownSuccessful(fieldName, fieldValue, autoExpand)

'Step 9 - Select value for Duration'
fieldName = 'Duration'
fieldValue = 'Specify Time'
MainPage.selectFromDropdownSuccessful(fieldName, fieldValue, autoExpand)
	
'Step 9 - Click Apply button'
MainPage.clickElement(findTestObject('Main/btnSubmit'))
	
'Step 10 - Verify apply message'
WebUI.verifyElementText(findTestObject('Leave/lblToastMessage'), resultMessage)

'Step 11 - Verify amount of Leave Balance'
fieldName = 'Leave Type'
fieldValue = 'CAN - Bereavement'
MainPage.selectFromDropdownSuccessful(fieldName, fieldValue, autoExpand)

fieldName = 'Leave Balance'
remainDaysAfter = MainPage.getElementText(findTestObject('Leave/lbl_Value', [('fieldName') : fieldName]))
leaveInfo += remainDaysAfter.substring(0, 5).toString() + ','

numberOfDayLeave = remainDaysBefore.substring(0, 5).toDouble() - remainDaysAfter.substring(0, 5).toDouble()
if(numberOfDayLeave > 0 ) {
	println("Amount of 'Leave Balance' is reduced by ${numberOfDayLeave}")
}else {
	println("Amount of 'Leave Balance' is not reduced by ${numberOfDayLeave}")
}
numberOfDayLeave = String.format("%.2f", numberOfDayLeave)
leaveInfo += numberOfDayLeave.toString() + ','
leaveInfo += "Pending Approval (${numberOfDayLeave})" + ','
println(leaveInfo)


'Step 12 - Verify new created Pending Leave'
pageName = 'My Leave'
pageTitle = 'My Leave List'
isActionPage = false
MainPage.accessSubPageSuccessful(pageName, pageTitle, isActionPage)

isCurrentDate = true
nextAddDays = 0
MainPage.setDate(findTestObject('Leave/dtpFromDateField'), isCurrentDate, nextAddDays)

isCurrentDate = false
nextAddDays = 1
MainPage.setDate(findTestObject('Leave/dtpToDateField'), isCurrentDate, nextAddDays)

fieldName = 'Leave Type'
fieldValue = 'CAN - Bereavement'
MainPage.selectFromDropdownSuccessful(fieldName, fieldValue, autoExpand)

MainPage.clickElement(findTestObject('Main/btnSubmit'))

'Step 13 - Cancel new created pending leave'
pendingLeaveRow = LeavePage.verifyMyLeave(leaveInfo.toString())
if(pendingLeaveRow > 0) {
	println('The leave status Pending Approval')
	resultMessage = 'Successfully Updated'
	if(LeavePage.deletePendingLeave(pendingLeaveRow, resultMessage)) {
		println('Cancel Pending leave success')
	}else {
		println('Cannot cancel Pending leave success')
	}
}else {
	println('The leave status is not Pending Approval')
}

'Step 14 - Close the browser'
WebUI.closeBrowser()



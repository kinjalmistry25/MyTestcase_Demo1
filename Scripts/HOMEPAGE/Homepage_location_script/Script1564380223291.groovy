import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.ADD_URL)

WebUI.setText(findTestObject('search_element/search_keyword/input_What_select'), 'hotels')

WebUI.delay(5)

if (WebUI.getText(findTestObject('search_element/search_keyword/input_What_select')) == 'hotels') {
    WebUI.comment('blank result')
} else {
    WebUI.comment('result is not blank')
}

not_run: if (WebUI.verifyElementVisible(findTestObject('search_city_keyword/city_keyword/input_What_select')) == '" "') {
    WebUI.comment('search city')
}

not_run: if (WebUI.verifyElementVisible(findTestObject('search_element/search_keyword/input_What_select'))) {
    not_run: WebUI.comment('test case for search box is visible or not')

    not_run: WebUI.closeBrowser()

    not_run: WebUI.setText(findTestObject(null), 'hotels')
}

not_run: if (WebUI.getText(findTestObject('search_element/search_keyword/input_What_select')) == '" "') {
    not_run: WebUI.comment('test case for serch box is blank')
} else {
    not_run: WebUI.comment('box is filled.')
}


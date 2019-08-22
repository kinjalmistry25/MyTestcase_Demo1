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

for (def index : (0..(Emails.size()-1))) {
    WebUI.navigateToUrl('https://listify-demos.astoundify.com/rentals/')

    WebUI.click(findTestObject('Object Repository/Listyfy_login/Login_listyfy/a_Log In'))

    WebUI.setText(findTestObject('Object Repository/Listyfy_login/Login_listyfy/input__username'), Emails[index])

    WebUI.setText(findTestObject('Object Repository/Listyfy_login/Login_listyfy/input__password'), Password[index])

    WebUI.click(findTestObject('Listyfy_login/Login_listyfy/input__login'))

    WebUI.delay(2)

    if (WebUI.verifyElementVisible(findTestObject('SignUpValidate/strong_sumittemplatic'), FailureHandling.CONTINUE_ON_FAILURE)) {
        WebUI.comment('passed')
    } else {
        WebUI.comment('failed')

        WebUI.delay(2)
    }
}


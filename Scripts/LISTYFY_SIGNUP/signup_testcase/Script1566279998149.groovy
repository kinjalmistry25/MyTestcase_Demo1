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
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

for (def index : (0..Emails.size())) {
    WebUI.navigateToUrl('https://listify-demos.astoundify.com/rentals/')

    WebUI.click(findTestObject('Object Repository/Signup_listyfy/Page_Listify_signup/a_Sign Up'))

    WebUI.setText(findTestObject('Object Repository/Signup_listyfy/Page_Listify_signup/input_First Name_sr_firstname'), 
        Firstname)

    WebUI.setText(findTestObject('Object Repository/Signup_listyfy/Page_Listify_signup/input_Last Name_sr_lastname'), Lastname)

    WebUI.setText(findTestObject('Object Repository/Signup_listyfy/Page_Listify_signup/input__email'), Emails[index])

    WebUI.setText(findTestObject('Object Repository/Signup_listyfy/Page_Listify_signup/input__password'), Passwords[index])

    WebUI.click(findTestObject('Object Repository/Signup_listyfy/Page_Listify_signup/input_Anti-spam_register'))

    WebUI.delay(2)

    if (WebUI.verifyElementVisible(findTestObject('SignUpValidate/strong_sumittemplatic'), FailureHandling.CONTINUE_ON_FAILURE)) {
        WebUI.comment('PASSED')
    } else {
        WebUI.comment('FAILED')
    }
}


package com.hepsiburada.runtest;

import com.hepsiburada.utilities.Environments;
import com.hepsiburada.webpages.LoginPage;
import com.hepsiburada.webpages.SolutionCenter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class TestSuiteFirefox {

    public static final WebDriver driver = new FirefoxDriver();

    @BeforeTest (groups = {"SolutionCenterTest","runFirefoxTest"})
    public void setupFirefox() {
        driver.get(Environments.SolutionCenterURL);
        driver.manage().window().setSize(new Dimension(1920,1080));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().getPageLoadTimeout();
    }

    @Test (priority = 1, suiteName = "Hepsi BuradaTestSuite", testName = "I Have Questions About My Order Test", groups = {"SolutionCenterTest", "runFirefoxTest"})
    public static void productionPage() throws IOException {

        SolutionCenter solutionCenter = new SolutionCenter(driver);
        LoginPage loginPage = new LoginPage(driver);

        solutionCenter.clickIHaveQuestionsAboutMyOrderButton();
        loginPage.typeUserMail(Environments.usermail);
        loginPage.clickLoginButton();
        loginPage.typeUserPassword(Environments.userpassword);
        loginPage.clickEMailSelect();
        solutionCenter.assertSolutionCenterProductionsPage();
    }

    @Test (priority = 2, suiteName = "HepsiBuradaTestSuite", testName = "Select an Order and Reach Chat Page Test", groups = {"SolutionCenterTest", "runFirefoxTest"})

    public static void chatPage () throws IOException {
        SolutionCenter solutionCenter = new SolutionCenter(driver);

        solutionCenter.clickAnOrder();
        solutionCenter.assertSolutionCenterChatPage();

        solutionCenter.clickEndConversationButton();
        solutionCenter.clickCloseButton();
    }

    @Test (priority = 3, suiteName = "HepsiBuradaTestSuite", testName = "SSS Page Test", groups = {"SolutionCenterTest", "runFirefoxTest"})

    public static void sssPage () throws IOException {

        SolutionCenter solutionCenter = new SolutionCenter(driver);

        solutionCenter.clickIHaveADifferentQuestionButton();
        solutionCenter.assertSolutionCenterSSSPage();
    }

    @Test (priority = 4, suiteName = "HepsiBuradaTestSuite", testName = "Call Request to Inquire About an Order Test", groups = {"SolutionCenterTest", "runFirefoxTest"})
    public static void callRequest () throws IOException {
        SolutionCenter solutionCenter = new SolutionCenter(driver);

        driver.get(Environments.sssPageURL);

        solutionCenter.clickProductInformation();
        solutionCenter.clickIsTheProductOriginal();
        solutionCenter.clickCallMeButton();
        solutionCenter.clickCallMeSendButton();
        solutionCenter.assertCallRequest();
    }

    @AfterMethod //for Screenshot
    public void afterMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                String fileSuffix = new SimpleDateFormat("HHmmssddMMyyyy").format(new Date());
                FileUtils.copyFile(screenshotFile, new File(".//screenshot/firefox//" + result.getMethod().getMethodName() + " Test Failed_" +fileSuffix+ ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterSuite (groups = {"SolutionCenterTest", "runFirefoxTest"})
    public void cleanAllThemUp() {
        driver.manage().deleteAllCookies();
        driver.close();
    }
}

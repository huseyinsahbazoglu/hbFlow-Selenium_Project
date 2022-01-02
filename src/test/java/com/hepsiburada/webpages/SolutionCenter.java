package com.hepsiburada.webpages;

import com.hepsiburada.utilities.Environments;
import com.hepsiburada.utilities.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class SolutionCenter extends PageObject {
    @FindBy (xpath = "//div[@class='button-container']/div[1]")
    private WebElement iHaveQuestionsAboutMyOrderButton;

    @FindBy (xpath = "(//*[@class='detail-icon'])[3]")
    private WebElement SelectAnOrder;

    @FindBy (className = "link-button")
    private WebElement endConversationButton;

    @FindBy (className = "close-icon")
    private WebElement closeButton;

    @FindBy (xpath = "//div[@class='button-container']/div[2]")
    private WebElement iHaveADifferentQuestionButton;

    @FindBy (xpath="//*/text()[normalize-space(.)='Ürün bilgisi']/parent::*")
    private WebElement productInformation;

    @FindBy (xpath = "//*/text()[normalize-space(.)='Ürünler orijinal midir?']/parent::*")
    private WebElement isTheProductOriginal;

    @FindBy (xpath = "//*/text()[normalize-space(.)='Beni arayın']/parent::*")
    private WebElement callMeButton;

    @FindBy (xpath = "//*/text()[normalize-space(.)='Gönder']/parent::*")
    private WebElement callMeRequestSendButton;

    @FindBy (className = "main-text")
    private WebElement successfulDemand;


    public void clickIHaveQuestionsAboutMyOrderButton() {
        wait.until(ExpectedConditions.elementToBeClickable(iHaveQuestionsAboutMyOrderButton));
        this.iHaveQuestionsAboutMyOrderButton.click();
    }

    public void assertSolutionCenterProductionsPage() {
        wait.until(ExpectedConditions.urlToBe(Environments.productsPageURL));
        Assert.assertEquals(driver.getCurrentUrl(), Environments.productsPageURL);
    }

    public void clickAnOrder() {
        this.SelectAnOrder.click();
    }

    public void assertSolutionCenterChatPage() {
        wait.until(ExpectedConditions.urlToBe(Environments.chatPageURL));
        Assert.assertEquals(driver.getCurrentUrl(), Environments.chatPageURL);
    }

    public void clickEndConversationButton() {
        wait.until(ExpectedConditions.elementToBeClickable(endConversationButton));
        this.endConversationButton.click();
    }

    public void clickCloseButton() {
        wait.until(ExpectedConditions.elementToBeClickable(closeButton));
        this.closeButton.click();
    }

    public void clickIHaveADifferentQuestionButton() {
        wait.until(ExpectedConditions.elementToBeClickable(iHaveADifferentQuestionButton));
        this.iHaveADifferentQuestionButton.click();
    }

    public void assertSolutionCenterSSSPage() {
        wait.until(ExpectedConditions.urlToBe(Environments.sssPageURL));
        Assert.assertEquals(driver.getCurrentUrl(), Environments.sssPageURL);
    }

    public void clickProductInformation () {
        wait.until(ExpectedConditions.elementToBeClickable(productInformation));
        this.productInformation.click();
    }

    public void clickIsTheProductOriginal() {
        this.isTheProductOriginal.click();
    }

    public void clickCallMeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(callMeButton));
        this.callMeButton.click();
    }

    public void clickCallMeSendButton() {
        wait.until(ExpectedConditions.elementToBeClickable(callMeRequestSendButton));
        this.callMeRequestSendButton.click();
    }

    public void assertCallRequest(){
        wait.until(ExpectedConditions.visibilityOf(successfulDemand));
        Assert.assertEquals(successfulDemand.getText(),"Talebiniz oluşturuldu");
    }

    public SolutionCenter(WebDriver driver){ super(driver); }
}

package net.seamlessly.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarPage extends BasePage{


    @FindBy(xpath = "(//div[@class='action-item'])[1]")
    public WebElement threeDotIcon;

    @FindBy(xpath = "//span[@class='action-button__icon icon-view-day']")
    public WebElement dayButton;

    @FindBy(xpath = "//span[@class='action-button__icon icon-view-week']")
    public WebElement weekButton;

    @FindBy(xpath = "//span[@class='action-button__icon icon-view-module']")
    public WebElement monthButton;

    @FindBy(xpath = "//button[@class='button primary new-event']")
    public WebElement newEventButton;

    @FindBy(xpath = "//div[@class='datepicker-button-section']")
    public WebElement datePickerButton;

    @FindBy(xpath = "//label[@for='allDay']")
    public WebElement allDay;

    @FindBy(xpath = "//input[@placeholder='Event title']")
    public WebElement eventName;

    @FindBy(xpath = "//div[@class='datepicker-button-section']")
    public WebElement datePickButton;

    @FindBy(xpath = "(//input[@name='date'])[2]" )
    public WebElement startDateBox;

    @FindBy(xpath = "//td[@data-day=10]")
    public WebElement startDatePick;

    @FindBy(xpath = "(//ul//li[@data-index='3'])[1]")
    public WebElement startHour;

    @FindBy(xpath = "(//li[@data-index='10'])[2]")
    public WebElement startMinute;

    @FindBy(xpath = "(//li[@data-index='0'])[3]")
    public WebElement AMorPm;

    @FindBy(className = "illustration-header")
    public WebElement emptyPlace;

    @FindBy(xpath = "//div[@class='mx-datepicker'][2]")
    public WebElement endDateBox;

    @FindBy(xpath = "//td[@data-day='11']")
    public WebElement endDatePick;

    @FindBy(xpath = "(//li[@data-index='11'])[1]")
    public WebElement endHour;

    @FindBy(xpath = "(//li[@data-index='10'])[2]")
    public WebElement endMinute;

    @FindBy(xpath = "(//li[@data-index='1'])[3]")
    public WebElement PmorAm;

    @FindBy(xpath = "//button[@class='primary']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='fc-event-title fc-sticky']")
    public WebElement verifyEvent;

    @FindBy(xpath = "//div[@class='fc-event-main']")
    public WebElement findEventButton;

    @FindBy(xpath = "//div[@class='event-popover__buttons']/button[1]")
    public WebElement moreButton;

    @FindBy(xpath = "//div[@class='action-item app-sidebar-header__menu']")
    public WebElement actionButton;

    @FindBy(xpath = "//span[@class='action-button__icon icon-delete']")
    public WebElement deleteButton;

}







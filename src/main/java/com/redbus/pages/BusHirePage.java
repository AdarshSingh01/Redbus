package com.redbus.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.redbus.helperutils.HelperClass;


public class BusHirePage{
	public WebDriver driver;

	public BusHirePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Element and Flow for searching buses in search page
	@FindBy(how = How.XPATH,using="//*[@id=\"redBus Bus Hire\"]")
    public WebElement BusHire;
	
	@FindBy(how = How.ID, using = "redBus Bus Hire")
	private WebElement busHireLink;

	@FindBy(how = How.XPATH, using = "//object")
	private WebElement frameWindow;

	// outstation Menu Elements
	@FindBy(how = How.XPATH, using = "//*[text() = 'Outstation']")
	private WebElement outStationMenu;

	// click to change the type of trip
	@FindBy(how = How.XPATH, using = "//*[@class='slider round']")
	private WebElement sliderRound;

	@FindBy(how = How.ID, using = "locationTextFieldLocal")
	private WebElement pickUpInput;

	@FindBy(how = How.ID, using = "local_dest_name")
	private WebElement destinationInput;

	@FindBy(how = How.XPATH, using = "//*[@id='from_datepicker']/div/div/input")
	private WebElement fromDateAndTimeForOutstation;

	@FindBy(how = How.XPATH, using = "//*[@id='to_datepicker']/div/div/input")
	private WebElement toDateAndTimeForOutstation;

	//*[@id="OSLeadGen_DoJStart"]
	@FindBy(how = How.XPATH, using = "//*[text() = 'OK']")
	private WebElement dateAndTimeOkButton;

	@FindBy(how = How.ID, using = "numberOfPax")
	private WebElement numberOfPassengerField;

	@FindBy(how = How.XPATH, using = "//*[@id = 'proceedButtonOutstation']")
	private WebElement proceedButtonOnOutstation;

	// local Menu Elements
	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div[3]/div[2]/div[1]")
	private WebElement localMenu;

	@FindBy(how = How.XPATH, using = "//*[@id='locationTextFieldLocal']")
	private WebElement pickUpLocationOnLocalMenu;

	@FindBy(how = How.XPATH, using = "//input[@type = 'radio' and @value = '4']")
	private WebElement selectPackage;

	@FindBy(how = How.XPATH, using = "//*[@class = 'MuiInputBase-input MuiInput-input']")
	private WebElement dateAndTimeOnLocalMenu;

	@FindBy(how = How.ID, using = "numberOfPax")
	private WebElement numberOfPassengersOnLocalMenu;

	@FindBy(how = How.ID, using = "proceedButtonLocal")
	private WebElement proceedButtonLocal;

	// airport Menu Elements
	@FindBy(how = How.XPATH, using = "//*[text() = 'Airport']")
	private WebElement airPortMenu;

	@FindBy(how = How.XPATH, using = "//*[@class='select-selected']")
	private WebElement citySelect;

	@FindBy(how = How.ID, using = "locationTextFieldLocal")
	private WebElement destLocationFieldOnAirportMenu;

	@FindBy(how = How.XPATH, using = "//*[@id = 'ui-id-1']/li")
	private WebElement searchLocationResult;

	@FindBy(how = How.XPATH, using = "//*[@id='from_datepicker']/div/div/input")
	private WebElement fromDateAndTimeOnAirportMenu;

	@FindBy(how = How.ID, using = "numberOfPax")
	private WebElement numberOfPassengersOnAirportMenu;

	@FindBy(how = How.ID, using = "proceedButtonAirport")
	private WebElement proceedButtonOnAirportMenu;

	// Flow For Outstation

	public void clickOnOutstationMenu() {

		driver.switchTo().frame(frameWindow);
		outStationMenu.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clickOnSliderButton() {

		sliderRound.click();
	}

	public void enterPickUpLocation(String pickUpLocation) {

		pickUpInput.sendKeys(pickUpLocation);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pickUpInput.sendKeys(Keys.DOWN);
		pickUpInput.sendKeys(Keys.UP);
		pickUpInput.sendKeys(Keys.RETURN);
	}

	public void enterDropLocation(String dropLocation) {

		destinationInput.sendKeys(dropLocation);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		destinationInput.sendKeys(Keys.DOWN);
		destinationInput.sendKeys(Keys.UP);
		destinationInput.sendKeys(Keys.ENTER);
	}

	public void enterDateAndTimeForOutstation(String fromDateAndTimeVal , String tillDateAndTimeVal) {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		fromDateAndTimeForOutstation.click();

		// selecting date and time
		try {
			HelperClass.selectDateAndTimeAtBusHirePage(driver, fromDateAndTimeVal);
		} catch (Exception e) {

			e.printStackTrace();
		}
		toDateAndTimeForOutstation.click();
		// selecting date and time
		try {
			HelperClass.selectDateAndTimeAtBusHirePage(driver, tillDateAndTimeVal);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void enterNumberOfPassengers(String numberOfPassenger) {

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		numberOfPassengerField.clear();
		numberOfPassengerField.sendKeys(numberOfPassenger);
	}

	public void clickOnProceedButtonOnOutstationMenu() {

		Actions actionHH =  new Actions(driver);
		actionHH.moveToElement(proceedButtonOnOutstation).click().perform();
		proceedButtonOnOutstation.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Flow For Airport
	public void clickOnAirportMenu() {
		
		driver.switchTo().frame(frameWindow);
		airPortMenu.click();
	}
	
	

	// Flow For Local
	public void clickOnLocalMenu() {
		
		driver.switchTo().frame(frameWindow);
		localMenu.click();
		try {
			Thread.sleep(1555);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickOnBusHireLink() {
		busHireLink.click();
		try {
			Thread.sleep(1555);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}


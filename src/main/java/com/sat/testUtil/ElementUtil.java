package com.sat.testUtil;

import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import com.google.gson.Gson;

import com.sat.Pages.commonActionsPage;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import com.sat.exception.FrameworkException;

public class ElementUtil {
    private WebDriver driver;
    protected Properties prop;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
    }

    public By getBy(String locatorType, String locatorValue) {
        By by = null;

        switch (locatorType.toLowerCase().trim()) {
            case "id":
                by = By.id(locatorValue);
                break;
            case "name":
                by = By.name(locatorValue);
                break;
            case "class":
                by = By.className(locatorValue);
                break;
            case "xpath":
                by = By.xpath(locatorValue);
                break;
            case "css":
                by = By.cssSelector(locatorValue);
                break;
            case "linktext":
                by = By.linkText(locatorValue);
                break;
            case "partiallinktext":
                by = By.partialLinkText(locatorValue);
                break;
            case "tag":
                by = By.tagName(locatorValue);
                break;

            default:
                System.out.println("wrong locator type is passed..." + locatorType);
                throw new FrameworkException("WRONG LOCATOR TYPE");
        }

        return by;

    }

    // locatorType = "id", locatorValue = "input-email", value = "tom@gmail.com"
    public void doSendKeys(String locatorType, String locatorValue, String value) {
        getElement(locatorType, locatorValue).sendKeys(value);
    }

    public void doSendKeys(By locator, String value) {
        getElement(locator).sendKeys(value);
    }

    public void doSendKeysLog(By locator, String value, String printConsoleVal) {
        waitForVisibilityOfElement(locator, 30);
        try {
            getElement(locator).sendKeys(value);
            Log.info(printConsoleVal + " " + value);
        } catch (Exception e) {
            Log.error("Error sending keys to element");
        }
    }

    public void doClick(By locator) {
        getElement(locator).click();
    }

    public void doClickLog(By locator, String printConsoleVal) {
        try {
            getElement(locator).click();
            Log.info(printConsoleVal);
        } catch (Exception e) {
            Log.error("Error while clicking on element");
        }

    }

    public void doClick(String locatorType, String locatorValue) {
        getElement(locatorType, locatorValue).click();
    }

    public String doElementGetText(By locator) {
        return getElement(locator).getText();
    }

    public String doElementGetTextLog(By locator, String printConsoleVal) {
        Log.info(printConsoleVal + "" + getElement(locator).getText());
        return getElement(locator).getText();
    }

    public String doElementGetText(String locatorType, String locatorValue) {
        return getElement(locatorType, locatorValue).getText();
    }

    /**
     * To Validate element is displayed on the screen
     *
     * @param locator
     * @param elementName
     * @return
     */
    public boolean elementIsDisplayed(By locator, String elementName) throws InterruptedException {
        Thread.sleep(3000);
        try {
            WebElement element = getElement(locator);
            staleElementRefExecClickCRM(locator);
            if (element.isDisplayed()) {
                Log.info(elementName + " is Displayed");
                return true;
            }
        } catch (NoSuchElementException e) {
            Log.error(elementName + " is not Displayed " + e.getMessage());
        }
        return false;
    }

    /**
     * Return boolean value for element's visibility on the screen
     *
     * @param locator
     * @param time
     * @return
     */
    public boolean isElementPresent(By locator, int time) throws InterruptedException {
        Thread.sleep(1000); // Reduced sleep time
        try {
            waitTillPresenceElement(locator, time); // Corrected method name
            WebElement element = getElement(locator);
            staleElementRefExecClickCRM(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            Log.info("Element not found: " + e.getMessage());
            return false;
        }
    }

    /**
     * Verify the text of given attribute, e.g value
     *
     * @param locator
     * @param attribute
     */
    public String doGetElementAttribute(By locator, String attribute) {
        waitTillElementIsDisplayed(locator, 40);
        String attributeValue = null;
        try {
            WebElement element = getElement(locator);
            if (element.isDisplayed()) {
                attributeValue = element.getAttribute(attribute);
                Log.info("Attribute '" + attribute + "' value: " + attributeValue);
            } else {
                Log.error("Element not found for locator: " + locator);
            }
        } catch (Exception e) {
            Log.error("An error occurred while getting attribute '" + attribute + "' from element: " + e.getMessage());
        }
        return attributeValue;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public String doGetElementAttributeLog(By locator, String attrName, String printConsoleVal) {
        Log.info(printConsoleVal + "" + getElement(locator).getAttribute(attrName));
        return getElement(locator).getAttribute(attrName);
    }

    public WebElement getElement(String locatorType, String locatorValue) {
        return driver.findElement(getBy(locatorType, locatorValue));
    }

    // WAF : capture the text of all the page links and return List<String>.
    public List<String> getElementsTextList(By locator) {
        List<WebElement> eleList = getElements(locator);
        List<String> eleTextList = new ArrayList<String>();// pc=0 {}
        for (WebElement e : eleList) {
            String text = e.getText();
            if (text.length() != 0) {
                eleTextList.add(text);
            }
        }
        System.out.println(eleTextList);
        return eleTextList;
    }

    // WAF: capture specific attribute from the list:
    public List<String> getElementsAttributeList(By locator, String attrName) {
        List<WebElement> eleList = getElements(locator);

        List<String> eleAttrList = new ArrayList<String>();// pc=0 {}

        for (WebElement e : eleList) {
            String attrValue = e.getAttribute(attrName);
            eleAttrList.add(attrValue);
        }

        return eleAttrList;

    }

    public int getElementsCount(By locator) {
        return getElements(locator).size();
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public boolean checkSingleElementPresent(By locator) {
        return driver.findElements(locator).size() == 1 ? true : false;
    }

    public boolean checkElementPresent(By locator) {
        return driver.findElements(locator).size() >= 1 ? true : false;
    }

    public boolean checkElementPresent(By locator, int totalElements) {
        return driver.findElements(locator).size() == totalElements ? true : false;
    }

    public void Search(By searchField, By suggestions, String searchKey, String suggName) throws InterruptedException {
        doSendKeys(searchField, searchKey);
        Thread.sleep(3000);
        List<WebElement> suggList = getElements(suggestions);

        System.out.println(suggList.size());

        for (WebElement e : suggList) {
            String text = e.getText();
            System.out.println(text);
            if (text.contains(suggName)) {
                e.click();
                break;
            }
        }
    }

    public void clickOnElement(By locator, String eleText) {
        List<WebElement> eleList = getElements(locator);
        System.out.println(eleList.size());
        for (WebElement e : eleList) {
            String text = e.getText();
            System.out.println(text);
            if (text.contains(eleText)) {
                e.click();
                break;
            }
        }
    }

    // ***************Select drop Down Utils***************//

    public Select createSelect(By locator) {
        Select select = new Select(getElement(locator));
        return select;
    }

    public Select createSelectLog(By locator, String printConsoleVal) {
        Select select = new Select(getElement(locator));
        Log.info(printConsoleVal);
        return select;
    }

    public void doSelectDropDownByIndex(By locator, int index) {
        createSelect(locator).selectByIndex(index);
    }

    public void doSelectDropDownByVisibleTextLog(By locator, String visibleText, String printConsoleVal) {
        createSelect(locator).selectByVisibleText(visibleText);
        Log.info(printConsoleVal + " " + visibleText);
    }

    public void doSelectDropDownByVisibleText(By locator, String visibleText) {
        createSelect(locator).selectByVisibleText(visibleText);
    }

    public void doSelectDropDownByValue(By locator, String value) {
        createSelect(locator).selectByValue(value);
    }

    public int getDropDownOptionsCount(By locator) {
        return createSelect(locator).getOptions().size();
    }

    public List<String> getDropDownOptions(By locator) {
        List<WebElement> optionsList = createSelect(locator).getOptions();

        List<String> optionsTextList = new ArrayList<String>();

        for (WebElement e : optionsList) {
            String text = e.getText();
            optionsTextList.add(text);
        }

        return optionsTextList;
    }

    public void selectDropDownOption(By locator, String dropDownValue) {

        List<WebElement> optionsList = createSelect(locator).getOptions();

        System.out.println(optionsList.size());

        for (WebElement e : optionsList) {
            String text = e.getText();
            System.out.println(text);
            if (text.equals(dropDownValue)) {
                e.click();
                break;
            }
        }
    }

    public void selectDropDownValue(By locator, String value) {
        List<WebElement> optionsList = getElements(locator);
        for (WebElement e : optionsList) {
            String text = e.getText();
            if (text.equals(value)) {
                e.click();
                break;
            }
        }
    }

    public boolean isDropDownMultiple(By locator) {
        return createSelect(locator).isMultiple() ? true : false;
    }

    /**
     * This method is used to select the values from the drop down. It can select;
     * 1. single selection 2. Multiple selection 3. All Selection: please pass "all"
     * as a value to select all the values
     *
     * @param locator
     * @param values
     */
    public void selectDropDownMultipleValues(By locator, By optionLocator, String... values) {
        if (isDropDownMultiple(locator)) {
            if (values[0].equalsIgnoreCase("all")) {
                List<WebElement> optionsList = getElements(optionLocator);
                for (WebElement e : optionsList) {
                    e.click();
                }
            } else {
                for (String value : values) {
                    createSelect(locator).selectByVisibleText(value);
                }
            }

        }

    }

    // *****************Actions utils ***************//

    public void doActionsSendKeys(By locator, String value) {
        Actions act = new Actions(driver);
        act.sendKeys(getElement(locator), value).perform();
    }

    public void doActionsClick(By locator) {
        Actions act = new Actions(driver);
        act.click(getElement(locator)).build().perform();
    }

    public void doActionsClickLog(By locator, String printConsoleVal) {
        Actions act = new Actions(driver);
        act.click(getElement(locator)).build().perform();
        Log.info(printConsoleVal);
    }

    public void doActionsMoveToElement(By locator, String printConsoleVal) {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(getElement(locator)).build().perform();
            Thread.sleep(1000);
            doClick(locator);
            Log.info(printConsoleVal);
        } catch (Exception e) {
            Log.error("Error while selecting the value");
        }
    }

    public void twoLevelMenuHandle(By parentMenuLocator, By childMenuLocator, String printConsoleVal)
            throws InterruptedException {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(getElement(parentMenuLocator)).build().perform();
            Thread.sleep(1000);
            doClick(childMenuLocator);
            Log.info(printConsoleVal);
        } catch (Exception e) {
            Log.error("Error while selecting the value");
        }
    }

    public void fourLevelMenuHandle(By parentMenuLocator, By firstChildMenuLocaor, By secondChildMenuLocaor,
                                    By thirdChildMenuLocaor) throws InterruptedException {

        Actions act = new Actions(driver);

        doClick(parentMenuLocator);
        Thread.sleep(1000);

        act.moveToElement(getElement(firstChildMenuLocaor)).build().perform();

        Thread.sleep(1000);

        act.moveToElement(getElement(secondChildMenuLocaor)).build().perform();

        Thread.sleep(1000);

        doClick(thirdChildMenuLocaor);
    }

    public void doActionsSendKeysWithPause(By locator, String value) {
        Actions act = new Actions(driver);
        char val[] = value.toCharArray();
        for (char c : val) {
            act.sendKeys(getElement(locator), String.valueOf(c)).pause(500).build().perform();
        }
    }

    // ****************Wait Utils***************//

    /**
     * An expectation for checking that an element is present on the DOM of a page.
     * This does not necessarily mean that the element is visible on the page.
     *
     * @param locator
     * @param timeOut
     * @return
     */
    public WebElement waitForPresenceOfElement(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    /**
     * An expectation for checking that an element is present on the DOM of a page.
     * This does not necessarily mean that the element is visible on the page.
     *
     * @param locator
     * @param timeOut
     * @param intervalTime
     * @return
     */
    public WebElement waitForPresenceOfElement(By locator, int timeOut, int intervalTime) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut), Duration.ofSeconds(intervalTime));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));

    }

    /**
     * An expectation for checking that an element is present on the DOM of a page
     * and visible. Visibility means that the element is not only displayed but also
     * has a height and width that is greater than 0.
     *
     * @param locator
     * @param timeOut
     * @return
     */
    public WebElement waitForVisibilityOfElement(By locator, int timeOut) {
        WebElement ele = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            ele = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            Log.error("Element is not visible");
        }
        return ele;
    }

    public WebElement waitForVisibilityOfElementLog(By locator, int timeOut, String printConsoleVal) {
        WebElement ele = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            ele = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Log.info(printConsoleVal);
        } catch (Exception e) {
            Log.error("Element is not visible");
        }
        return ele;
    }

    public WebElement waitVisibilityOfElement(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void doClickWithWait(By locator, int timeOut) {
        try {
            waitForVisibilityOfElement(locator, timeOut).click();
        } catch (Exception e) {
            waitForVisibilityOfElement(locator, timeOut);
            doActionsClick(locator);
        }

    }

    public void doSendKeysWithWait(By locator, String value, int timeOut) {
        waitForVisibilityOfElement(locator, timeOut).sendKeys(value);
    }

    /**
     * An expectation for checking that all elements present on the web page that
     * match the locator are visible. Visibility means that the elements are not
     * only displayed but also have a height and width that is greater than 0.
     *
     * @param locator
     * @param timeOut
     * @return
     */
    public List<WebElement> waitForVisibilityOfElements(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));

    }

    public void doSendKeysWithWaitEnter(By locator, String value, int timeOut) throws InterruptedException {
        WebElement element = waitForVisibilityOfElement(locator, timeOut);
        element.sendKeys(value);
        Thread.sleep(2000);
        element.sendKeys(Keys.ENTER);
    }

    /**
     * An expectation for checking that there is at least one element present on a
     * web page.
     *
     * @param locator
     * @param timeOut
     * @return
     */
    public List<WebElement> waitForPresenceOfElements(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public String waitForTitleContains(String titleFraction, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

        try {
            if (wait.until(ExpectedConditions.titleContains(titleFraction))) {
                return driver.getTitle();
            }
        } catch (TimeoutException e) {
            System.out.println(titleFraction + " title value is not present....");
            e.printStackTrace();
        }
        return titleFraction;

    }

    public String waitForTitleIs(String title, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

        try {
            if (wait.until(ExpectedConditions.titleIs(title))) {
                Log.info("title is " + title);
                return driver.getTitle();
            }
        } catch (TimeoutException e) {
            Log.error(title + " title value is not present....");
        }
        return title;

    }

    public String waitForURLContains(String urlFraction, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

        try {
            if (wait.until(ExpectedConditions.urlContains(urlFraction))) {
                return driver.getCurrentUrl();
            }
        } catch (TimeoutException e) {
            System.out.println(urlFraction + " url value is not present....");
            e.printStackTrace();
        }
        return urlFraction;

    }

    public String waitForURLToBe(String url, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

        try {
            if (wait.until(ExpectedConditions.urlToBe(url))) {
                return driver.getCurrentUrl();
            }
        } catch (TimeoutException e) {
            System.out.println(url + " url value is not present....");
            e.printStackTrace();
        }
        return url;

    }

    public Alert waitForJSAlert(int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        return wait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptJSAlert(int timeOut) {
        waitForJSAlert(timeOut).accept();
    }

    public void dismissJSAlert(int timeOut) {
        waitForJSAlert(timeOut).dismiss();
    }

    public String getJsAlertText(int timeOut) {
        return waitForJSAlert(timeOut).getText();
    }

    public void enterValueOnJsAlert(int timeOut, String value) {
        waitForJSAlert(timeOut).sendKeys(value);
    }

    public void waitForFrameByLocator(By frameLocator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
    }

    public void waitForFrameByIndex(int frameIndex, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
    }

    public void waitForFrameByIDOrName(String IDOrName, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IDOrName));
    }

    public void waitForFrameByElement(WebElement frameElement, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
    }

    public boolean checkNewWindowExist(int timeOut, int expectedNumberOfWindows) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));

        try {
            if (wait.until(ExpectedConditions.numberOfWindowsToBe(expectedNumberOfWindows))) {
                return true;
            }
        } catch (TimeoutException e) {
            System.out.println("number of windows are not same....");
        }
        return false;
    }

    /**
     * An expectation for checking an element is visible and enabled such that you
     * can click it.
     *
     * @param locator
     * @param timeOut
     */
    public void clickElementWhenReady(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        } catch (TimeoutException e) {
            System.out.println("element is not clickable or enabled...");
        }
    }

    public WebElement waitForElementWithFluentWait(By locator, int timeOut, int intervalTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(intervalTime))
                .withMessage("--time out is done...element is not found....").ignoring(NoSuchElementException.class)
                .ignoring(ElementNotInteractableException.class);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForFrameWithFluentWait(String frameIDORName, int timeOut, int intervalTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(intervalTime))
                .withMessage("--time out is done...frame is not found....").ignoring(NoSuchFrameException.class);

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIDORName));
    }

    public Alert waitForJSAlertWithFluentWait(int timeOut, int intervalTime) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
                .pollingEvery(Duration.ofSeconds(intervalTime))
                .withMessage("--time out is done...alert is not appeared....").ignoring(NoAlertPresentException.class);

        return wait.until(ExpectedConditions.alertIsPresent());
    }

    // *****************Custom Wait***********************//

    public WebElement retryingElement(By locator, int timeOut) {

        WebElement element = null;
        int attempts = 0;

        while (attempts < timeOut) {
            try {
                element = getElement(locator);
                System.out.println("element is found...." + locator + " in attempt " + attempts);
                break;
            } catch (NoSuchElementException e) {
                System.out.println("element is not found...." + locator + " in attempt " + attempts);
                try {
                    Thread.sleep(500);// default polling time = 500 ms
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

            }

            attempts++;
        }

        if (element == null) {
            System.out.println("element is not found....tried for " + timeOut + " times " + " with the interval of "
                    + 500 + " milli seconds ");
            throw new FrameworkException("No Such Element");
        }

        return element;
    }

    public WebElement retryingElement(By locator, int timeOut, int intervalTime) {

        WebElement element = null;
        int attempts = 0;

        while (attempts < timeOut) {
            try {
                element = getElement(locator);
                System.out.println("element is found...." + locator + " in attempt " + attempts);
                break;
            } catch (NoSuchElementException e) {
                System.out.println("element is not found...." + locator + " in attempt " + attempts);
                try {
                    Thread.sleep(intervalTime);// custom polling time
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

            }

            attempts++;
        }

        if (element == null) {
            System.out.println("element is not found....tried for " + timeOut + " times " + " with the interval of "
                    + 500 + " milli seconds ");
            throw new FrameworkException("No Such Element");
        }

        return element;
    }

    public boolean isPageLoaded(int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        String flag = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"))
                .toString();
        return Boolean.parseBoolean(flag);
    }

    public void waitForLoad(int timeout, String printConsoleVal) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeout)).until((ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
            Log.info(printConsoleVal + "in" + timeout + "seconds");
        } catch (TimeoutException e) {
            e.printStackTrace();
            Log.error("Page did not load within the specified timeout.");
            // Handle the timeout exception as needed
        }
    }

    public boolean isPageLoadedLog(int timeOut, String printConsoleVal) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        String flag = wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"))
                .toString();
        Log.info(printConsoleVal + "in" + timeOut + "seconds");
        return Boolean.parseBoolean(flag);
    }

    public void doClear(By locator) {
        getElement(locator).clear();
    }

    public void doClearLog(By locator, String printConsoleVal) {
        getElement(locator).clear();
        Log.error(printConsoleVal);
    }

    public void doClearUsingKeys(By locator) {
        getElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public void doClearUsingKeysLog(By locator, String printConsoleVal) {

        try {
            getElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            Log.info(printConsoleVal);
        } catch (Exception e) {
            Log.error("Error while clearing the field");
        }
    }

    public void doClearUsingKeysWithWait(By locator, int timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        getElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public Properties readProperties() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(
                    System.getProperty("user.dir") + "/src/main/java/com/sat/config/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;
    }

    public void doElementClickable(By locator, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            System.out.println("Element is not clickable or enabled");

        }
    }

    public void doElementClickableLog(By locator, int timeOut, String printConsoleVal) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            Log.info(printConsoleVal);
        } catch (TimeoutException e) {
            Log.info("Element is not clickable or enabled");

        }
    }

    public boolean isClickable(WebElement ele, int timeOut) {
        boolean flag = true;
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeOut)).until(ExpectedConditions.elementToBeClickable(ele));
            // doElementClickable(locator, timeOut);
            System.out.println("Element is clickable");
        } catch (Exception e) {
            System.out.println("Element isn't clickable");
            flag = false;
        }
        return flag;
    }

    public void doDoubleClick(By locator) {
        Actions act = new Actions(driver);
        act.doubleClick(getElement(locator)).build().perform();
    }

    public void scrollUsingRobotClass() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Robot robot;
        try {
            robot = new Robot();
            for (int i = 0; i <= 5; i++) {
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
            }

        } catch (AWTException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            System.out.println("scroll is not working " + e.getStackTrace());
        }
    }

    /*
     * Generate Last Month Random Date in mm/dd/YYYY format
     */
    public String generateLastMonthRandomDate() {
        Random random = new Random();
        LocalDate today = LocalDate.now();
        YearMonth lastMonth = YearMonth.from(today).minusMonths(1);
        int randomDay = random.nextInt(lastMonth.lengthOfMonth()) + 1;
        LocalDate randomDateLastMonth = lastMonth.atDay(randomDay);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = randomDateLastMonth.format(formatter);
        return formattedDate;

    }

    public boolean staleElementRefExecClickCRM(By locator) {
        WebElement element = getElement(locator);
        boolean result = false;
        int attempts = 0;
        while (attempts < 3) {
            try {
                element.getText();
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

    /**
     * Explicit wait till element is visible on the screen
     *
     * @param locator
     * @param time
     */
    public void waitTillElementIsDisplayed(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * Explicit wait till element presence on the screen
     *
     * @param element
     * @param time
     * @return
     */
    public WebElement waitTillPresenceOfElementReturn(By element, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        return wait.until(ExpectedConditions.presenceOfElementLocated(element));
    }

    /**
     * Explicit wait till element is invisible on the screen
     *
     * @param locator
     * @param timeOut
     * @return
     */
    public Boolean waitForInVisibilityOfElement(By locator, int timeOut) {
        Boolean isElementInvisible = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
            isElementInvisible = wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            Log.error("Element is still visible after waiting for " + timeOut + " seconds.");
        } catch (Exception e) {
            Log.error("An error occurred while waiting for the element to become invisible: " + e.getMessage());
        }
        return isElementInvisible;
    }

    /**
     * Wait till the presence of element
     *
     * @param locator
     * @param time
     */
    public void waitTillPresenceElement(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    /**
     * Select an element from dropdown based on parameters
     *
     * @param element
     * @param selectType
     * @param text
     * @param elementName
     */
    public void selectDropDownValue(By element, String selectType, String text, String elementName) {
        waitVisibilityOfElement(element, 20);
        if (selectType.equals("selectByVisibleText")) {
            try {
                Select select = new Select(getElement(element));
                select.selectByVisibleText(text);
                Log.info(elementName + " selected");
            } catch (Exception e) {
                Log.error(e.getMessage());
            }
        }
        if (selectType.equals("selectByValue")) {
            try {
                Select select = new Select(getElement(element));
                select.selectByValue(text);
                Log.info(elementName + " selected");
            } catch (Exception e) {
                Log.error(e.getMessage());
            }
        }
    }

    public String getSelectedValueFromDropdown(By locator) throws InterruptedException {
        Select select = createSelect(locator);
        WebElement selectedOption = select.getFirstSelectedOption();
        // Get the text of the selected option
        String selectedText = selectedOption.getText();
        Log.info("Selected option text: " + selectedText);
        waitForVisibilityOfElement(locator, 30);
        return selectedText;
    }

    /**
     * Generate current date and time
     */
    public static String todayDateAndTime() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        String currentDateTime = formatter.format(date);
        currentDateTime = currentDateTime.replaceAll("\\W", "");
        return currentDateTime;
    }

    /**
     * Format a given date
     *
     * @param date
     * @param format
     * @return formatted date string
     */
    private static String formatDate(Date date, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        formatter.setTimeZone(TimeZone.getTimeZone("Asia/Singapore"));
        return formatter.format(date);
    }

    /**
     * Generate current date
     */
    public static String todayDate(String format) {
        return formatDate(new Date(), format);
    }

    /**
     * Generate current date + x Days
     *
     * @param format
     * @param days
     */
    public static String todayDatePlusDays(String format, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Asia/Singapore"));
        int addedDays = 0;
        while (addedDays < days) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                addedDays++;
            }
        }
        return formatDate(calendar.getTime(), format);
    }

    /**
     * Verify the text of given attribute, e.g value
     *
     * @param locator
     * @param attribute
     * @param expectedText
     */
    public void textVerificationFormAttribute(By locator, String attribute, String expectedText) {
        waitTillElementIsDisplayed(locator, 20);
        try {
            WebElement element = getElement(locator);
            if (element.isDisplayed()) {
                String actualText = element.getAttribute(attribute);
                if (actualText.equals(expectedText)) {
                    Log.info("Element is displayed " + "Element text is: " + actualText);
                } else {
                    Log.error("Expected text is : " + expectedText + " " + "but got " + actualText);
                }
            }
        } catch (Exception e) {
            Log.error("An error occurred while getting attribute '" + attribute + "' from element: " + e.getMessage());
        }
    }

    /**
     * Switch to iFrame
     */
    public WebElement switchToFrame(By locator) {
        waitTillElementIsDisplayed(locator, 50);
        WebElement element = getElement(locator);
        driver.switchTo().frame(element);
        return element;
    }

    /**
     * Switch to Default Content
     */
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    /**
     * Scroll till End
     *
     * @param interactableElement
     * @param time
     */
    public void scrollDownTillEnd(By interactableElement, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        WebElement element = getElement(interactableElement);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
        int i = 1;
        while (i <= 5) {
            i++;
            element.sendKeys(Keys.PAGE_DOWN);
        }
    }

    /**
     * Scroll down till element available
     *
     * @param locator
     */
    public void scrollDownTillElementVisible(By locator) throws InterruptedException {
        int i = 1;
        while (i <= 5) {
            i++;
            if (isElementPresent(locator, 10)) {
                break;
            } else {
                scrollDown();
                Thread.sleep(1000);
            }
        }
    }

    /**
     * Scroll down
     */
    public void scrollDown() {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).perform();
    }

    /**
     * Wait for Alert
     */
    public void waitForAlertAndAccept(int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            Log.info(alert.getText());
            alert.accept(); // Accept the alert here
        } catch (TimeoutException e) {
            Log.info("Alert not present within the timeout period.");
        }
    }

    /**
     * Accept Alert
     */
    public void acceptAlert(int timeoutInSeconds) {
        waitForAlertAndAccept(timeoutInSeconds);
    }

    /**
     * This is giving me last value of the String
     *
     * @param input
     * @return
     */
    public static int extractLastValue(String input) {
        // Split the string by spaces
        String[] parts = input.split(" ");
        // Get the last part and convert it to an integer
        int lastValue = Integer.parseInt(parts[parts.length - 1]);
        return lastValue;
    }

    public static String getSingaporeCurrentTime() {
        ZonedDateTime singaporeTime = ZonedDateTime.now(ZoneId.of("Asia/Singapore"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        return singaporeTime.format(formatter);
    }

    public static String getSingaporeCurrentTimePlusTwoHours() {
        ZonedDateTime singaporeTimePlusTwoHours = ZonedDateTime.now(ZoneId.of("Asia/Singapore")).plusHours(2);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        return singaporeTimePlusTwoHours.format(formatter);
    }

    /**
     * This is giving current date and time in this format ddMMyyyy-HHmmss
     *
     * @return
     */
    public String currentDateTime(String format) {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Singapore"));
        // Format date as ddMMyyyy
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(format);
        String formattedDate = now.format(dateFormatter);
        // Format time as HHmmss
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HHmmss");
        String formattedTime = now.format(timeFormatter);
        // Combine date and time
        String result = formattedDate + "-" + formattedTime;
        return result;
    }

    /**
     * This is giving me 5 digit random number
     *
     * @return
     */
    public int randomNumber() {
        Random random = new Random();

        // Generate a random number between 10000 and 99999
        int randomNumber = 10000 + random.nextInt(90000);
        return randomNumber;
    }

    public void scrollDownNotification(By notificationsPanel) {
        Actions actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            WebElement notificationSection = getElement(notificationsPanel);
            actions.moveToElement(notificationSection).sendKeys(Keys.PAGE_DOWN).perform();
            Log.info("Scroll down execute");
        }
    }

    public static String getNextMonthName() {
        LocalDate currentDate = LocalDate.now();
        LocalDate nextMonthDate = currentDate.plusMonths(1);
        return nextMonthDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    public void action(By interactableElement) {
        WebElement element = getElement(interactableElement);
        waitForVisibilityOfElement(interactableElement, 40);
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    /**
     * This is a code to execute the JAVAScript
     */

    public void createApplication() {
        commonActionsPage.applicationNumber = "App" + todayDate("yyyy/MM/dd") + "EP" + randomNumber();
        Map<String, String> record = new HashMap<>();
        record.put("pub_name", commonActionsPage.applicationNumber);
        record.put("pub_applicantname", "Jane Doe");
        record.put("pub_app_nricpassportfincompanyregistrationn", "453Y");
        record.put("pub_app_contactnumber", "86041235");
        record.put("pub_organisationname", "Contoso Pvt Ltd");
        record.put("pub_app_registeredaddressoforganisation", "31 International Business Park, #05-02, 05-06/07, Singapore 609921");
        record.put("pub_app_emailaddress", "jane.doe@contoso.com");
        record.put("pub_titleofevent", "Fire Work Display and Setup Event");
        record.put("pub_eventdatestiming", "12/11/2024 1000 hrs to 16/10/2024 1800 hrs");
        record.put("pub_watersetupdatestiming", "N/A");
        record.put("pub_waterteardowndatestiming", "N/A");
        record.put("pub_landsetupdatestiming", "11/11/2024 0800 hrs to 16/10/2024 1000 hrs");
        record.put("pub_landteardowndatestiming", "16/11/2024 1800 hrs to 17/11/2024 2200 hrs");
        record.put("pub_eventlocation", "2,3,4");
        record.put("pub_descriptiondetailsofeventlocationsite", "Contoso Pvt Ltd - 2 2024 at Jurong Lake");
        record.put("pub_noofparticipants", "200");
        record.put("pub_guestofhonour", "N/A");
        record.put("pub_con_one_nameofpersonincharge", "Mike Tan");
        record.put("pub_con_one_nricpassportfincomregno", "356X");
        record.put("pub_con_one_mobilenumber", "86005678");
        record.put("pub_con_one_nameofcompany", "Fabrikam Inc.");
        record.put("pub_con_one_registeredaddressofcompany", "31 International Business Park, #05-02, 05-06/07, Singapore 609921");
        record.put("pub_con_one_emailaddress", "Mike.tan@fabrikam.com");
        record.put("pub_con_two_nameofpersonincharge", "N/A");
        record.put("pub_con_two_nricpassportfincomregno", "N/A");
        record.put("pub_con_two_mobilenumber", "N/A");
        record.put("pub_con_two_nameofcompany", "N/A");
        record.put("pub_con_two_registeredaddressofcompany", "N/A");
        record.put("pub_con_two_emailaddress", "N/A");
        record.put("pub_eventcategoryid@odata.bind", "/pub_eventcategories(dd816915-6760-ef11-bfe4-6045bd1ce588)");

        // Convert the record map to JSON
        String jsonRecord = new Gson().toJson(record);

        // Use JavaScript to send the fetch request
        String script = "fetch(Xrm.Utility.getGlobalContext().getClientUrl() + \"/api/data/v9.2/pub_eventpermitapplicationmasters\", {" +
                "method: \"POST\"," +
                "headers: {" +
                "\"OData-MaxVersion\": \"4.0\"," +
                "\"OData-Version\": \"4.0\"," +
                "\"Content-Type\": \"application/json; charset=utf-8\"," +
                "\"Accept\": \"application/json\"," +
                "\"Prefer\": \"odata.include-annotations=*\"" +
                "}," +
                "body: JSON.stringify(" + jsonRecord + ")" +
                "}).then(" +
                "function success(response) {" +
                "console.log('Response status: ' + response.status);" +
                "return response.json().then((json) => {" +
                "console.log('Response JSON: ' + JSON.stringify(json));" +
                "if (response.ok) {" +
                "var uri = response.headers.get(\"OData-EntityId\");" +
                "var regExp = /\\(([^)]+)\\)/;" +
                "var matches = regExp.exec(uri);" +
                "var newId = matches[1];" +
                "console.log('New record ID: ' + newId);" +
                "} else {" +
                "throw json.error;" +
                "}" +
                "});" +
                "}" +
                ").catch(function (error) {" +
                "console.log('Error: ' + error.message);" +
                "});";

        // Execute the script
        ((JavascriptExecutor) driver).executeScript(script);
    }


}

package com.letskodeit.pageclasses;

import com.letskodeit.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ResultsPage extends BasePage {

    public ResultsPage(WebDriver driver) {
        super(driver);

    this.driver = driver;

}

    /***
     * Variables
     * URL
     * Title
     */
    public WebDriver driver;
    private String URL = "query=";
    private String COURSES_LIST = "//div[@class='course-listing']";

    /***
     * Methods
     */
    public boolean isOpen()
    {
        return driver.getCurrentUrl().contains(URL);
    }

    public int coursesCount() {
        List<WebElement> coursesList = driver.findElements(By.xpath(COURSES_LIST));
        return coursesList.size();
    }

    public boolean verifySearchResult() {
        boolean result = false;
        if (coursesCount() > 0) {
            result = true;
        }
        result = isOpen() && result;
        return result;
    }


    public boolean verifyFilterCourseCount(int expectedCount) {
    return coursesCount() == expectedCount;
   }
}

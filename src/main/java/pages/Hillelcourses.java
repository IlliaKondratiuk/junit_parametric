package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Hillelcourses {

    @FindBy(xpath = "//button[contains(@data-dropdown-trigger, \"coursesMenu\")]")
    WebElement courses_dropdown;

    @FindBy(className = "search-field_input")
    WebElement course_search_field;

    @FindBy(xpath = "//div[contains(@class, \"search-panel_screen -result\")]//a")
    List<WebElement> results;

    @FindBy(xpath = "//h1[contains(@class, 'course-descriptor_header')]//strong")
    WebElement redirected_course_title;

    public WebDriver driver;

    public Hillelcourses(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click_courses_dropdown() {
        courses_dropdown.click();
    }

    public void course_search_input(String course) {
        course_search_field.sendKeys(course);
    }

    public void check_first_result_link() {
        results.get(0).click();
    }

    public String redirected_course_name() {
       return redirected_course_title.getText();
    }

}

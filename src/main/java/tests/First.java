package tests;

import config.ResourceBuffer;
import data.Course;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.Hillelcourses;

import java.util.Arrays;
import java.util.Collection;
import java.util.ResourceBundle;


@RunWith(Parameterized.class)
public class First extends ResourceBuffer {

    Hillelcourses page = new Hillelcourses(driver);
    Course course;

    @Parameterized.Parameters
    public static Collection options() {
        return Arrays.asList(Course.values());
    }

    public First(Course course) {
        this.course = course;
        bundle = ResourceBundle.getBundle(course.getName());
    }

    @BeforeClass
    public static void launch() {
        driver.get("https://ithillel.ua/courses");
    }

    @Test
    public void enterdrop() throws InterruptedException {
        page.click_courses_dropdown();
        page.course_search_input(bundle.getString("name"));
        Thread.sleep(3000);
    }

    @Test
    public void checklink() {
        page.check_first_result_link();
        Assert.assertEquals(driver.getCurrentUrl(), bundle.getString("link"));
    }

    @Test
    public void checkname() {
        Assert.assertEquals(page.redirected_course_name(), bundle.getString("name"));
    }


}

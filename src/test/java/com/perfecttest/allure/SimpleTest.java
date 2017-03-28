package com.perfecttest.allure;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.allure.annotations.Title;

@Title("This is our cool test suite")
@Description("测试allure")
public class SimpleTest {
	@Title("First cool check")
    @Description("In this cool test we will check cool thing")
    @Test
    public void firstSimpleTest() {
        checkResult(4 / 2, 2);
    }

    @Step("Check of calculation")
    private void checkResult(int actualResult, int expectedResult) {
        saveTextLog("Simple text attach", "This is sparta!!!");
        assertTrue("Actual result(" + actualResult + ") not equals to expected(" + expectedResult + ")", actualResult == expectedResult);
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String attachName, String message) {
        return message;
    }
}

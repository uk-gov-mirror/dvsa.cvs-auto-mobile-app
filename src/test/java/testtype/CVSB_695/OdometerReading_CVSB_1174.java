package testtype.CVSB_695;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.OdometerReadingPage;
import steps.OdometerReadingSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class OdometerReading_CVSB_1174 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Title("CVSB-1174 - AC2 - Access odometer reading fields")
    @Test
    public void testOdometerReadingFields() {
        testTypeCategoryComp.goToTestPage();
        testSteps.checkTestDetails("BQ91YHQ");
        testSteps.selectOdometerReading();
        odometerReadingSteps.checkPageDetails("Enter value", OdometerReadingPage.Units.KILOMETRES);

    }

}

package testtype.CVSB_695;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.OdometerReadingSteps;
import steps.TestSteps;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class OdometerReading_CVSB_1177 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestSteps testSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Title("CVSB-1177 - AC5 - Cancel type in odometer reading value")
    @Test
    public void testCancelTypeInOdometerReadingValue() {
        testTypeCategoryComp.goToTestPage();
        testSteps.checkTestDetails("BQ91YHQ");
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("12345678");
        // TODO refactor/continue after ios keyboard fix

    }

}

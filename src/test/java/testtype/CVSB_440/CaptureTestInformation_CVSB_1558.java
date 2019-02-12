package testtype.CVSB_440;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestHistoryDetailsSteps;
import steps.TestHistorySteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class CaptureTestInformation_CVSB_1558 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Steps
    TestHistorySteps testHistorySteps;

    @Steps
    TestHistoryDetailsSteps testHistoryDetailsSteps;


    @Title("CVSB-440 - AC4B - VSA views a test record")
    @Test
    public void testVsaViewsATestRecordB() {
        vehicleComp.goToVehicleDetails();
        vehicleDetailsSteps.selectVehicleTestHistory();
        // TODO refactor after database population with correct data
        testHistorySteps.selectTestTypeRecord("string");
        testHistoryDetailsSteps.checkPageTitle();
        testHistoryDetailsSteps.checkDetails("TEST TYPE", "DEFECTS", "Test date",
                "14 Jan 2019", "Test time", "12:36 - 12:36", "Test result", "FAILURE", "Test expiry", "14 Jan 2019");
    }

}
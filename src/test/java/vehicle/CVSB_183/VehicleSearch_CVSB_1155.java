package vehicle.CVSB_183;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.IdentifyVehicleSteps;
import steps.SiteVisitSteps;
import steps.VehicleDetailsSteps;
import steps.composed.VehicleComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleSearch_CVSB_1155 extends BaseTestClass {

    @Steps
    VehicleComp vehicleComp;

    @Steps
    IdentifyVehicleSteps identifyVehicleSteps;

    @Steps
    SiteVisitSteps siteVisitSteps;

    @Steps
    VehicleDetailsSteps vehicleDetailsSteps;

    @Ignore("[CVSB-8561] Removing test to improve overall efficiency of the mobile app Front-end automation test suite.")
    @Title("CVSB-183 - AC2 Search for vehicle using registration number")
    @Test
    public void testSearchUsingRegistrationNumber() {
        vehicleComp.goToSiteVisit();
        siteVisitSteps.createNewTest();
        identifyVehicleSteps.typeInSearchField("BQ91YHQ");
        identifyVehicleSteps.checkSearchBoxAndText("BQ91YHQ");
        identifyVehicleSteps.pressSearch();
        // identifyVehicleSteps.checkLoadingScreen();
        vehicleDetailsSteps.checkIfInDetailPageByPlate("BQ91 YHQ");

    }
}

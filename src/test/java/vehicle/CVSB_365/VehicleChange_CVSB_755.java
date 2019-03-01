package vehicle.CVSB_365;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.SelectPreparerSteps;
import steps.TestSteps;
import steps.composed.PreparerComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class VehicleChange_CVSB_755 extends BaseTestClass {

    @Steps
    PreparerComp preparerComp;

    @Steps
    TestSteps testSteps;

    @Steps
    SelectPreparerSteps selectPreparerSteps;


    @Title("CVSB-365 - AC3 - Change a vehicle after selecting a preparer")
    @Test()
    public void testChangeAVehicleAfterSelectingAPreparer() {
        preparerComp.goToSelectPreparer();
        selectPreparerSteps.selectPreparerAndConfirm(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.checkNoIdentifyVehicleOptionAvailable();
    }

}

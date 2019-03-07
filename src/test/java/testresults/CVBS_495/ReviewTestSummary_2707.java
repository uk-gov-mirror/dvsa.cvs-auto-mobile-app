package testresults.CVBS_495;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import pages.SelectReasonPage;
import pages.TestPage;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class ReviewTestSummary_2707 extends BaseTestClass {

    @Steps
    TestSteps testSteps;

    @Steps
    TestTypeCategorySteps testTypeCategorySteps;

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    EUVehicleCategorySteps euVehicleCategorySteps;

    @Steps
    CountryOfRegistrationSteps countryOfRegistrationSteps;

    @Steps
    OdometerReadingSteps odometerReadingSteps;

    @Steps
    TestReviewSteps testReviewSteps;

    @Steps
    TestTypeDetailsSteps testTypeDetailsSteps;

    @Steps
    AbandonTestSteps abandonTestSteps;

    @Steps
    SelectReasonSteps selectReasonSteps;

    @Steps
    SeatbeltInstallationCheckSteps seatbeltInstallationCheckSteps;

    @Title("CVSB-495 - AC7 - VSA cannot change details of abandoned test types")
    @Test
    public void canNotChangeDetailsOfAbandonedTestTypes() {
        testTypeCategoryComp.goToTestPage(preparerService.getPreparerByIndex(0).getPreparerId(), preparerService.getPreparerByIndex(0).getPreparerName());
        testSteps.clickCountryOfRegistrationOption();
        countryOfRegistrationSteps.selectACountry("Norway");
        testSteps.checkCountryOfRegistrationFieldIsUpdated("Norway");
        testSteps.selectVehicleCategoryOption();
        euVehicleCategorySteps.selectM1Option();
        testSteps.selectOdometerReading();
        odometerReadingSteps.typeInField("123");
        odometerReadingSteps.checkReadingValue("123");
        odometerReadingSteps.pressSave();
        testSteps.addTestType();
        testTypeCategorySteps.selectFromTestTypeList("Annual test");
        testSteps.selectTestType("Annual test", TestPage.TestTypeStatuses.IN_PROGRESS);
        testTypeDetailsSteps.setCarriedOutDuringTest(true);
        testTypeDetailsSteps.selectMostRecentInstallationCheck();
        testTypeDetailsSteps.setMostRecentInstallationCheckDateOneUnit();
        testTypeDetailsSteps.selectNumberOfSeatbeltsFitted();
        seatbeltInstallationCheckSteps.inputNumberOfSeatbelts("4");
        testTypeDetailsSteps.pressSave();
        testSteps.reviewAction();
        testReviewSteps.changeDetails();
        //TODO remove the addNotes step after the abandon button is in view
        testTypeDetailsSteps.addNotes("Test");
        testReviewSteps.pressTestTypeAbandonButton();
        selectReasonSteps.selectMultipleReasons(SelectReasonPage.Reasons.REASON_1, SelectReasonPage.Reasons.REASON_10);
        selectReasonSteps.pressNextButton();
        abandonTestSteps.pressDone();
        abandonTestSteps.pressAbandon();
        testReviewSteps.goToTestPage();
        testTypeDetailsSteps.pressSave();
        testReviewSteps.checkElementIsDisplayed("Annual test");
        testReviewSteps.checkElementIsDisplayed("ABANDONED");
        testReviewSteps.changeDetailsIsNotDisplayed();
    }
}
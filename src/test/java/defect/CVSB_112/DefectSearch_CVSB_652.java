package defect.CVSB_112;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.*;
import steps.composed.TestTypeCategoryComp;
import util.BaseTestClass;

@RunWith(SerenityRunner.class)
public class DefectSearch_CVSB_652 extends BaseTestClass {

    @Steps
    TestTypeCategoryComp testTypeCategoryComp;

    @Steps
    TestTypeSteps testTypeSteps;

    @Steps
    TestSteps testSteps;

    @Steps
    RecordDefectSteps recordDefectSteps;

    @Steps
    DefectItemSteps defectItemSteps;

    @Steps
    DefectItemLevelThreeSteps defectItemLevelThreeSteps;

    @Steps
    DefectDetailsSteps defectDetailsSteps;


    @Title("CVSB-112 - AC5 Test returning to search results")
    @Test
    public void defectGoBackFromFirstLevelToMain() {
        testTypeCategoryComp.completeAddTestType();
        testSteps.selectNotCompleteTest("ANNUAL TEST");
        testTypeSteps.selectAddDefect("ANNUAL TEST");
        recordDefectSteps.checkLevelOneListOfDefects("Seat Belts & Supplementary Restraint Systems", "Registration Plate");
        recordDefectSteps.searchForDefect("Seat Belts & Supplementary Restraint Systems");
        recordDefectSteps.selectItemFromSearchList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.checkItemsArePresent("1. Obligatory Seat Belt:", "2. Anchorages:");
        defectItemSteps.clickBack();
        recordDefectSteps.checkExpectedPresentDefects(2, "3. Seat Belts & Supplementary Restraint Systems");
        recordDefectSteps.checkExpectedPresentDefects(0, "1. Registration Plate");


        recordDefectSteps.selectItemFromSearchList("3. Seat Belts & Supplementary Restraint Systems");
        defectItemSteps.checkItemsArePresent("1. Obligatory Seat Belt:", "2. Anchorages:");
        defectItemSteps.searchForDefect("Obligatory Seat Belt:");
        defectItemSteps.selectItemFromSearchList("1. Obligatory Seat Belt:");
        defectItemLevelThreeSteps.checkItemsArePresent("missing.", "of an incorrect type.");
        defectItemLevelThreeSteps.clickBack();
        defectItemSteps.checkExpectedPresentDefects(2, "1. Obligatory Seat Belt:");
        defectItemSteps.checkExpectedPresentDefects(0, "2. Anchorages:");


        defectItemSteps.selectItemFromSearchList("1. Obligatory Seat Belt:");
        defectItemLevelThreeSteps.checkItemsArePresent("missing.", "of an incorrect type.");
        defectItemLevelThreeSteps.searchForDefect("missing.".toUpperCase());
        defectItemLevelThreeSteps.selectItemFromSearchList("missing.");
        defectDetailsSteps.checkPageIsLoaded();
        defectDetailsSteps.clickBack();
        defectItemLevelThreeSteps.checkExpectedPresentDefects(1, "missing.");
        defectItemLevelThreeSteps.checkExpectedPresentDefects(0, "of an incorrect type.");

    }
}
package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.EUVehicleCategoryPage;

import static org.assertj.core.api.Assertions.assertThat;

public class EUVehicleCategorySteps extends ScenarioSteps {

    EUVehicleCategoryPage euVehicleCategoryPage;

    @Step
    public void clickSaveOptionButton() {
        euVehicleCategoryPage.clickSaveButton();
    }

    @Step
    public void selectM1Option() {
        euVehicleCategoryPage.clickM1Option();
        clickSaveOptionButton();
    }

    @Step
    public void selectM2Option() {
        euVehicleCategoryPage.clickM2Option();
        clickSaveOptionButton();
    }

    @Step
    public void selectM3Option() {
        euVehicleCategoryPage.clickM3Option();
        clickSaveOptionButton();
    }

    @Step
    public void selectO1Option() {
        euVehicleCategoryPage.clickO1Option();
        clickSaveOptionButton();
    }
    @Step
    public void selectO2Option() {
        euVehicleCategoryPage.clickO2Option();
        clickSaveOptionButton();
    }

    @Step
    public void selectO3Option() {
        euVehicleCategoryPage.clickO3Option();
        clickSaveOptionButton();
    }

    @Step
    public void selectO4Option() {
        euVehicleCategoryPage.clickO4Option();
        clickSaveOptionButton();
    }

    @Step
    public void checkTitleIsDisplayed() {
        euVehicleCategoryPage.waitUntilPageIsLoaded();
        assertThat(euVehicleCategoryPage.isPageTitleDisplayed()).isTrue();
    }

    @Step
    public void checkOptionsAreDisplayed() {
        euVehicleCategoryPage.waitUntilPageIsLoaded();
        assertThat(euVehicleCategoryPage.isM1Displayed()).isTrue();
        assertThat(euVehicleCategoryPage.isM2Displayed()).isTrue();
        assertThat(euVehicleCategoryPage.isM3Displayed()).isTrue();
    }

    @Step
    public void checkOptionsForTrailerAreDisplayed() {
        euVehicleCategoryPage.waitUntilPageIsLoaded();
        assertThat(euVehicleCategoryPage.isO1Displayed()).isTrue();
        assertThat(euVehicleCategoryPage.isO2Displayed()).isTrue();
        assertThat(euVehicleCategoryPage.isO3Displayed()).isTrue();
        assertThat(euVehicleCategoryPage.isO4Displayed()).isTrue();
    }
}

package douglas.testrunner.actions;

import douglas.testrunner.ElementLocaterEngine;
import douglas.testrunner.LocatedElement;
import douglas.testrunner.StepException;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

public class ActionType implements Action {

    @Override
    public JSONObject execute(WebDriver driver, JSONObject step) throws StepException {
        LocatedElement locatedElement = new ElementLocaterEngine().find(driver, step);

        String value = (String)step.get("value");

        locatedElement.getElement().sendKeys(value);

        return locatedElement.getStep();
    }
}

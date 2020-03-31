package website;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchField  {
WebDriver driver;
    public SearchField(WebDriver driver) {
        this.driver=driver;
    }

    @FindBy(css=".search-form.search-form__primary.views-exposed-form > form[method='get']  input#edit-keys")
    WebElement searchField;

    public void clickSearchField(){
        searchField.click();
    }

}

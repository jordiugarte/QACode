package todoLy;

import controls.Label;
import org.openqa.selenium.By;

import java.sql.Driver;

public class CenterSection {
    public Label projectNameLabel = new Label(By.xpath("//div[@id='CurrentProjectTitle']"));

    public CenterSection() {
    }
}
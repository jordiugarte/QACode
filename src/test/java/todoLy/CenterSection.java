package todoLy;

import controls.Button;
import controls.Label;
import controls.TextBox;
import org.openqa.selenium.By;

import java.sql.Driver;

public class CenterSection {
    public Label projectNameLabel = new Label(By.xpath("//div[@id='CurrentProjectTitle']"));
    public TextBox itemNameTextBox = new TextBox(By.xpath("//div[@id='AddNewItemDiv']"));
    public Button addItemButton = new Button(By.xpath("//input[@id='NewItemAddButton']"));
    public Button selectItemButton(String name) {return new Button(By.xpath("//div[contains(.,'" + name + "') and @class='ItemContentDib']"));}
    public Button saveItemButton = new Button(By.xpath("//img[@id='ItemEditSubmit']"));
    public Button itemOptionsButton = new Button(By.xpath("//img[@style='display: none;']/img[@src='/Images/dropdown.png']/img[@class='ItemMenu']"));
    public Button deleteOptionsButton = new Button(By.xpath("//li[@class='delete separator']"));

    public CenterSection() {
    }
}
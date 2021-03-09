package todoLy;

import controls.Button;
import controls.TextBox;
import org.openqa.selenium.By;

public class LeftSection {
    public Button addNewProjectButton = new Button(By.xpath("//td[contains(.,'Add New Project') and @class='ProjItemContent']"));

    public Button selectProjectButton(String projectName) {
        return new Button(By.xpath("//td[contains(.,'" + projectName + "') and @class='ProjItemContent']"));
    }

    public Button optionsProjectButton = new Button(By.xpath("//div[@style='display: block;']/img[@src='/Images/dropdown.png']"));
    public Button deleteProjectButton = new Button(By.xpath("//ul[@id='projectContextMenu']//a[contains(.,'Delete')]"));
    public Button editProjectButton = new Button(By.xpath("//ul[@id='projectContextMenu']//a[contains(.,'Edit')]"));
    public Button addButton = new Button(By.xpath("//input[@id='NewProjNameButton']"));
    public TextBox nameProjectTextBox = new TextBox(By.xpath("//input[@id='NewProjNameInput']"));
    public TextBox editProjectTextBox = new TextBox(By.xpath("//input[@id='ItemEditTextbox']"));
    public Button saveEditProjectTextBox = new Button(By.xpath("//img[@id='ItemEditSubmit']"));

    public LeftSection() {

    }
}
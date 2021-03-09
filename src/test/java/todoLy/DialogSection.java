package todoLy;

import controls.AlertDialogButton;

public class DialogSection {
    public void acceptButton() {
        new AlertDialogButton().getDriver().switchTo().alert().accept();
    }

    public void rejectButton() {
        new AlertDialogButton().getDriver().switchTo().alert().dismiss();
    }
}

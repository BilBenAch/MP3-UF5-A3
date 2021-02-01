import control.RegistreUFCControl;
import model.OpenCSV;
import vista.Menu;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        OpenCSV openCSV = new OpenCSV();
        RegistreUFCControl registreUFCControl = new RegistreUFCControl(openCSV);
        Menu menu = new Menu(registreUFCControl);
        menu.startMenu();
    }
}

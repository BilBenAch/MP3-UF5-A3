import control.RegistreUFCControl;
import model.OpenCSV;
import vista.Menu;

public class main {
    public static void main(String[] args) {
        OpenCSV openCSV = new OpenCSV();
        RegistreUFCControl registreUFCControl = new RegistreUFCControl(openCSV);
        Menu menu = new Menu(registreUFCControl);
        menu.startMenu();
    }
}

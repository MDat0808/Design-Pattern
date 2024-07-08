package BaiTapBuoi6;

public class AppC2F {
    public static void main(String[] args) {
        Model model = new Model();

        View view = new View(model);
        Controller controller = new Controller(view, view.getModel());
        view.setController(controller);
        view.buildApp();
    }
}

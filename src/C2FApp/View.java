package C2FApp;

import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import C2FApp.observer.Subcriber;

public class View extends JFrame implements Subcriber {
    private String title;
    private JPanel jPanel;
    private JLabel jLabelCelsius, jLabelFahrenheit;
    private JTextField jTextCelsius, jTextFahrenheit;
    private JMenuBar menuBarRemote = null;
    private Controller controller;
    private Model model;

    public View(Model model) {
        this.model = model;
        // this.controller = new Controller(this, this.getModel());
        model.subcribe(this);
        // add(jPanel);
        // title = "MVC Pattern";
        // setSize(400, 400);
        // setTitle(title);
        // setVisible(true);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void buildApp() {
        build();
        add(jPanel);
        title = "MVC Pattern";
        setSize(400, 400);
        setTitle(title);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void build() {
        buildMenu();

        jPanel = new JPanel();
        jLabelCelsius = new JLabel("Celsius");
        jTextCelsius = new JTextField(10);
        jLabelFahrenheit = new JLabel("Fahrenheit");
        jTextFahrenheit = new JTextField(10);
        jTextCelsius.setText("0");
        jTextFahrenheit.setText("0");
        jTextCelsius.addKeyListener(controller);
        jTextFahrenheit.addKeyListener(controller);
        jPanel.add(jLabelCelsius);
        jPanel.add(jTextCelsius);
        jPanel.add(jLabelFahrenheit);
        jPanel.add(jTextFahrenheit);

    }

    public void buildMenu() {
        menuBarRemote = new JMenuBar();
        setJMenuBar(menuBarRemote);
        JMenu menu = new JMenu("Commands");
        menuBarRemote.add(menu);
        JMenuItem f2c = new JMenuItem("F2C");
        JMenuItem c2f = new JMenuItem("C2F");
        JMenuItem exit = new JMenuItem("Exit");
        f2c.addActionListener(controller);
        c2f.addActionListener(controller);
        exit.addActionListener(controller);
        menu.add(f2c);
        menu.add(c2f);
        menu.add(exit);

    }

    public JTextField getjTextCelsius() {
        return jTextCelsius;
    }

    public JTextField getjTextFahrenheit() {
        return jTextFahrenheit;
    }

    @Override
    public void updateFahrenheit() {
        double fahrenheit = model.getFahrenheit();
        jTextFahrenheit.setText("" + fahrenheit);

    }

    @Override
    public void updateCelsius() {
        double celsius = model.getCelsius();
        jTextCelsius.setText("" + Math.round(celsius));
    }

    public Model getModel() {
        return model;
    }

}

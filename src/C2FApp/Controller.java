package BaiTapBuoi6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import BaiTapBuoi6.Command.Command;
import BaiTapBuoi6.Command.C2FCommand;
import BaiTapBuoi6.Command.F2CCommand;
import BaiTapBuoi6.Command.ExitCommand;
import BaiTapBuoi6.Command.CommandProcessor;

public class Controller implements ActionListener, KeyListener {
    private CommandProcessor commandProcessor = null;
    private Model model;
    private View view;

    Controller(View view, Model model) {
        commandProcessor = CommandProcessor.makeCommandProcessor();
        this.model = model;
        this.view = view;
    }

    public void test() {
        System.out.println("test");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double celsius = Double.parseDouble(view.getjTextCelsius().getText());
        double fahrenheit = Double.parseDouble(view.getjTextFahrenheit().getText());
        Command command = null;
        String actionCommand = e.getActionCommand();
        if (actionCommand.equals("C2F")) {
            command = new C2FCommand(model, celsius);
            commandProcessor.execute(command);
        } else if (actionCommand.equals("F2C")) {
            command = new F2CCommand(model, fahrenheit);
            commandProcessor.execute(command);
        } else if (actionCommand.equals("Exit")) {
            command = new ExitCommand(model, view);
            commandProcessor.execute(command);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Unimplemented method keyReleased'");

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (e.getSource() instanceof JTextField) {
                JTextField textField = (JTextField) e.getSource();
                String actionCommand = "";
                if (textField == view.getjTextCelsius()) {
                    System.out.println("c2f");
                    actionCommand = "C2F";
                } else if (textField == view.getjTextFahrenheit()) {
                    System.out.println("f2c");
                    actionCommand = "F2C";
                }

                if (!actionCommand.isEmpty()) {
                    actionPerformed(new ActionEvent(textField, ActionEvent.ACTION_PERFORMED, actionCommand));
                }
            }
        }
        if (Character.isDigit(e.getKeyChar())) {
            JTextField textField = (JTextField) e.getSource();
            String currentText = textField.getText();
            String newText = currentText + e.getKeyChar();
            textField.setText(newText);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method keyReleased'");
    }

}

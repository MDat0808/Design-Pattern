package BaiTapBuoi6.Command;

import javax.swing.JFrame;

import BaiTapBuoi6.Model;

public class ExitCommand extends Command {
    private JFrame frame;

    public ExitCommand(Model model, JFrame jFrame) {
        super(model);
        this.frame = jFrame;
    }

    @Override
    public void execute() {
        frame.dispose();
    }

}

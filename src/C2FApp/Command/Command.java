package C2FApp.Command;

import C2FApp.Model;

public abstract class Command {
    protected Model model = null;

    public Command(Model model) {
        this.model = model;
    }

    public abstract void execute();
}

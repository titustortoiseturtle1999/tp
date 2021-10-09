package seedu.duke.commands;

import seedu.duke.modules.Module;

public class AddModCommand extends Command {
    public static final String COMMAND_WORD = "addmod";

    private final Module moduleToAdd;

    public AddModCommand(Module moduleToAdd) {
        this.moduleToAdd = moduleToAdd;
        selectedModuleList.addModule(moduleToAdd);
        System.out.println("New module added: " + moduleToAdd.getModuleCode());
    }
}
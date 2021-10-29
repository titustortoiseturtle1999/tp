package seplanner.commands;

import seplanner.modules.Module;
import seplanner.modules.ModuleList;
import seplanner.ui.UiInvalid;
import seplanner.ui.UiModule;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class FindModCommand extends Command {

    public FindModCommand(String userInput, ModuleList moduleMasterList) {
        ArrayList<Module> result = (ArrayList<Module>) moduleMasterList.getList().stream()
                .filter((module) -> module.getModuleCode().toLowerCase().contains(userInput.toLowerCase()))
                .collect(Collectors.toList());
        if (result.size() == 0) {
            UiInvalid.printFindModNull();
        } else {
            for (int i = 0; i < result.size(); i++) {
                UiModule.printModule(result.get(i), result.get(i).getMasterListIndex(moduleMasterList), false);
            }
        }
    }
}
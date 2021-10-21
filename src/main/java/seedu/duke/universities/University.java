package seedu.duke.universities;

import seedu.duke.modules.Module;
import seedu.duke.modules.ModuleList;
import seedu.duke.modules.ModuleMapping;
import seedu.duke.ui.Ui;

import java.util.ArrayList;

public class University {
    protected String name;
    public ArrayList<ModuleMapping> list;

    public University(String name) {
        this.name = name;
        this.list = new ArrayList<>();
    }

    public University(String name, ArrayList<ModuleMapping> list) {
        this.name = name;
        this.list = list;
    }

    public void addMapping(Module localModule, Module mappedModule) {
        list.add(new ModuleMapping(localModule, mappedModule));
    }

    public void removeMapping(Module localModule, Module mappedModule) {
        list.remove(new ModuleMapping(localModule, mappedModule));
    }

    public void listAllMappings() {
        for (int i = 0; i < list.size(); i++) {
            ModuleMapping currentMapping = list.get(i);
            Ui.printModuleMapping(currentMapping, i + 1);
        }
    }

    public void listSelectedMappings(ModuleList selectedModuleList) {
        ArrayList<ModuleMapping> selectedMappings = getSelectedMappings(selectedModuleList);
        for (int i = 0; i < selectedMappings.size(); i++) {
            Ui.printModuleMapping(selectedMappings.get(i), i + 1);
        }
    }

    public ArrayList<ModuleMapping> getSelectedMappings(ModuleList selectedModuleList) {
        ArrayList<ModuleMapping> selectedMappings = new ArrayList<>();
        for (ModuleMapping currentMapping : list) {
            if (selectedModuleList.searchModule(currentMapping.localModule.getModuleCode())) {
                selectedMappings.add(currentMapping);
            }
        }
        return selectedMappings;
    }

    public ModuleMapping getMapping(Module selectedLocalModule, ModuleList selectedModuleList) {
        ModuleMapping selectedMapping = null;
        for (int i = 0; i < list.size(); i++) {
            ModuleMapping currentMapping = list.get(i);
            if (currentMapping.localModule.getModuleCode()
                    .equals(selectedLocalModule.getModuleCode())) {
                selectedMapping = currentMapping;
            }
        }
        return selectedMapping;
    }

    public Module getMappedModule(Module selectedLocalModule, ModuleList selectedModuleList) {
        String mappedModuleCode = "";
        for (int i = 0; i < list.size(); i++) {
            ModuleMapping currentMapping = list.get(i);
            if (currentMapping.localModule.getModuleCode()
                    .equals(selectedLocalModule.getModuleCode())) {
                mappedModuleCode = currentMapping.getMappedModule().getModuleCode();
            }
        }
        return selectedModuleList.getModule(mappedModuleCode);
    }

    public String getName() {
        return name;
    }

    public int getMasterListIndex(UniversityList universityMasterList) {
        for (int i = 0; i < universityMasterList.getSize(); i++) {
            if (name.equals(universityMasterList.get(i).getName())) {
                return i + 1;
            }
        }
        return 0;
    }

    public String toFileFormat() {
        String result = name + System.lineSeparator();
        for (int i = 0; i < list.size(); i++) {
            Module local = list.get(i).getLocalModule();
            Module mapped = list.get(i).getMappedModule();
            result += (local.getModuleCode() + " # " + local.getModuleName()
                    + " # " + local.getModuleCredits() + " # " + mapped.getModuleCode()
                    + " # " + mapped.getModuleName() + " # " + mapped.getModuleCredits()
                    + System.lineSeparator());
        }
        return result;
    }

}
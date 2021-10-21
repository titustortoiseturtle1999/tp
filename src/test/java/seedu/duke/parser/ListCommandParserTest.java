//package seedu.duke.parser;
//
//import org.junit.jupiter.api.Test;
//import seedu.duke.modules.ModuleList;
//import seedu.duke.universities.UniversityList;
//
//import java.text.ParseException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//public class ListCommandParserTest {
//
//    private static UniversityList universitySelectedList = new UniversityList();
//    private static ModuleList moduleSelectedList = new ModuleList();
//
//    @Test
//    public void test_emptyFlag_exceptionThrown() {
//        String flag = "";
//        ListCommandParser lcp = new ListCommandParser();
//        assertThrows(ParseException.class, () -> lcp.parse(flag, universitySelectedList, moduleSelectedList));
//    }
//
//}

package seedu.duke.parser;

import org.junit.jupiter.api.Test;
import seedu.duke.modules.ModuleList;
import seedu.duke.storage.ModuleStorage;
import seedu.duke.storage.UniversityStorage;
import seedu.duke.universities.UniversityList;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListCommandParserTest {

    private static UniversityList universitySelectedList = new UniversityList();
    private static ModuleList moduleSelectedList = new ModuleList();
    private static UniversityList universityMasterList;
    private static ModuleList moduleMasterList;

    static {
        try {
            moduleMasterList = new ModuleList(ModuleStorage.load());
            universityMasterList = new UniversityList(UniversityStorage.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_emptyFlag_exceptionThrown() {
        String flag = "";
        ListCommandParser lcp = new ListCommandParser();

        assertThrows(ParseException.class, () -> lcp.parse(flag, universitySelectedList,
                moduleSelectedList, universityMasterList, moduleMasterList));
    }

}
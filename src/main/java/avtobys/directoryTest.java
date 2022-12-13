package avtobys;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static avtobys.variable.*;

public class directoryTest extends webdriver{



    @Test(groups = "directory")
    public void listBuses()  {
        DirectoryElements dir = PageFactory.initElements(driver, DirectoryElements.class);

        dir.open("main");
        dir.clickMenu();


    }

}

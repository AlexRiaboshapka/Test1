package ui.cita;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.common.AbstractBaseTest;

import java.io.IOException;
import java.util.Iterator;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static helper.CsvHelper.parseCsv;

public class checkCitaIsAvailable extends AbstractBaseTest {
    private final String nie = "Z0126832S";
    private final String name = "Oleksandr Riaboshapka";
    private final String csvPath = "src/test/resources/datafiles/users.csv";
    public final String url = "https://icp.administracionelectronica.gob.es/icpco/acOpcDirect";

    @BeforeClass
    public void setUp() {
        open(url);
        citaPrevia.clickAccept();
    }
    @DataProvider
    public Iterator<Object[]> users() throws IOException {
        return parseCsv(csvPath);
    }
    @Test(dataProvider = "users")
    public void checkCitaIsAvailable(String nie, String name) {
        citaPrevia.selectRegionAndAccept();
        citaPrevia.selectCitaTypeAndAccept();
        citaPrevia.clickEnterButton();
        citaPrevia.inputNieAndClickAccept(nie, name);
        citaPrevia.clickEnterButton2();
        citaPrevia.getCitaInfo();
    }

    @AfterClass
    public void close() {
        closeWebDriver();
    }
}


package stepdefs;

import io.cucumber.java.*;

import java.util.Objects;

import static helper.Utility.quitDriver;
import static helper.Utility.startDriver;

public class Hooks {
    String tagsRunning = null;

    @BeforeAll
    public static void setUp() {
        System.out.println("Before All");
    }

    @AfterAll
    public static void tearDown() {
        System.out.println("After All");
    }

    @Before
    public void beforeTest(Scenario scenario) {
        System.out.println("Before Test");

        String[] tags = scenario.getSourceTagNames().toArray(new String[0]);
        tagsRunning = tags[0];
        if (Objects.equals(tagsRunning, "@web")) {
            startDriver();
        }
    }

    @After
    public void afterTest(Scenario scenario) throws InterruptedException {
        System.out.println("After Test");

        if (Objects.equals(tagsRunning, "@web")) {
            quitDriver();
        }
    }
}

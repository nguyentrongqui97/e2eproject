package e2eproject;

import java.util.Arrays;

import org.testng.TestNG;

public class TestNGRunner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestSuites(Arrays.asList("testng.xml"));
        testng.run();
    }
}

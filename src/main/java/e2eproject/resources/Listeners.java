package e2eproject.resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import e2eproject.base.CommonFunctions;

public class Listeners extends CommonFunctions implements ITestListener {

    public Listeners() throws IOException {
        super();
        //TODO Auto-generated constructor stub
    }

    @Override
      public  void onTestFailure(ITestResult result) {

        try {
            takeSnapShot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

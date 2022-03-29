package execution;

import java.io.IOException;

import logInPage.LoginTest;

public class ExecuteTestcase {

	public static void main(String[] args) throws IOException {
		
		LoginTest t = new LoginTest();
		t.loginSetUp();

	}

}

package runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class TestNGRunner {

	public static void main(String[] args) 
	{
		TestNG testNG = new TestNG();
		
		List<String> suites = new ArrayList<String>();
		suites.add("..\\UserInterfaceTesting.Framework.Puma\\testngrun1.xml");
		suites.add("..\\UserInterfaceTesting.Framework.Puma\\testngrun2.xml");
		suites.add("..\\UserInterfaceTesting.Framework.Puma\\testngrun3.xml");
		suites.add("..\\UserInterfaceTesting.Framework.Puma\\testngrun4.xml");
		suites.add("..\\UserInterfaceTesting.Framework.Puma\\testngrun5.xml");
		testNG.setTestSuites(suites);
		testNG.run();
	}
}

package factory;

import org.testng.annotations.Factory;

import tests.Sprint1Tests;
import tests.Sprint2Tests;
import tests.Sprint3Tests;
import tests.Sprint4Tests;
import tests.Sprint5Tests;

public class TestNGFactory 
{
    @Factory
    public Object[] factoryMethod() 
    {
        return new Object[] 
        	{ 
        		new Sprint1Tests(), 
        		new Sprint2Tests(),
        		new Sprint3Tests(),
        		new Sprint4Tests(),
        		new Sprint5Tests()
        	};
    }
}
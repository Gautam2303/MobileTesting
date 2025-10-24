package stepDefinitions;
import com.qa.BaseClass;
import io.cucumber.java.Before;
public class Hooks extends BaseClass{
	
  
	@Before
	public void setUp() {
		System.out.println("Launching browser...");
		launchAppium();
		
	}

}

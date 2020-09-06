package suppiler;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.WebElement;

public class Rules {

	private static Predicate<WebElement> isBlank = (e) -> e.getText().trim().length()==0;
	
	private static Predicate<WebElement> hasS = (e) -> e.getText().toLowerCase().contains("s");
	
	private static Predicate<WebElement> specialChar = (e) -> e.getText().toLowerCase().contains("?");
	
	public static List<Predicate<WebElement>> get() {
		
		List<Predicate<WebElement>> r = new ArrayList<>();
		r.add(isBlank);
		r.add(hasS);
		r.add(specialChar);
		
		return r;
		
		
		
	}
	
}

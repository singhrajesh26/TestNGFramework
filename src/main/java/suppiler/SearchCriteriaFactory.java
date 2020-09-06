package suppiler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import org.openqa.selenium.WebElement;

public class SearchCriteriaFactory {
	
	public static Predicate<List<WebElement>> allMale = (l)  -> l.get(1).getText().equalsIgnoreCase("male");
	public static Predicate<List<WebElement>> allFemale = (l)  -> l.get(1).getText().equalsIgnoreCase("female");		
	public static Predicate<List<WebElement>> allGender = allMale.or(allFemale);
	public static Predicate<List<WebElement>> allAU = (l)  -> l.get(2).getText().equalsIgnoreCase("AU");
	public static Predicate<List<WebElement>> fenaleAU = allFemale.and(allAU);
	public static final Map<String, Predicate<List<WebElement>>> MAP = new HashMap<>();
	
	static {
		MAP.put("allMale", allMale);
		MAP.put("allFemale", allFemale);
		MAP.put("allGender", allGender);
		MAP.put("allAU", allAU);
		MAP.put("fenaleAU", fenaleAU);
	}

	
	public static Predicate<List<WebElement>> getCriteria(String criteriaName){
		
		return MAP.get(criteriaName);
		
		
		
		
	}
	
}

package arogyasetu_application.utilities;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static String APP_URL="https://www.covid19india.org/";
	public static String CONFIRMED="Confirmed Cases : ";
	public static String ACTIVE="Active Cases : ";
	public static String RECOVERED="Recovered Cases : ";
	public static String DECEASED="Diceased Cases : ";
	
	public static List<String> getExpectedTopThreeStates() {
		List<String> actualTopThressStates = new ArrayList<>();
		actualTopThressStates.add("Uttar Pradesh");
		actualTopThressStates.add("Maharashtra");
		actualTopThressStates.add("Gujarat");
		return actualTopThressStates;
	}
}

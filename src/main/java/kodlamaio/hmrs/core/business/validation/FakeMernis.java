package kodlamaio.hmrs.core.business.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FakeMernis {

	public static boolean validate(String entity) {

		 String regex = "^[0-9]+$";
	     Pattern pattern = Pattern.compile(regex);
	     Matcher matcher = pattern.matcher(entity);
	     
		if(entity.length() > 11) {
			return false;
		}
		
		else if(matcher.matches() && !entity.startsWith("0")) {
			return true;
		}
		
		
		
		else {
			return false;
		}
		
	}
	
}

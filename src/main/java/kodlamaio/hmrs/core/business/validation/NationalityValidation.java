package kodlamaio.hmrs.core.business.validation;

public class NationalityValidation {

	public static boolean isRealPerson(String nationalityId) {	
		return FakeMernis.validate(nationalityId);
	}
	
}

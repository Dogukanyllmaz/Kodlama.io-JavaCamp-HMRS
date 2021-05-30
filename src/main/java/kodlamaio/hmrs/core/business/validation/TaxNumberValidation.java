package kodlamaio.hmrs.core.business.validation;

public class TaxNumberValidation {


	public static boolean isRealPerson(String taxNumber) {

		return FakeMernis.validate(taxNumber);
	}
	
}

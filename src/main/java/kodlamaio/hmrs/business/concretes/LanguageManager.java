package kodlamaio.hmrs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.LanguageService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.dataAccess.abstracts.LanguageDao;
import kodlamaio.hmrs.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	
	private LanguageDao languageDao;
	
	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	public DataResult<List<Language>> getAll() {
		return new SuccessDataResult<List<Language>>(this.languageDao.findAll(), "Languages listed succesfully.");
	}

	@Override
	public DataResult<Language> getById(int id) {
		return new SuccessDataResult<Language>(this.languageDao.findById(id).get(),"Language got succesfully.");
	}

	@Override
	public Result add(Language language) {
//		List<Character> degrees = List.of('1', '2', '3', '4', '5');
//		if (languageDegreeIsValid(degrees)) {
//			this.languageDao.save(language);
//			return new SuccessDataResult<Language>("Language added succesfully.");
//		} else {
//			return new ErrorDataResult<Language>("Invalid language degree.");
//		}
		this.languageDao.save(language);
		return new SuccessDataResult<Language>("Language added succesfully.");
	}

	@Override
	public Result delete(int id) {
		this.languageDao.deleteById(id);
		return new SuccessDataResult<Language>("Language deleted succesfully.");
	}

	@Override
	public Result update(Language language) {
		this.languageDao.save(language);
		return new SuccessDataResult<Language>("Language updated succesfully.");
	}
}

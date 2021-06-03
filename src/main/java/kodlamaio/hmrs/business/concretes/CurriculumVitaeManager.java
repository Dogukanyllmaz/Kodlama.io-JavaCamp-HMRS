package kodlamaio.hmrs.business.concretes;

import java.io.File;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hmrs.business.abstracts.CurriculumVitaeService;
import kodlamaio.hmrs.core.adapters.abstracts.CloudinaryUploadService;
import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.Result;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import kodlamaio.hmrs.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.hmrs.entities.concretes.CurriculumVitae;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {
	
	private CurriculumVitaeDao curriculumVitaeDao;
	private CloudinaryUploadService cloudinaryUploadService;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, CloudinaryUploadService cloudinaryUploadService) {
		this.curriculumVitaeDao = curriculumVitaeDao;
		this.cloudinaryUploadService = cloudinaryUploadService;
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll(),"Data Listelendi");
	}

	@Override
	public DataResult<CurriculumVitae> getById(int id) {
		return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.findById(id).get(),"Id'ye göre getirildi");
	}

	@Override
	public Result add(CurriculumVitae language) {
		this.curriculumVitaeDao.save(language);
		return new SuccessDataResult<CurriculumVitae>("Curriculum Vitae added succesfully.");
	}

	@Override
	public Result delete(int id) {
		this.curriculumVitaeDao.deleteById(id);
		return new SuccessDataResult<CurriculumVitae>("Curriculum Vitae deleted succesfully.");
	}

	@Override
	public Result update(CurriculumVitae language) {
		this.curriculumVitaeDao.save(language);
		return new SuccessDataResult<CurriculumVitae>("Curriculum Vitae updated succesfully.");
	}

	@Override
	public DataResult<String> uploadPhoto(@Valid Integer id, @Valid String filePath) {
		File file = new File(filePath);
		Object object = this.cloudinaryUploadService.upload(file).get("secure_url");
		if ((object == null)) {
			return new ErrorDataResult<String>("Failed to load photo! Not found image.", null);
			
		} else if (!this.curriculumVitaeDao.existsById(id)) {
			return new ErrorDataResult<String>("Failed to load photo! Not found curriculum vitae.", null);
		} else {
			String secure_url = object.toString();
			CurriculumVitae c = this.curriculumVitaeDao.findById(id).get();
			c.setPhotoLink(secure_url);
			this.update(c);
			return new SuccessDataResult<String>("Photo upload successfully.", secure_url);
		}
	}

	
}
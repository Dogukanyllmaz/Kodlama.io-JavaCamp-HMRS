package kodlamaio.hmrs.core.adapters.concretes;

import java.io.File;
import java.util.Map;

import org.springframework.stereotype.Service;

import kodlamaio.hmrs.core.adapters.abstracts.CloudinaryUploadService;
import kodlamaio.hmrs.externalServices.cloudinary.CloudinaryUpload;

@Service
public class CloudinaryUploadAdapter implements CloudinaryUploadService {

	@Override
	public Map<String, Object> upload(File file) {
		CloudinaryUpload cloudinaryUpload = new CloudinaryUpload();
		Map<String, Object> uploadResult = cloudinaryUpload.upload(file);
		return uploadResult;
	}

}
package kodlamaio.hmrs.externalServices.cloudinary;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryUpload {

	@SuppressWarnings("unchecked")
	public Map<String, Object> upload(File file) {
		Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				"cloud_name", "dy6ydxzuc",
				"api_key", "297517889212897",
				"api_secret", "D9rPKhfOM9jVwyab7ou3KkKlb_o"));
		try {
			@SuppressWarnings("rawtypes")
			Map params = ObjectUtils.asMap(
				    "public_id", "cv/photos/"+ file.hashCode(),
				    "overwrite", true,
				    "notification_url", null,
				    "resource_type", "image"         
				);
			Map<String, Object> uploadResult = cloudinary.uploader().upload(file, params);
			return uploadResult;
			//System.out.println(uploadResult.get("secure_url"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ObjectUtils.emptyMap();
	}
	
	
}

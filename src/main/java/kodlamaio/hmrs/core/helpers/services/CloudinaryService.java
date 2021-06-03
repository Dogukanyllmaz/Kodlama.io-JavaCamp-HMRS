package kodlamaio.hmrs.core.helpers.services;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import kodlamaio.hmrs.core.utilities.results.ErrorDataResult;
import kodlamaio.hmrs.core.utilities.results.SuccessDataResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService implements FileUploadService{

    private Cloudinary cloudinary;

    @PostConstruct()
    private void initCloudinary() {
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "your Cloud Name",
                "api_key", "your Api Key",
                "api_secret", "your Api Secret"
        ));
    }

    @SuppressWarnings("rawtypes")
    @Override
    public DataResult<Map> saveFile(MultipartFile file) {
        Map uploadResult = null;
        try{
            uploadResult = this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
        }catch(IOException exception){
            return new ErrorDataResult<Map>("Hata Oluştu: " + exception.getLocalizedMessage());
        }
        if (uploadResult == null){
            return new ErrorDataResult<Map>(uploadResult, "Resim Eklenemedi: ");
        }
        return new SuccessDataResult<Map>(uploadResult, "Resim Ekleme Başarılı");
    }


}

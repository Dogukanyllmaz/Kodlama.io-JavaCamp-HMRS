package kodlamaio.hmrs.core.helpers.services;

import kodlamaio.hmrs.core.utilities.results.DataResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface FileUploadService {

    DataResult<Map> saveFile(MultipartFile file);

}

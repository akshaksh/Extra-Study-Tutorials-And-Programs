package springbootajax;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class RestUploadFileController {

	//Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "D:\\temp\\";
    
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PostMapping("/api/upload/multi")
	public ResponseEntity<?> uploadFiles(@RequestParam("files") MultipartFile[] files) throws IOException{
		
		// Get file name
        String uploadedFileName = Arrays.stream(files).map(x -> x.getOriginalFilename())
                .filter(x -> !StringUtils.isEmpty(x)).collect(Collectors.joining(" , "));
		if(uploadedFileName.isEmpty() || null==uploadedFileName || uploadedFileName.length()<1){
			return new ResponseEntity("please select a file!", HttpStatus.OK);
		}
		else{
			for(int i=0;i<files.length;i++){
				byte bytes[]=files[i].getBytes();
				Path path = Paths.get(UPLOADED_FOLDER + files[i].getOriginalFilename());
	            Files.write(path, bytes);
			}
			return new ResponseEntity(uploadedFileName+"files uploaded successfully", HttpStatus.OK);
		}
	}
	
}

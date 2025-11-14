package ir.najaftech.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileHandler {

	@Value("${upload.path:./uploads}")
	private String uploadDir;

	public String saveFile(MultipartFile file) throws IOException {
		System.out.println("Attempting file upload to directory: " + uploadDir);
		if (file != null && !file.getOriginalFilename().isEmpty()) {

			File uploadDirectory = new File(uploadDir);

			if (!uploadDirectory.exists()) {

				uploadDirectory.mkdir();

			}

			String uuidFile = UUID.randomUUID().toString();

			String resultFilename = uuidFile + "." + file.getOriginalFilename();

			File destination = new File(uploadDirectory, resultFilename);

			// Use InputStream to copy the file - THIS IS THE KEY FIX
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destination.toPath(), StandardCopyOption.REPLACE_EXISTING);
			}

			return resultFilename;
		}
		return null;
	}
}

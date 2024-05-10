 package com.example.demo.contents;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

	@Value("${spring.servlet.multipart.location}")
	private String uploadDir;


	@GetMapping("/videos/{videoName}")
			//   jsp맵핑 네임 / 비디오 이름                           // 비디오 이름 가져옴
	public ResponseEntity<Resource> getVideo(@PathVariable String videoName) throws IOException {
		Path videoPath = Paths.get(uploadDir).resolve(videoName);
		
		
		Resource resource = new org.springframework.core.io.UrlResource(videoPath.toUri());

		if (resource.exists()) {
			return ResponseEntity.ok()
					.contentType(MediaType.parseMediaType("video/mp4"))
					.body(resource);
		} else {
			return ResponseEntity.notFound().build();
		}
	} 
	
	
   @GetMapping("/images/{imageName}")
    public ResponseEntity<Resource> getImage(@PathVariable String imageName) throws IOException {
        Path imagePath = Paths.get(uploadDir).resolve(imageName);
        Resource resource = new org.springframework.core.io.UrlResource(imagePath.toUri());

        if (resource.exists()) {
            return ResponseEntity.ok()
                    .contentType(org.springframework.http.MediaType.IMAGE_JPEG)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
}
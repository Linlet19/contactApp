package com.hostmdy.contact.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {

	void saveContactImageToDB(Long contactId,MultipartFile imageFile) throws IOException;
}

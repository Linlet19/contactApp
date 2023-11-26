package com.hostmdy.contact.service.impl;

import java.io.IOException;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hostmdy.contact.entites.Contact;
import com.hostmdy.contact.repository.ContactRepository;
import com.hostmdy.contact.service.ImageService;


@Service
public class ImageServiceImpl implements ImageService{

	private final ContactRepository contactRepository;
	
	public ImageServiceImpl(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	@Override
	public void saveContactImageToDB(Long contactId, MultipartFile imageFile) throws IOException {
		// TODO Auto-generated method stub
		Optional<Contact> contactOpt = contactRepository.findById(contactId);
		if(contactOpt.isEmpty()) {
			throw new NullPointerException("contactId is not found in contact table");
		}
		
		Contact contact = contactOpt.get();
		Byte[] imageBytes = new Byte[imageFile.getBytes().length];
		int i = 0;
		for(final Byte b : imageFile.getBytes()) {
			imageBytes[i++] = b;
		}
		
		contact.setImage(imageBytes);
		contactRepository.save(contact);
	}

}

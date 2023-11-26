package com.hostmdy.contact.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hostmdy.contact.entites.Contact;
import com.hostmdy.contact.service.ContactService;
import com.hostmdy.contact.service.ImageService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/image")
public class ImageController {

	private final ImageService imageService;
	private final ContactService contactService;
	
	public ImageController(ImageService imageService, ContactService contactService) {
		super();
		this.imageService = imageService;
		this.contactService = contactService;
	}
	
	@GetMapping("/contact/{contactId}/upload")
	public String uploadContactImageForm(@PathVariable Long contactId,Model model) {
		model.addAttribute("contactId",contactId);
		return "image-upload";
	}
	
	@PostMapping("/contact/{contactId}/upload")
	public String uploadContactImage(@PathVariable Long contactId,@RequestParam MultipartFile imagefile) throws IOException {
		imageService.saveContactImageToDB(contactId, imagefile);
		return "redirect:/contact/"+contactId+"/show";
	}
	
	@GetMapping("/contact/{contactId}/show")
	public void showContactImage(@PathVariable Long contactId,HttpServletResponse response) {
		Optional<Contact> contactOpt = contactService.getContactById(contactId);
		if(contactOpt.isEmpty()) {
			throw new RuntimeException("contact is not found");
		}
		
		Contact contact = contactOpt.get();
		byte[] imageBytes = new byte[contact.getImage().length];
		
		int i = 0;
		for(final byte b : contact.getImage()) {
			imageBytes[i++] = b;
		}
		InputStream is = new ByteArrayInputStream(imageBytes);
		
		response.setContentType("image/jpeg");
		try {
			IOUtils.copy(is, response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

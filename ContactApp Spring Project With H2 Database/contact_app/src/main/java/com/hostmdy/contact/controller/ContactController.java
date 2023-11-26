package com.hostmdy.contact.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hostmdy.contact.entites.Contact;
import com.hostmdy.contact.entites.Note;
import com.hostmdy.contact.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	private final ContactService contactService;

	public ContactController(ContactService contactService) {
		super();
		this.contactService = contactService;
	}
	
	@GetMapping("/showall")
	public String showAllContacts(Model model) {
		model.addAttribute("contacts",contactService.getAllContacts());
		return "show-all";
	}
	
	@GetMapping("/{contactId}/show")
	public String showContactDetails(@PathVariable Long contactId, Model model) {
		Optional<Contact> contactOpt = contactService.getContactById(contactId);
		if(contactOpt.isEmpty()) {
			throw new NullPointerException("contact is not found!");
		}
		model.addAttribute("contact", contactOpt.get());
		return "contact-details";
	}
	
	@GetMapping("/add")
	public String addContactForm(Model model) {

		Contact contact = new Contact();
		contact.setNote(new Note());
		model.addAttribute("contact", contact);
		return "add-contact";
	}
	
	@PostMapping("/new")
	public String addContact(@ModelAttribute Contact contact) {
		
		Contact createdContact = contactService.createContact(contact);
		System.out.println("### contact with id = " + createdContact.getId() + " is created");
		return "redirect:/contact/showall";
	}
	
	@GetMapping("/{contactId}/update")
	public String updateContactForm(@PathVariable Long contactId, Model model) {

		Optional<Contact> contactOpt = contactService.getContactById(contactId);
		if(contactOpt.isEmpty()) {
			throw new NullPointerException("contact is not found!");
		}
		model.addAttribute("contact", contactOpt.get());
		return "add-contact";
	}
	
	@GetMapping("/{contactId}/delete")
	public String deleteContact(@PathVariable Long contactId) {
		contactService.deleteContactById(contactId);
		
		return "redirect:/contact/showall";
	}
}

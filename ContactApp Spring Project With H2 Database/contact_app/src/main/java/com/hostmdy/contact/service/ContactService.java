package com.hostmdy.contact.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.contact.entites.Contact;

public interface ContactService {

	Contact saveContact(Contact contact);
	
	Contact createContact(Contact contact);
	
	List<Contact> getAllContacts();
	
	Optional<Contact> getContactById(Long contactId);
	
	Optional<Contact> getContactByName(String name);
	
	List<Contact> getAllContactByNickname(String nickname);
	
	void deleteContactById(Long contactId);
}

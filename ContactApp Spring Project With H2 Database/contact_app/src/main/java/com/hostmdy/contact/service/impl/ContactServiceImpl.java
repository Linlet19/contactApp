package com.hostmdy.contact.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.contact.entites.Contact;
import com.hostmdy.contact.repository.ContactRepository;
import com.hostmdy.contact.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{

	private final ContactRepository contactRepository;
	
	public ContactServiceImpl(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	@Override
	public Contact saveContact(Contact contact) {
		// TODO Auto-generated method stub
		return contactRepository.save(contact);
	}

	@Override
	public Contact createContact(Contact contact) {
		// TODO Auto-generated method stub
		return saveContact(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		// TODO Auto-generated method stub
		return (List<Contact>) contactRepository.findAll();
	}

	@Override
	public Optional<Contact> getContactById(Long contactId) {
		// TODO Auto-generated method stub
		return contactRepository.findById(contactId);
	}

	@Override
	public Optional<Contact> getContactByName(String name) {
		// TODO Auto-generated method stub
		return contactRepository.findByName(name);
	}

	@Override
	public List<Contact> getAllContactByNickname(String nickname) {
		// TODO Auto-generated method stub
		return contactRepository.findByNickname(nickname);
	}

	@Override
	public void deleteContactById(Long contactId) {
		// TODO Auto-generated method stub
		contactRepository.deleteById(contactId);
	}

}

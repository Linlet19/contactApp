package com.hostmdy.contact.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.contact.entites.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long>{

	Optional<Contact> findByName(String name);
	
	List<Contact> findByNickname(String nickname);
}

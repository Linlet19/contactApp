package com.hostmdy.contact.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.hostmdy.contact.entites.Contact;
import com.hostmdy.contact.entites.Note;
import com.hostmdy.contact.repository.ContactRepository;

@Component
public class ContactBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	public ContactRepository contactRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		contactRepository.saveAll(createContact());
	}
	
	private List<Contact> createContact(){
		
		Contact contact = new Contact();
		contact.setName("LaLisa Manoban");
		contact.setNickname("Lisa");
		contact.setWork("Kpop Artist");
		contact.setEmail("lisa@gmail.com");
		contact.setPhone("82 77 9687 1234");
		Note note = new Note();
		note.setNote("Lalisa Manobal (birth name: Pranpriya Manobal, born March 27, 1997 in Buriram Province, Thailand) better known by her stage name, ");
		//contact - note
		contact.setNote(note);
		
		Contact contact1 = new Contact();
		contact1.setName("Jacques Bermon Webster II");
		contact1.setNickname("Travis Scott");
		contact1.setWork("American rapper");
		contact1.setEmail("travisscott@gmail.com");
		contact1.setPhone("(555) 555-1234");
		Note note1 = new Note();
		note1.setNote("Jacques Bermon Webster II (born April 30, 1991), known professionally as Travis Scott (formerly stylized Travi$ Scott), is an American rapper, singer, songwriter, and record producer. Throughout his career, Scott has achieved four number-one hits on the US Billboard Hot 100 chart, along with a total of eighty charted songs. ");
		
		//contact - note
		contact1.setNote(note1);
		
		Contact contact2 = new Contact();
		contact2.setName("Oleksandr Olehovych Kostyliev");
		contact2.setNickname("s1mple");
		contact2.setWork("Professional Counter-Strike: Global Offensive player");
		contact2.setEmail("simpleawper@gmail.com");
		contact2.setPhone("7911 123456");
		Note note2 = new Note();
		note2.setNote("Oleksandr Olehovych Kostyliev[a] (born 2 October 1997), better known as s1mple, is a Ukrainian professional Counter-Strike: Global Offensive player for Natus Vincere.[2] He is considered to be one of the best players in Global Offensive history.");
		
		//contact - note
		contact2.setNote(note2);
		
		Contact contact3 = new Contact();
		contact3.setName("Hajime Isayama");
		contact3.setNickname("Isayama");
		contact3.setWork("Manga Artist");
		contact3.setEmail("aot123@gmail.com");
		contact3.setPhone("(03) 1234-5678");
		Note note3 = new Note();
		note3.setNote("Hajime Isayama (諫山 創, Isayama Hajime, born August 29, 1986) is a Japanese manga artist. His first series, Attack on Titan (2009–2021), became one of the best-selling manga series of all time with 110 million copies in circulation as of September 2022.[2]");
		
		//contact - note
		contact3.setNote(note3);
		
		Contact contact4 = new Contact();
		contact4.setName("Johan Sundstein");
		contact4.setNickname("N0tail");
		contact4.setWork("Professional Dota 2 player");
		contact4.setEmail("notail@gmail.com");
		contact4.setPhone("70 10 11 55 ");
		Note note4 = new Note();
		note4.setNote("Johan Sundstein (born 8 October 1993), better known as N0tail, is a Danish and Faroese professional Dota 2 player for OG. As a member of OG, he has played in four iterations of The International, winning in 2018 and 2019, and has also won four Major championships.");
		
		//contact - note
		contact4.setNote(note4);
		
		Contact contact5 = new Contact();
		contact5.setName("Barack Hussein Obama II");
		contact5.setNickname("Obama");
		contact5.setWork(" 44th president of the United States");
		contact5.setEmail("obama123@gmail.com");
		contact5.setPhone("(555) 123-7869");
		Note note5 = new Note();
		note5.setNote("Barack Hussein Obama II (/bəˈrɑːk huːˈseɪn oʊˈbɑːmə/ ⓘ bə-RAHK hoo-SAYN oh-BAH-mə;[1] born August 4, 1961) is an American politician who served as the 44th president of the United States from 2009 to 2017. A member of the Democratic Party, he was the first African-American president. Obama previously served as a U.S. senator representing Illinois from 2005 to 2008, as an Illinois state senator from 1997 to 2004, and as a civil rights lawyer and university lecturer.");
		
		//contact - note
		contact5.setNote(note5);
		
		Contact contact6 = new Contact();
		contact6.setName("Lay Phyu");
		contact6.setNickname("လေးဖြူ");
		contact6.setWork("Singer");
		contact6.setEmail("layphyu007@gmail.com");
		contact6.setPhone("09-783495041");
		Note note6 = new Note();
		note6.setNote("Lay Phyu (Burmese, pronounced [lé bjù]; born 19 May 1965) is a Burmese rock star and guitarist. He is the lead vocalist of the rock band Iron Cross. Lay is considered the most commercially successful male singer in the history of Burmese rock music.");
		
		//contact - note
		contact6.setNote(note6);
		List<Contact> contacts = new ArrayList<>();
		contacts.add(contact);
		contacts.add(contact1);
		contacts.add(contact2);
		contacts.add(contact3);
		contacts.add(contact4);
		contacts.add(contact5);
		contacts.add(contact6);
		return contacts;
	}
}

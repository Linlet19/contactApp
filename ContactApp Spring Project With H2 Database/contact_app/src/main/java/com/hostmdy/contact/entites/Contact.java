package com.hostmdy.contact.entites;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String nickname;
	private String work;
	private String email;
	private String phone;
	
	@Lob
	private Byte[] image;

	//@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime createdAt;//DateTime
	private LocalDateTime updatedAt;
		
	//One way
	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name = "note_id")
	private Note note;
		
	@PrePersist
	void onCreate() {
		this.createdAt = LocalDateTime.now();
	}
	
	@PreUpdate
	void onUpdate() {
		this.updatedAt = LocalDateTime.now();
	}
	
	public Contact() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Byte[] getImage() {
		return image;
	}

	public void setImage(Byte[] image) {
		this.image = image;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Note getNote() {
		return note;
	}

	public void setNote(Note note) {
		this.note = note;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(image);
		result = prime * result + Objects.hash(email, id, name, nickname, phone, work);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Arrays.equals(image, other.image)
				&& Objects.equals(name, other.name) && Objects.equals(nickname, other.nickname)
				&& Objects.equals(phone, other.phone) && Objects.equals(work, other.work);
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", nickname=" + nickname + ", work=" + work + ", email=" + email
				+ ", phone=" + phone + ", image=" + Arrays.toString(image) + "]";
	}

	
	
}

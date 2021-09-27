package com.example.customcontrollerarguments;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "publisherId")
	private Integer publisherId;
	
	@Column(name = "publisherName" , length = 1000)
	private String publisherName;
	
	@Column(name = "publisherType" , length = 10)
	private String  publisherType;
	
	@OneToOne
	private Publisher parentPublisher;
	
	@JsonManagedReference
	@Column(name = "books")
	@OneToMany(mappedBy = "publisher", orphanRemoval = false, cascade = CascadeType.ALL)
	private List<Book> books;

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public String getPublisherType() {
		return publisherType;
	}

	public void setPublisherType(String publisherType) {
		this.publisherType = publisherType;
	}

	public Publisher getParentPublisher() {
		return parentPublisher;
	}

	public void setParentPublisher(Publisher parentPublisher) {
		this.parentPublisher = parentPublisher;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}


}

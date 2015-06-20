package com.brassappmanager.persistence.entities;

// Generated Jun 20, 2015 11:05:54 PM by Hibernate Tools 4.3.1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Book generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "book", schema = "public")
@SequenceGenerator(name = "book_seq", sequenceName = "book_id_seq")
public class Book implements java.io.Serializable {

	private long id;
	private Currency currency;
	private Department department;
	private String number;
	private BigDecimal price;
	private Set<Person> persons = new HashSet<>(0);

	public Book() {
	}

	public Book(Currency currency, Department department,
			String number, BigDecimal price) {
		this.currency = currency;
		this.department = department;
		this.number = number;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq")
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "currency_id")
	public Currency getCurrency() {
		return this.currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "number", length = 45)
	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Column(name = "price", precision = 6)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "person_book", schema = "public", joinColumns = { @JoinColumn(name = "book_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "person_id", nullable = false, updatable = false) })
	public Set<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

}
package com.malicia.mrg.customer.domain.aggregate;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private Integer id;

	@Column
	private String name;
	@Column
	private String company;
	@Column
	private double expanse;
    public Customer() {
    }

	public Customer(Integer id, String name, String company, double expanse) {
		this.id = id;
		this.name = name;
		this.company = company;
		this.expanse = expanse;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getExpanse() {
		return expanse;
	}

	public void setExpanse(double expanse) {
		this.expanse = expanse;
	}
}

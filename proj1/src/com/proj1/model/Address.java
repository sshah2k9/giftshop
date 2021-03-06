package com.proj1.model;
// Generated Dec 3, 2015 10:04:36 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Address generated by hbm2java
 */
@Entity
@Table(name = "address", catalog = "giftshop")
public class Address implements java.io.Serializable {

	private Integer addressId;
	private String recipient;
	private String areaDetails;
	private String city;
	private String state;
	private String pin;
	private String phoneNumber;
	private Set<DeliveryDetails> deliveryDetailses = new HashSet<DeliveryDetails>(0);
	private Set<User> users = new HashSet<User>(0);

	public Address() {
	}

	public Address(String pin) {
		this.pin = pin;
	}

	public Address(String recipient, String areaDetails, String city, String state, String pin, String phoneNumber,
			Set<DeliveryDetails> deliveryDetailses, Set<User> users) {
		this.recipient = recipient;
		this.areaDetails = areaDetails;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.phoneNumber = phoneNumber;
		this.deliveryDetailses = deliveryDetailses;
		this.users = users;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "address_id", unique = true, nullable = false)
	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Column(name = "recipient", length = 50)
	public String getRecipient() {
		return this.recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	@Column(name = "area_details", length = 200)
	public String getAreaDetails() {
		return this.areaDetails;
	}

	public void setAreaDetails(String areaDetails) {
		this.areaDetails = areaDetails;
	}

	@Column(name = "city", length = 100)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", length = 50)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "pin", nullable = false, length = 10)
	public String getPin() {
		return this.pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Column(name = "phone_number", length = 15)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	public Set<DeliveryDetails> getDeliveryDetailses() {
		return this.deliveryDetailses;
	}

	public void setDeliveryDetailses(Set<DeliveryDetails> deliveryDetailses) {
		this.deliveryDetailses = deliveryDetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}

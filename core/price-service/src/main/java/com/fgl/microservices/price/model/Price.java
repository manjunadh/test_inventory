package com.fgl.microservices.price.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "price")
public class Price {
	@Id
	private String id;
	private String skuId;
	private int originalPrice;
	private int offerPrice;
	private Date offerStartDate;
	private Date offerEndPrice;

	public Price() {

	}

	public Price(String id, String skuId, int originalPrice, int offerPrice, Date offerStartDate, Date offerEndPrice) {
		super();
		this.id = id;
		this.skuId = skuId;
		this.originalPrice = originalPrice;
		this.offerPrice = offerPrice;
		this.offerStartDate = offerStartDate;
		this.offerEndPrice = offerEndPrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public int getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(int originalPrice) {
		this.originalPrice = originalPrice;
	}

	public int getOfferPrice() {
		return offerPrice;
	}

	public void setOfferPrice(int offerPrice) {
		this.offerPrice = offerPrice;
	}

	public Date getOfferStartDate() {
		return offerStartDate;
	}

	public void setOfferStartDate(Date offerStartDate) {
		this.offerStartDate = offerStartDate;
	}

	public Date getOfferEndPrice() {
		return offerEndPrice;
	}

	public void setOfferEndPrice(Date offerEndPrice) {
		this.offerEndPrice = offerEndPrice;
	}

}

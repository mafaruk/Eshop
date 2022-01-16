package com.mak.shop.eshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prodId;
	private String prodTitle;
	private String prodBrand;

	@Column(length = 500)
	private String prodDesc;
	private String prodImage;
	private double prodPrice;
	private double prodDisc;
	private int prodQuantity;

	@ManyToOne
	private SubCategory subCatId;

	public Product() {
	}

	public Product(int prodId, String prodTitle, String prodBrand, String prodDesc, String prodImage, double prodPrice,
			double prodDisc, int prodQuantity, SubCategory subCatId) {
		this.prodId = prodId;
		this.prodTitle = prodTitle;
		this.prodBrand = prodBrand;
		this.prodDesc = prodDesc;
		this.prodImage = prodImage;
		this.prodPrice = prodPrice;
		this.prodDisc = prodDisc;
		this.prodQuantity = prodQuantity;
		this.subCatId = subCatId;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdTitle() {
		return prodTitle;
	}

	public void setProdTitle(String prodTitle) {
		this.prodTitle = prodTitle;
	}

	public String getProdBrand() {
		return prodBrand;
	}

	public void setProdBrand(String prodBrand) {
		this.prodBrand = prodBrand;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public String getProdImage() {
		return prodImage;
	}

	public void setProdImage(String prodImage) {
		this.prodImage = prodImage;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public double getProdDisc() {
		return prodDisc;
	}

	public void setProdDisc(double prodDisc) {
		this.prodDisc = prodDisc;
	}

	public int getProdQuantity() {
		return prodQuantity;
	}

	public void setProdQuantity(int prodQuantity) {
		this.prodQuantity = prodQuantity;
	}

	public SubCategory getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(SubCategory subCatId) {
		this.subCatId = subCatId;
	}

}

package com.mak.shop.eshop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int catId;
	private String catTitle;
	
	@Column(length = 500)
	private String catDescription; 
	
	@OneToMany(mappedBy = "catId", cascade = CascadeType.ALL)
	private List<SubCategory> subCatgory; 

	public Category() {

	}

	public Category(int catId, String catTitle, String catDescription, List<SubCategory> subCatgory) {
		this.catId = catId;
		this.catTitle = catTitle;
		this.catDescription = catDescription;
		this.subCatgory = subCatgory;
	}

	public int getCatId() {
		return catId;
	}

	public void setCatId(int catId) {
		this.catId = catId;
	}

	public String getCatTitle() {
		return catTitle;
	}

	public void setCatTitle(String catTitle) {
		this.catTitle = catTitle;
	}

	public String getCatDescription() {
		return catDescription;
	}

	public void setCatDescription(String catDescription) {
		this.catDescription = catDescription;
	}

	public List<SubCategory> getSubCatgory() {
		return subCatgory;
	}

	public void setSubCatgory(List<SubCategory> subCatgory) {
		this.subCatgory = subCatgory;
	}

	
	
	
	
}

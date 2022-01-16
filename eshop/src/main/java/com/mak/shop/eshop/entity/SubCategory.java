package com.mak.shop.eshop.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SubCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subCatId;

	@ManyToOne
	private Category catId;
	private String subCatTitle;

	@Column(length = 500)
	private String subCatDescription;

	@OneToMany(mappedBy = "subCatId", cascade = CascadeType.ALL)
	private List<Product> subCatgory;

	public SubCategory() {
	}

	public SubCategory(int subCatId, Category catId, String subCatTitle, String subCatDescription,
			List<Product> subCatgory) {
		this.subCatId = subCatId;
		this.catId = catId;
		this.subCatTitle = subCatTitle;
		this.subCatDescription = subCatDescription;
		this.subCatgory = subCatgory;
	}

	public int getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(int subCatId) {
		this.subCatId = subCatId;
	}

	public Category getCatId() {
		return catId;
	}

	public void setCatId(Category catId) {
		this.catId = catId;
	}

	public String getSubCatTitle() {
		return subCatTitle;
	}

	public void setSubCatTitle(String subCatTitle) {
		this.subCatTitle = subCatTitle;
	}

	public String getSubCatDescription() {
		return subCatDescription;
	}

	public void setSubCatDescription(String subCatDescription) {
		this.subCatDescription = subCatDescription;
	}

	public List<Product> getSubCatgory() {
		return subCatgory;
	}

	public void setSubCatgory(List<Product> subCatgory) {
		this.subCatgory = subCatgory;
	}

}

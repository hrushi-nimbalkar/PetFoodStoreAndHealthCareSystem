package com.spring.pet.dto;

import javax.persistence.Column;


public class ProductDTO {
	
	@Column
	private Long id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="category")
	private int categoryId;
	
	@Column(name="price")
	private double price;

	@Column(name="description")
	private String description;

	@Column(name="image_name")
	private String imageName;
	
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", categoryId=" + categoryId + ", price=" + price
				+ ", description=" + description + ", imageName=" + imageName + "]";
	}

}

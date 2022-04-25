package com.spring.pet.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "roles")
	public class Role {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Integer id;
		
		
		@Column(nullable = false , unique = true)
		@NotEmpty
		private String name;
		
		
		
		public String getName() {
			return name;
		}

		@Override
		public String toString() {
			return "Role [id=" + id + ", name=" + name + ", users=" + users + "]";
		}

		public void setName(String name) {
			this.name = name;
		}

		@ManyToMany(mappedBy= "roles")
		private List<User> users;
		
	}



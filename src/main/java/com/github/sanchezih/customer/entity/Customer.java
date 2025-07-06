package com.github.sanchezih.customer.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "tbl_customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "El numero de documento no puede ser vacio")
	@Size(min = 8, max = 8, message = "El tamanio del numero de documento es 8")
	@Column(name = "number_id", unique = true, length = 8, nullable = false)
	private String numberID;

	@NotEmpty(message = "El nombre no puede ser vacio")
	@Column(name = "first_name", nullable = false)
	private String firstName;

	@NotEmpty(message = "El apellido no puede ser vacio")
	@Column(name = "last_name", nullable = false)
	private String lastName;

	@NotEmpty(message = "El correo no puede estar vacio")
	@Email(message = "No es un direccion de correo bien formada")
	@Column(unique = true, nullable = false)
	private String email;

	@Column(name = "photo_url")
	private String photoUrl;

	@NotNull(message = "La region no puede ser vacia")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Region region;

	private String state;
}
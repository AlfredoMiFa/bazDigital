package com.baz.digital.model;

import javax.validation.constraints.NotNull;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "citas")
@JsonPropertyOrder({"id","personaVisita","asunto","dia","estado","hora","duracion","ubicacion"})

public class Cita {

	@Id
	@NotNull
	@ApiModelProperty(value="El id del usuario en hexadecimal", required = true)
	private ObjectId id;
	@NotNull
	@ApiModelProperty(value="Persona con la que acudira a cita", required = true)
	private String personaVisita;
	@NotNull
	@ApiModelProperty(value="Asunto por el que acude", required = true)
	private String asunto;
	@NotNull
	@ApiModelProperty(value="Dia en el que agenda la cita", required = true)
	private String dia;
	@NotNull
	@ApiModelProperty(value="Estado en el que se encuntra la cita", required = true)
	private String estado;
	@NotNull
	@ApiModelProperty(value="Hora en la que se llevara acabo la cita", required = true)
	private String hora;
	@ApiModelProperty(value="Tiempo estimado de la cita, puede ser omitido", required = false)
	private String duracion;
	@NotNull
	@ApiModelProperty(value="Lugar en el cual se llevara acabo la cita", required = true)
	private String ubicacion;
	
	public Cita() {
		
	}

	public Cita(ObjectId id, String personaVisita, String asunto, String dia, String estado, String hora,
			String duracion, String ubicacion) {
		super();
		this.id = id;
		this.personaVisita = personaVisita;
		this.asunto = asunto;
		this.dia = dia;
		this.estado = estado;
		this.hora = hora;
		this.duracion = duracion;
		this.ubicacion = ubicacion;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getPersonaVisita() {
		return personaVisita;
	}

	public void setPersonaVisita(String personaVisita) {
		this.personaVisita = personaVisita;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	@Override
	public String toString() {
		return "Cita [id=" + id + ", personaVisita=" + personaVisita + ", asunto=" + asunto + ", dia=" + dia
				+ ", estado=" + estado + ", hora=" + hora + ", duracion=" + duracion + ", ubicacion=" + ubicacion + "]";
	}
	
}

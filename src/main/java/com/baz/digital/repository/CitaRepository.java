package com.baz.digital.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

import com.baz.digital.model.Cita;


public interface CitaRepository {

	Optional<List<Cita>> findAll();
	Optional<Cita> findOne(ObjectId id);
	public Cita saveCita(Cita cita);
	public void updateCita(Cita cita);
	public void deleteUser(ObjectId id);
	
}

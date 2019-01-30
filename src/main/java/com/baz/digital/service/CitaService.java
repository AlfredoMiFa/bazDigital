package com.baz.digital.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.baz.digital.exception.CitaNotFoundException;
import com.baz.digital.model.Cita;

public interface CitaService {

	List<Cita> findAll();
	Cita findByCitaId(ObjectId id) throws CitaNotFoundException;
	Cita saveCita(Cita cita);
	void updateCita(Cita cita);
	void deleteCita(ObjectId id);
	
}

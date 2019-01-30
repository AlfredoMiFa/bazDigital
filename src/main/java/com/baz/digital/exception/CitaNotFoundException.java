package com.baz.digital.exception;

import org.bson.types.ObjectId;

public class CitaNotFoundException extends Exception {

	public CitaNotFoundException(ObjectId id) {
		super(String.format("Cita con el id '%s' no encontrada", id));
	}
	
}

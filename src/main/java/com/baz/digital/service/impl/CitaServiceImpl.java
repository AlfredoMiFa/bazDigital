package com.baz.digital.service.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baz.digital.exception.CitaNotFoundException;
import com.baz.digital.model.Cita;
import com.baz.digital.repository.CitaRepository;
import com.baz.digital.service.CitaService;

@Service("citaService")
@Transactional
public class CitaServiceImpl implements CitaService {

	@Autowired
	private CitaRepository citaRepository;
	
	public CitaServiceImpl(CitaRepository citaRepository) {
		this.citaRepository=citaRepository;
	}
	
	@Override
	public List<Cita> findAll() {
		Optional<List<Cita>> cita = citaRepository.findAll();
		return cita.get();
	}

	@Override
	public Cita findByCitaId(ObjectId id) throws CitaNotFoundException {
		Optional<Cita> cita = citaRepository.findOne(id);
		if(cita.isPresent()) {
			return cita.get();
		}
		throw new CitaNotFoundException(id);
	}

	@Override
	public Cita saveCita(Cita cita) {
		return citaRepository.saveCita(cita);
	}

	@Override
	public void updateCita(Cita cita) {
		citaRepository.updateCita(cita);
	}

	@Override
	public void deleteCita(ObjectId id) {
		citaRepository.deleteUser(id);
	}

}

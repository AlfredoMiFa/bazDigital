package com.baz.digital.repository.impl;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.baz.digital.model.Cita;
import com.baz.digital.repository.CitaRepository;

@Repository
public class CitaRepositoryImpl implements CitaRepository{
	
	@Autowired
	private final MongoOperations mongoOperations;
	
	@Autowired
	public CitaRepositoryImpl(MongoOperations mongoOperations) {
		Assert.notNull(mongoOperations);
		this.mongoOperations=mongoOperations;
	}

	@Override
	public Optional<List<Cita>> findAll() {
		List<Cita> list = this.mongoOperations.find(new Query(), Cita.class);
		Optional<List<Cita>> optionalCita = Optional.ofNullable(list);
		return optionalCita;
	}

	@Override
	public Optional<Cita> findOne(ObjectId id) {
		Cita cita = this.mongoOperations.findOne(new Query(Criteria.where("id").is(id)), Cita.class);
		Optional<Cita> next = Optional.ofNullable(cita);
		return next;
	}

	@Override
	public Cita saveCita(Cita cita) {
		this.mongoOperations.save(cita);
		return findOne(cita.getId()).get();
	}

	@Override
	public void updateCita(Cita cita) {
		this.mongoOperations.save(cita);		
	}

	@Override
	public void deleteUser(ObjectId id) {
		this.mongoOperations.findAndRemove(new Query(Criteria.where("id").is(id)), Cita.class);
	}

}

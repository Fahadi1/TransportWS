package fr.eql.al35.wsrest.transport.dao;

import org.springframework.data.repository.CrudRepository;

import fr.eql.al35.wsrest.transport.entity.Tarif;

public interface TarifDao extends CrudRepository<Tarif, Integer> {

}

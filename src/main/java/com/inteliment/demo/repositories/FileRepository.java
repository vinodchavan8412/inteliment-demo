package com.inteliment.demo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.inteliment.demo.models.Storage;

public interface FileRepository  extends CrudRepository<Storage, Long> {
	 List<Storage> findByType(String type);

}

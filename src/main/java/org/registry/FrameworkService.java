package org.registry;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FrameworkService {

	@Autowired
	private FrameworkRepository repository;
	
	public List<Framework> listAll() {
		return repository.findAll();
	}
	
	public void save(Framework framework) {
		repository.save(framework);
	}
	
	public Framework get(int id) {
		return repository.findById(id).get();
	}
	
	public void delete(int id) {
		repository.deleteById(id);
	}

	public List<Framework> findByName(String name) {
		return repository.findByNameLike("%"+name+"%");
	}
}

package org.registry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FrameworkRepository extends JpaRepository<Framework, Integer> {

	List<Framework> findByNameLike(String name);

}

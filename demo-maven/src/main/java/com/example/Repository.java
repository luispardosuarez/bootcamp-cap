package com.example;

import java.util.List;
import java.util.Optional;

public interface Repository<E, K> {
	List<E> getAll();
	Optional<E> getOne(int id);
	E add(E item);
	E modify(E item);
	void delete (E item);
	void deteteById(K id);
}

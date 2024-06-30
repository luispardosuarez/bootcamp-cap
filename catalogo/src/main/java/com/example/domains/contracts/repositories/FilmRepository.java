package com.example.domains.contracts.repositories;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domains.core.contracts.repositories.RepositoryWithProjections;
import com.example.domains.entities.Film;

import lombok.NonNull;

public interface FilmRepository extends JpaRepository<Film, Integer>, RepositoryWithProjections {
	List<Film> findByLastUpdateGreaterThanEqualOrderByLastUpdate(Timestamp fecha);

	List<Film> findAll(@NonNull Specification<Film> spec);

	Optional<Film> findOne(@NonNull Specification<Film> spec);

	Page<Film> findAll(@NonNull Specification<Film> spec, @NonNull Pageable pageable);

	List<Film> findAll(@NonNull Specification<Film> spec, @NonNull Sort sort);
}
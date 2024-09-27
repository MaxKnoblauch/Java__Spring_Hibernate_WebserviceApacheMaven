package de.dhbwheidenheim.informatik.springhibernate.persondemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjektRepository extends JpaRepository<Objekt, Integer> {
}

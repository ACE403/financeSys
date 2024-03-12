package com.example.validatingforminput;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonFormRepository extends JpaRepository<PersonForm, Long> {


    PersonForm findByEmail(String email);
}
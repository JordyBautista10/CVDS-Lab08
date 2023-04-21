package edu.eci.cvds.servlet.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Long>{
    List<Configuration> findByPropiedad(String propiedad);
}
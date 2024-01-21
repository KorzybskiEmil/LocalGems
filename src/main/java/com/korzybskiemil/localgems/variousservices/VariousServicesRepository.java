package com.korzybskiemil.localgems.variousservices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VariousServicesRepository extends JpaRepository<VariousServices, UUID> {
}

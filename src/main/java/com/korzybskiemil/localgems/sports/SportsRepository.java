package com.korzybskiemil.localgems.sports;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SportsRepository extends JpaRepository<Sports, UUID> {
}

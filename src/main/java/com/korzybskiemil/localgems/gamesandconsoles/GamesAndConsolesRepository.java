package com.korzybskiemil.localgems.gamesandconsoles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GamesAndConsolesRepository extends JpaRepository<GamesAndConsoles, UUID> {
}

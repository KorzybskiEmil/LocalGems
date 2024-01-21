package com.korzybskiemil.localgems.musicandeducation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MusicAndEducationRepository extends JpaRepository<MusicAndEducation, UUID> {
}

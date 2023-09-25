package net.askkevin.askkevin.repositories;

import net.askkevin.askkevin.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}

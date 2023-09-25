package net.askkevin.askkevin.repositories;

import net.askkevin.askkevin.models.Surgery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurgeryRepository extends JpaRepository<Surgery, Long> {
}

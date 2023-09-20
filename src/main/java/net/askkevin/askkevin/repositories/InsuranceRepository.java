package net.askkevin.askkevin.repositories;

import net.askkevin.askkevin.models.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {

    Insurance findByUserId(long user_id);

}

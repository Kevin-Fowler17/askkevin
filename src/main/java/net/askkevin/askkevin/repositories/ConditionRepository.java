package net.askkevin.askkevin.repositories;

import net.askkevin.askkevin.models.Condition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConditionRepository extends JpaRepository<Condition, Long> {
}

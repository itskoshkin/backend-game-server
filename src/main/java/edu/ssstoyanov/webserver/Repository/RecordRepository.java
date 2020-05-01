package edu.ssstoyanov.webserver.Repository;

import edu.ssstoyanov.webserver.Model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Integer> {
}

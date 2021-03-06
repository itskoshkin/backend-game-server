package edu.ssstoyanov.webserver.Repository;

import edu.ssstoyanov.webserver.Model.Record;
import edu.ssstoyanov.webserver.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Stanislav Stoianov
 * @version 1.4
 * @see Record
 * @see edu.ssstoyanov.webserver.Service.RecordService
 * @since 16/04/20
 */

@Repository
public interface RecordRepository extends JpaRepository<Record, Integer> {
    List<Record> getAllByUser(User user);

    List<Record> getByUser(User user);

    List<Record> getByGame(String game);

    Integer deleteRecordByGame(String game);

}

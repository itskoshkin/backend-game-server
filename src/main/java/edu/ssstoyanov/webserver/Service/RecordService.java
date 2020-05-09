package edu.ssstoyanov.webserver.Service;

import edu.ssstoyanov.webserver.Model.Record;
import edu.ssstoyanov.webserver.Model.User;
import edu.ssstoyanov.webserver.Repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @author Stanislav Stoianov
 * @version 1.3
 * @see Record
 * @see edu.ssstoyanov.webserver.Repository.RecordRepository
 * @since 16/04/20
 */

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    public HashMap<String, Long> getRecordsByUser(User user) {
        HashMap<String, Long> data = new HashMap<>();
        List<Record> recordList = recordRepository.getAllByUser(user);
        for (Record record : recordList) {
            data.putIfAbsent(record.getGame(), record.getScore());
        }
        return data;
    }

}

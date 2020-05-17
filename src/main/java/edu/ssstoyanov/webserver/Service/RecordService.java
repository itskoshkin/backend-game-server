package edu.ssstoyanov.webserver.Service;

import edu.ssstoyanov.webserver.Model.Record;
import edu.ssstoyanov.webserver.Model.User;
import edu.ssstoyanov.webserver.Repository.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author Stanislav Stoianov
 * @version 1.5
 * @see Record
 * @see edu.ssstoyanov.webserver.Repository.RecordRepository
 * @since 16/04/20
 */

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private UserService userService;

    public HashMap<String, Long> getRecordsByUser(User user) {
        HashMap<String, Long> data = new HashMap<>();
        List<Record> recordList = recordRepository.getAllByUser(user);
        for (Record record : recordList) {
            data.putIfAbsent(record.getGame(), record.getScore());
        }
        return data;
    }

    @Transactional
    public Record saveRecordFromGamesPost(Record record) {
        User user = userService.findUserByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        record.setUser(user);
        record.setId(null);
        recordRepository.saveAndFlush(record);
        return record;
    }

}

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
 * @version 1.6
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

    @Transactional
    public void saveRecordFromGamesPost(Record record) {
        User user = userService.findUserByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
        record.setUser(user);
        record.setId(null);
        recordRepository.saveAndFlush(record);
    }

    @Transactional
    public Record saveRecordFromPost(Record record) {
        return recordRepository.saveAndFlush(record);
    }


    public HashMap<String, Long> getRecordsByUser(User user) {
        HashMap<String, Long> data = new HashMap<>();
        List<Record> recordList = recordRepository.getAllByUser(user);
        for (Record record : recordList) {
            data.putIfAbsent(record.getGame(), record.getScore());
        }
        return data;
    }

    public List<Record> getAllRecords() {
        return recordRepository.findAll();
    }

    public List<Record> getAllRecordsByUsername(String username) {
        return recordRepository.getByUser(userService.findUserByUserName(username));
    }

    public List<Record> getAllRecordsByGame(String game) {
        return recordRepository.getByGame(game);
    }

    @Transactional
    public Integer deleteAllRecordsByGame(String game) {
        return recordRepository.deleteRecordByGame(game);
    }
}

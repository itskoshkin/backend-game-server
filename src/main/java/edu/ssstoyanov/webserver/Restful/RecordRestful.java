package edu.ssstoyanov.webserver.Restful;

import edu.ssstoyanov.webserver.Model.Record;
import edu.ssstoyanov.webserver.Service.RecordService;
import edu.ssstoyanov.webserver.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Stanislav Stoianov
 * @version 2.0
 * @see Record
 * @see edu.ssstoyanov.webserver.Service.RecordService
 * @since 25/04/20
 */

@RequestMapping("/rest/api")
@RequiredArgsConstructor
@RestController()
public class RecordRestful {

    @Autowired
    private final RecordService recordService;

    @Autowired
    private final UserService userService;

    @GetMapping("/records")
    public List<Record> getAl() {
        return recordService.getAllRecords();
    }

    @GetMapping("/records/{username}")
    public List<Record> getRecordByUsername(@PathVariable(value = "username") String username) {
        return recordService.getAllRecordsByUsername(username);
    }

    @PostMapping(value = "/records")
    public Record addRecord(String username, String game, Long score) {
        return recordService.saveRecordFromPost(new Record(0, game, score, userService.findUserByUserName(username)));
    }

}


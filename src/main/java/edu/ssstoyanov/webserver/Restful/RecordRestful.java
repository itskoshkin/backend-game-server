package edu.ssstoyanov.webserver.Restful;

import edu.ssstoyanov.webserver.Model.Record;
import edu.ssstoyanov.webserver.Model.User;
import edu.ssstoyanov.webserver.Service.RecordService;
import edu.ssstoyanov.webserver.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/records/username/{username}")
    public List<Record> getRecordsByUsername(@PathVariable(value = "username") String username) {
        return recordService.getAllRecordsByUsername(username);
    }

    @GetMapping("/records/game/{game}")
    public List<Record> getRecordsByGame(@PathVariable(value = "game") String game) {
        return recordService.getAllRecordsByGame(game);
    }

    @PostMapping(value = "/records")
    public ResponseEntity<String> addRecord(String username, String game, Long score) {
        User user = userService.findUserByUserName(username);
        if (user == null) {
            return new ResponseEntity<>("User not found " + username, HttpStatus.NOT_FOUND);
        } else {
            recordService.saveRecordFromPost(new Record(0, game, score, user));
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/records/game")
    public ResponseEntity<String> deleteRecordsByGame(String game) {
        Integer byGame = recordService.deleteAllRecordsByGame(game);
        if (byGame != 0) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Game not found " + game, HttpStatus.NOT_FOUND);
        }
    }
}


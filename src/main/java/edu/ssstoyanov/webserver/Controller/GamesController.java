package edu.ssstoyanov.webserver.Controller;

import edu.ssstoyanov.webserver.Model.Record;
import edu.ssstoyanov.webserver.Service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author Stanislav Stoianov
 * @since 18/04/20
 * @version 1.2
 */

@Controller
public class GamesController {

    @Autowired
    private RecordService recordService;

    @GetMapping(value = "/games")
    public String getForm(Model model) {
        model.addAttribute("record", new Record());
        return "games";
    }

    @PostMapping(value = "/games")
    public String addGameRecord(@ModelAttribute Record record, Model model){
        model.addAttribute("record", record);
        recordService.saveRecordFromGamesPost(record);
        return "games";
    }
}

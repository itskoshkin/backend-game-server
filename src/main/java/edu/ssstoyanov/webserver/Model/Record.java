package edu.ssstoyanov.webserver.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Stanislav Stoianov
 * @version 1.3
 * @apiNote Hibernate class used to record points in the players table
 * @see edu.ssstoyanov.webserver.Controller.RecordsController
 * @see edu.ssstoyanov.webserver.Service.RecordService
 * @since 17/04/20
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "record_id")
    private Integer id;
    @Column(name = "game")
    private String game;
    @Column(name = "score")
    private Long score;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
package edu.ssstoyanov.webserver.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Stanislav Stoianov
 * @version 1.4
 * @apiNote Hibernate class used to record points in the players table
 * @see edu.ssstoyanov.webserver.Service.RecordService
 * @see edu.ssstoyanov.webserver.Repository.RecordRepository
 * @see edu.ssstoyanov.webserver.Restful.RecordRestful
 * @since 16/04/20
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
    @JsonIgnore
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
}
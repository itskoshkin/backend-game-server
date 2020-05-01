package edu.ssstoyanov.webserver.Model;

import javax.persistence.*;

/**
 * @author Stanislav Stoianov
 * creation date: 17/04/20.
 * @since 1.0
 */

// TODO: 20.04.2020

@Entity
@Table(name = "records")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userid", nullable = false)
    private User user;

    @Column(name = "game", nullable = false, length = 32)
    private String game;

    @Column(name = "score", nullable = false)
    private int score;


    public Record() {
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}

package net.askkevin.askkevin.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(10) UNSIGNED")
    private long id;

    @Column(nullable = true)
    private String p1a;

    @Column(nullable = true)
    private String p1b;

    @Column(nullable = true)
    private String p2a;

    @Column(nullable = true)
    private String p2b;

    @Column(nullable = true)
    private String p3a;

    @Column(nullable = true)
    private String p3b;

    @Column(nullable = true)
    private String p4a;

    @Column(nullable = true)
    private String p4b;

    @Column(nullable = true)
    private String p5a;

    @Column(nullable = true)
    private String p5b;

    @Column(nullable = true)
    private String p6a;

    @Column(nullable = true)
    private String p6b;

    @Column(nullable = true)
    private String p7a;

    @Column(nullable = true)
    private String p7b;

    @Column(nullable = true)
    private String p8a;

    @Column(nullable = true)
    private String p8b;

    @Column(nullable = true)
    private String p9a;

    @Column(nullable = true)
    private String p9b;

    @Column(nullable = true)
    private String p10a;

    @Column(nullable = true)
    private String p10b;

    @OneToOne
    @JoinColumn (nullable = false, name = "user_id")
    private User user;

}

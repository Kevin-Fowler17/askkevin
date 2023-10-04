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
    private String name;

    @Column(nullable = true)
    private String dosage;

    @ManyToOne
    @JoinColumn (nullable = false, name = "user_id")
    private User user;

}

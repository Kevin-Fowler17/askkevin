package net.askkevin.askkevin.models;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "insurance")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(10) UNSIGNED")
    private long id;

    @Column(nullable = false, columnDefinition = "INT(10) UNSIGNED")
    private long q1;

    @Column(nullable = true)
    private String q1os;

    @Column(nullable = false, columnDefinition = "INT(10)")
    private long q2;

    @Column(nullable = true)
    private String q2os;

    @Column(nullable = false)
    private String q3;

    @Column(nullable = false, columnDefinition = "INT(10)")
    private long q4;

    @Column(nullable = true, columnDefinition = "INT(10)")
    private long q5;

    @Column(nullable = true)
    private String q5os;

    @Column(nullable = true, columnDefinition = "INT(10)")
    private long q6;

    @Column(nullable = true)
    private String q6os;

    @Column(nullable = true)
    private String q7;

    @OneToOne
    @JoinColumn (nullable = false, name = "user_id")
    private User user;

//    @OneToOne
//    @JoinColumn(name = "q1", referencedColumnName = "q1_code", insertable = false, updatable = false)
//    private InsuranceCompany insuranceCompany;

}

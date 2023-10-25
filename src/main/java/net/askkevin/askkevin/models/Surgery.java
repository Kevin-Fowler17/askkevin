package net.askkevin.askkevin.models;

import jakarta.persistence.*;
import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "surgeries")
public class Surgery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(10) UNSIGNED")
    private long id;

    @Column(nullable = false)
    private String type;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn (nullable = false, name = "user_id")
    private User user;

    public void setDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
            Date parsedDate = dateFormat.parse(dateString);
            this.date = parsedDate;
        } catch (ParseException e) {
            // Add any error handling here.

        }
    }
}

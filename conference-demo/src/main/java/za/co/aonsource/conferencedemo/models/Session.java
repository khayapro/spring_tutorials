package za.co.aonsource.conferencedemo.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "sessions")
public class Session {

    @Id
    @Column(name = "session_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;
    @Column(name = "session_name")
    private String sessionName;
    @Column(name = "session_description")
    private String sessionDescription;
    @Column(name = "session_length")
    private Integer sessionLengh;

    @ManyToMany
    @JoinTable(name = "session_speakers",
            joinColumns = @JoinColumn(name = "session_id"),
            inverseJoinColumns = @JoinColumn(name = "speaker_id"))
    List<Speaker> speakers;

}

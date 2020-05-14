package za.co.aonsource.conferencedemo.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity(name = "speakers")
public class Speaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "speaker_id")
    private Long speakerId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "title")
    private String title;
    @Column(name = "company")
    private String company;
    @Column(name = "speaker_bio")
    private String speakerBio;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(name = "speaker_photo")
    private byte [] profilePicture;

    @ManyToMany(mappedBy = "speakers")
    List<Session> sessions;

}

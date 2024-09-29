package mentornetbetest.modules.media.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import mentornetbetest.modules.announcement.domain.entity.Announcement;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mediaId;
    private String title;
    private String link;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="media_type_id")
    private MediaTypes mediaTypes;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="announcement_id")
    private Announcement announcement;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Media media = (Media) o;
        return Objects.equals(mediaId, media.mediaId) && Objects.equals(title, media.title) && Objects.equals(link, media.link) && Objects.equals(mediaTypes, media.mediaTypes) && Objects.equals(announcement, media.announcement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mediaId, title, link, mediaTypes, announcement);
    }
}


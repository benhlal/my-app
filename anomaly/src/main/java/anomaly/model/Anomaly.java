package anomaly.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "anomaly", schema = "public")

public class Anomaly {
    @Id
    @SequenceGenerator(
            name = "anomaly_id_sequence",
            sequenceName = "anomaly_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "anomaly_id_sequence"
    )
    private Integer id;
    private String title;
    private String description;
    private String creator;
    private LocalDate creationDate;
}

package finalpcj.appointment.model;

import finalpcj.user.model.User;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Appointment {
    private String id;
    private String car;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private User carOwner;
}

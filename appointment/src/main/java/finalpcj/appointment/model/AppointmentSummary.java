package finalpcj.appointment.model;

import finalpcj.user.model.User;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AppointmentSummary {
    private String id;
    private Appointment appointment;
    private User mechanic;
    private String comment;
    private Float totalCost;
}

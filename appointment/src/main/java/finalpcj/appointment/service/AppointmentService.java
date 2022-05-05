package finalpcj.appointment.service;

import finalpcj.appointment.model.Appointment;
import finalpcj.user.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {
    List<Appointment> findAll();
    Optional<Appointment> findById(String id);
    Optional<Appointment> findByStartDate(LocalDateTime date);
    Appointment save (Appointment appointment);
    void delete (Appointment appointment);
}

package finalpcj.appointment.service;

import finalpcj.appointment.model.Appointment;
import finalpcj.appointment.model.AppointmentSummary;

import java.util.List;
import java.util.Optional;

public interface AppointmentSummaryService {
    List<AppointmentSummary> findAll();
    Optional<AppointmentSummary> findById(String id);
    AppointmentSummary save (AppointmentSummary summary);
    void delete (AppointmentSummary summary);
}

package finalpcj.appointment.service;

import finalpcj.appointment.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private List<Appointment> appointments;

    @Autowired
    public AppointmentServiceImpl(List<Appointment> appointments) {
        this.appointments = appointments;
    }

    @Override
    public List<Appointment> findAll() {
        return appointments;
    }

    @Override
    public Optional<Appointment> findById(String id) {
        return appointments.stream().filter(a -> a.getId().equals(id)).findAny();
    }

    @Override
    public Optional<Appointment> findByStartDate(LocalDateTime date) {
        return appointments.stream().filter(a -> a.getStartDate().equals(date)).findAny();
    }

    @Override
    public Appointment save(Appointment appointment) {
        appointments.add(appointment);
        return appointment;
    }

    @Override
    public void delete(Appointment appointment) {
        appointments.remove(appointment);
    }
}

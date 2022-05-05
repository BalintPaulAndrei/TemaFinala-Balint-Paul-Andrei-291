package finalpcj.appointment.service;

import finalpcj.appointment.model.Appointment;
import finalpcj.appointment.model.AppointmentSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentSummaryServiceImpl implements AppointmentSummaryService {
    private List<AppointmentSummary> summaries;

    @Autowired
    public AppointmentSummaryServiceImpl(List<AppointmentSummary> summaries) {
        this.summaries = summaries;
    }
    @Override
    public List<AppointmentSummary> findAll() {
        return summaries;
    }

    @Override
    public Optional<AppointmentSummary> findById(String id) {
        return summaries.stream().filter(s -> s.getId().equals(id)).findAny();
    }

    @Override
    public AppointmentSummary save(AppointmentSummary summary) {
        summaries.add(summary);
        return summary;
    }

    @Override
    public void delete(AppointmentSummary summary) {
        summaries.remove(summary);
    }
}

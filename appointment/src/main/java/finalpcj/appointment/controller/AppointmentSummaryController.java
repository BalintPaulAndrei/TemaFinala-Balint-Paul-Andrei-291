package finalpcj.appointment.controller;

import finalpcj.appointment.model.AppointmentSummary;
import finalpcj.appointment.service.AppointmentSummaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/appointmentsummaries")
public class AppointmentSummaryController {
    private final AppointmentSummaryService appointmentSummaryService;

    public AppointmentSummaryController(AppointmentSummaryService appointmentSummaryService) {
        this.appointmentSummaryService = appointmentSummaryService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AppointmentSummary> getAll(){
        return appointmentSummaryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        Optional<AppointmentSummary> app = appointmentSummaryService.findById(id);
        if(app.isPresent()){
            return ResponseEntity.ok(app.get());
        }
        return ResponseEntity.status(409).body("Appointment not found");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public AppointmentSummary create (@RequestBody AppointmentSummary appointmentSummary){
        appointmentSummary.setId(UUID.randomUUID().toString());
        return appointmentSummaryService.save(appointmentSummary);
    }

    @PutMapping
    public ResponseEntity<?> update(AppointmentSummary appointmentSummary){
        Optional<AppointmentSummary> app = appointmentSummaryService.findById(appointmentSummary.getId());
        if(app.isPresent()){
            return ResponseEntity.ok(appointmentSummaryService.save(appointmentSummary));
        }
        return ResponseEntity.status(409).body("Appointment not found");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        Optional<AppointmentSummary> app = appointmentSummaryService.findById(id);
        app.ifPresent(appointmentSummaryService::delete);
    }
}
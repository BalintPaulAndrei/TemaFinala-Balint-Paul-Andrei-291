package finalpcj.appointment.controller;

import finalpcj.appointment.model.Appointment;
import finalpcj.appointment.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Appointment> getAll(){
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        Optional<Appointment> app = appointmentService.findById(id);
        if(app.isPresent()){
            return ResponseEntity.ok(app.get());
        }
        return ResponseEntity.status(409).body("Appointment not found");
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Appointment appointment){
        Optional<Appointment> app = appointmentService.findByStartDate(appointment.getStartDate());
        if(app.isPresent()){
            return ResponseEntity.status(409).body("Date occupied");
        }
        appointment.setId(UUID.randomUUID().toString());
        return ResponseEntity.ok(appointmentService.save(appointment));
    }

    @PutMapping
    public ResponseEntity<?> update(Appointment appointment){
        Optional<Appointment> app = appointmentService.findById(appointment.getId());
        if(app.isPresent()){
            return ResponseEntity.ok(appointmentService.save(appointment));
        }
        return ResponseEntity.status(409).body("Appointment not found");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        Optional<Appointment> app = appointmentService.findById(id);
        app.ifPresent(appointmentService::delete);
    }
}

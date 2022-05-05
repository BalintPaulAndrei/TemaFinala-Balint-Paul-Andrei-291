package finalpcj.user.controller;

import finalpcj.user.model.User;
import finalpcj.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> list(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        Optional<User> res = userService.findById(id);
        if(res.isPresent()){
            return ResponseEntity.ok(res.get());
        }
        return ResponseEntity.status(409).body("User not found");
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public User create(@RequestBody User user){
        user.setId(UUID.randomUUID().toString());
        return userService.save(user);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody User user){
        Optional<User> res = userService.findById(user.getId());
        if(res.isPresent()){
            return ResponseEntity.ok(userService.save(user));
        }
        return ResponseEntity.status(409).body("User not found.");
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        Optional<User> res = userService.findById(id);
        res.ifPresent(userService::delete);
    }
}

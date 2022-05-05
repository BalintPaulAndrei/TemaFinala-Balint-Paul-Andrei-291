package finalpcj.user.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String type;
}

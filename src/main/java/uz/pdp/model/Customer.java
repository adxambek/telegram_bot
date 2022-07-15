package uz.pdp.model;

import lombok.*;
import uz.pdp.enums.CustomerStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private CustomerStatus status;
}

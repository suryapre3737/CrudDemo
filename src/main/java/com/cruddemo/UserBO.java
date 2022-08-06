package com.cruddemo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserBO {
    private String firstName;
    private String lastName;
    private String email;
}

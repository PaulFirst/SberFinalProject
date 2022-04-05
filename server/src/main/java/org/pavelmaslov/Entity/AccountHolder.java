package org.pavelmaslov.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "holders")
public class AccountHolder {

    @Id
    @NotBlank
    private String login;

    @NotBlank
    @Size(min=8)
    private String password;
}

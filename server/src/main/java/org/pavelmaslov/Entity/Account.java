package org.pavelmaslov.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @NotBlank
    private int id;

    @NotBlank
    private String userLogin;

    @NotBlank
    private BigDecimal balance;
}

package com.example.e_factura.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.io.Serializable;

@Entity
@Table(name = "interest_rates")
public class InterestRate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private TypeOfInterestRate type;

    @NotBlank
    @Column(name = "rate_time", nullable = false)
    private int rateTime;

    @Null
    @Column(name = "compounding_period", nullable = true)
    private int compoundingPeriod;

    // TODO: Agregar relacion con Factura

}

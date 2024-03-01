package model;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("Bank")
public class Bank extends Owner{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Bank() {
    }


}

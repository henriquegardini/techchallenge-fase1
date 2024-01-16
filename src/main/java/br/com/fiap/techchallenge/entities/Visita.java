package br.com.fiap.techchallenge.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.naming.Name;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "visita")
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "apartamento")
    private Integer apartamento;
    @Column(name = "torre")
    private String torre;
    @CreationTimestamp
    private LocalDate cadastro;
    private LocalDate expiracao;


}

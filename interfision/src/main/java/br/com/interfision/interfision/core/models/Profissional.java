package br.com.interfision.interfision.core.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Profissional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false, length = 45)
    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private String dataNascimento;


    @Column(nullable = false, length = 20)
    private String telefone;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "registro_profissional", nullable = false, length = 12, unique = true)
    private String registroProfissional;

    @Column(name = "anos_experiencia", nullable = false)
    private Integer anosExperiencia;

    @Column(nullable = false)
    private Double salario;
    
    @OneToMany(mappedBy = "profissional",cascade = CascadeType.ALL)
    private Set<Consulta> consultas = new HashSet();
}

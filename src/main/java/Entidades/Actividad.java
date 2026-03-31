package Entidades;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.Comparator;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode (of = "codigo")

public class Actividad implements Comparable<Actividad> {

    private String codigo;
    private String nombre;
    private String descripcion;
    private DiaSemana diaSemana;
    private LocalTime horaInicio;
    private int duracionMinutos;
    private int aforoMaximo;
    private String monitor;

    //Metodo
    @Override
    public int compareTo(Actividad o) {
        return Comparator.comparing(Actividad::getDiaSemana)
                .thenComparing(Actividad::getHoraInicio)
                .compare(this, o);
    }

}

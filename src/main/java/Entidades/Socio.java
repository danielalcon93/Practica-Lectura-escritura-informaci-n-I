package Entidades;

import lombok.*;

import java.time.LocalDate;
import java.util.Comparator;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode (of = "dni")

public class Socio implements Comparable<Socio> {

    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fechaAlta;
    private Cuota cuota;

    //Metodo
    @Override
    public int compareTo(Socio o) {
        return Comparator.comparing(Socio::getApellido)
                .thenComparing(Socio::getNombre)
                .compare(this,o);
    }

}

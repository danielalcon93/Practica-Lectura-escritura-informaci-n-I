package Entidades;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode (of = {"socio", "actividad", "fechaReserva"})

public class Reserva {

    private Socio socio;
    private Actividad actividad;
    private LocalDate fechaReserva;
    private boolean asistio = false;

    //Metodos
    public void confirmarAsistencia() {
        this.asistio = true;
    }

    public boolean estaActiva() {
        return !fechaReserva.isBefore(LocalDate.now());
    }
}

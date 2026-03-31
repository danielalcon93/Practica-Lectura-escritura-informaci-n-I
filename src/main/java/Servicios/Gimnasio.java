package Servicios;

import Entidades.Actividad;
import Entidades.Reserva;
import Entidades.Socio;
import lombok.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode (of = "nombre")

public class Gimnasio {

    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private HashMap<String, Socio> socios = new HashMap<>();
    private HashMap<String, Actividad> actividades = new HashMap<>();
    private TreeMap<Socio, HashSet<Reserva>> reservas = new TreeMap<>();


}

package Servicios;

import Entidades.Actividad;
import Entidades.Reserva;
import Entidades.Socio;
import lombok.*;

import java.time.LocalDate;
import java.util.*;

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

    //Constructor
    public Gimnasio(String nombre, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    //Metodos
    public void addSocio(Socio s) {
        socios.put(s.getDni(), s);
    }


    public void addActividad(Actividad a) {
        actividades.put(a.getCodigo(), a);
    }


    public void reservarActividad(String dni, String codigoActividad) {
        Socio socio = socios.get(dni);
        Actividad actividad = actividades.get(codigoActividad);

        if (socio == null || actividad == null)
            return;

        reservas.putIfAbsent(socio, new HashSet<>());

        for (Reserva r : reservas.get(socio)) {
            if(r.getActividad().equals(actividad) && r.estaActiva()) {
                return;
            }
        }

        int contador = 0;
        for (HashSet<Reserva> lista : reservas.values()) {
            for (Reserva r : lista) {
                if (r.getActividad().equals(actividad) && r.estaActiva()) {
                    contador++;
                }
            }
        }

        if (contador >= actividad.getAforoMaximo())
            return;

        reservas.get(socio).add(new Reserva(socio, actividad, LocalDate.now(), false));
    }


    public void cancelarReserva(String dni, String codigoActividad) {
        Socio socio = socios.get(dni);
        Actividad actividad = actividades.get(codigoActividad);

        if (socio == null || actividad == null)
            return;

        HashSet<Reserva> lista = this.reservas.get(socio);
        if (lista == null)
            return;

        Reserva eliminar = null;
        for (Reserva r : lista) {
            if (r.getActividad().equals(actividad) && r.estaActiva()) {
                eliminar = r;
            }
        }

        if (eliminar != null) {
            lista.remove(eliminar);
        }
    }


    public TreeSet<Actividad> getActividadesSocio(String dni) {
        Socio socio = socios.get(dni);
        TreeSet<Actividad> actividades = new TreeSet<>();

        if(socio == null)
            return actividades;

        HashSet<Reserva> lista = this.reservas.get(socio);
        if (lista == null)
            return actividades;

        for (Reserva r : lista) {
            actividades.add(r.getActividad());
        }
        return actividades;
    }


    public Set<Actividad> getActividadesLlenas() {
        Set<Actividad> resultado = new HashSet<>();

        for (Actividad a : actividades.values()) {
            int contador = 0;

            for (HashSet<Reserva> lista : reservas.values()) {
                for (Reserva r : lista) {
                    if (r.getActividad().equals(a) && r.estaActiva()) {
                        contador++;
                    }
                }
            }
            if (contador >= a.getAforoMaximo()) {
                resultado.add(a);
            }
        }
        return resultado;
    }


    public List<Socio> getRankingSocios() {
        List<Socio> lista = new ArrayList<>(reservas.keySet());

        lista.sort(Comparator.comparing((Socio s) -> reservas.get(s).size()).reversed());
        return lista;
    }


    public List<Reserva> getReservasOrdenadasPorFecha() {
        List<Reserva> lista = new ArrayList<>();

        for (HashSet<Reserva> set : reservas.values()) {
            lista.addAll(set);
        }

        lista.sort(Comparator.comparing(Reserva::getFechaReserva));
        return lista;
    }


    public List<Reserva> getReservasOrdenadasPorActividad() {
        List<Reserva> lista = new ArrayList<>();

        for (HashSet<Reserva> set : reservas.values()) {
            lista.addAll(set);
        }

        lista.sort(Comparator.comparing(r -> r.getActividad().getNombre()));
        return lista;
    }


    public List<Reserva> getRerservasOrdenadasPorSocioYFecha() {
        List<Reserva> lista = new ArrayList<>();

        for(HashSet<Reserva> set : reservas.values()){
            for(Reserva r : set){
                lista.add(r);
            }
        }

        lista.sort(
                Comparator.comparing((Reserva r) -> r.getSocio().getApellido())
                        .thenComparing(Reserva::getFechaReserva, Comparator.reverseOrder()));

        return lista;
    }


    public List<Reserva> getReservasOrdenadasPorDuracion() {
        List<Reserva> lista = new ArrayList<>();

        for(HashSet<Reserva> set : reservas.values()){
            for(Reserva r : set){
                lista.add(r);
            }
        }

        lista.sort(
                Comparator.comparing((Reserva r) -> r.getActividad()
                                .getDuracionMinutos()).reversed());

        return lista;
    }


    public List<Reserva> getReservasPendientesOrdenadasPorFecha() {
        List<Reserva> lista = new ArrayList<>();

        for(HashSet<Reserva> set : reservas.values()) {
            for (Reserva r : set) {
                if (r.estaActiva()) {
                    lista.add(r);
                }
            }
        }

        lista.sort(Comparator.comparing(Reserva::getFechaReserva));

        return lista;
    }


}


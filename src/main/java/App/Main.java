package App;

import Entidades.Actividad;
import Entidades.Cuota;
import Entidades.DiaSemana;
import Entidades.Socio;
import Servicios.Gimnasio;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {

        //Creamos el gimnasio
        Gimnasio gym = new Gimnasio("FitZone Murcia","Calle Mayor 123","968123456","info@fitzone.com");


        //Creamos los socios y los añadimos
        Socio s1 = new Socio("111A", "Juan", "Perez", "juan@mail.com", "600111111", LocalDate.now(), Cuota.BASICA);
        Socio s2 = new Socio("222B", "Maria", "Lopez", "maria@mail.com", "600222222", LocalDate.now(), Cuota.PREMIUM);
        Socio s3 = new Socio("333C", "Carlos", "Garcia", "carlos@mail.com", "600333333", LocalDate.now(), Cuota.FAMILIAR);
        Socio s4 = new Socio("444D", "Ana", "Martinez", "ana@mail.com", "600444444", LocalDate.now(), Cuota.BASICA);
        Socio s5 = new Socio("555E", "Luis", "Sanchez", "luis@mail.com", "600555555", LocalDate.now(), Cuota.PREMIUM);
        Socio s6 = new Socio("666F", "Elena", "Gomez", "elena@mail.com", "600666666", LocalDate.now(), Cuota.FAMILIAR);

        gym.addSocio(s1);
        gym.addSocio(s2);
        gym.addSocio(s3);
        gym.addSocio(s4);
        gym.addSocio(s5);
        gym.addSocio(s6);


        //Creamos actividades
        Actividad a1 = new Actividad("A1", "Yoga", "Relajación", DiaSemana.LUNES, LocalTime.of(9,0), 60, 3, "Laura");
        Actividad a2 = new Actividad("A2", "Spinning", "Cardio intenso", DiaSemana.MARTES, LocalTime.of(18,0), 60, 10, "Carlos");
        Actividad a3 = new Actividad("A3", "Pilates", "Trabajo de core", DiaSemana.MIERCOLES, LocalTime.of(10,0), 60, 2, "Ana");
        Actividad a4 = new Actividad("A4", "CrossFit", "Alta intensidad", DiaSemana.JUEVES, LocalTime.of(19,0), 60, 8, "David");
        Actividad a5 = new Actividad("A5", "Zumba", "Baile fitness", DiaSemana.VIERNES, LocalTime.of(17,30), 60, 15, "Lucia");
        Actividad a6 = new Actividad("A6", "Natación", "Piscina", DiaSemana.SABADO, LocalTime.of(10,0), 60, 6, "Mario");
        Actividad a7 = new Actividad("A7", "Boxeo", "Entrenamiento", DiaSemana.LUNES, LocalTime.of(20,0), 60, 3, "Pedro");
        Actividad a8 = new Actividad("A8", "Meditación", "Relajación mental", DiaSemana.DOMINGO, LocalTime.of(11,0), 60, 12, "Sofia");

        gym.addActividad(a1);
        gym.addActividad(a2);
        gym.addActividad(a3);
        gym.addActividad(a4);
        gym.addActividad(a5);
        gym.addActividad(a6);
        gym.addActividad(a7);
        gym.addActividad(a8);
    }
}

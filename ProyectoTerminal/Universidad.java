package ProyectoTerminal;

public class Universidad {
    //atributos
    public static void main(String [] args){
        //se crean dos proyectos 
        ProyectoTerminal carro = new ProyectoTerminal("Carro volador");
        ProyectoTerminal tiempo = new ProyectoTerminal("Maquina del tiempo");

        System.out.println("Se han creado los PT...");

        //creo alumnos y profes
        Alumno pepe = new Alumno("Pepe", 1234);
        Alumno martin = new Alumno("Martin", 1987);

        System.out.println("Alumnos creados...");

        Asesor rafa = new Asesor(6789, "Rafael", "Quimica");
        Asesor doc = new Asesor(1956, "Doc Emet", "Fisica");

        System.out.println("Asesore creados...");

        //se agregan los proyecto a alumnos y los asesores a proyctos
        //aqui son los profes al proyecto
        carro.agregarAsesor(rafa);
        tiempo.agregarAsesor(doc);

        //aqui los proyectos a los alumnos
        pepe.agregarProyecto(carro);
        martin.agregarProyecto(tiempo);

        System.out.println("Se han agregado los proyecto a los alumnos y los Asesores a los PT...");

    }
}

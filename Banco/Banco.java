package Banco;

import java.util.ArrayList;

public class Banco {
    //atributos
    private String nombreBanco;
    private ArrayList<Usuario> usuarios;

    //metodos
    public Banco (){
        this.usuarios = new ArrayList<Usuario>();
    }

    public Banco(String nombreBanco){
        this.nombreBanco = nombreBanco;
        this.usuarios = new ArrayList<Usuario>(); //para saber que es una lista
    }

    //metodo
    public void agregarUsuario(Usuario nuevoUsuario){
        usuarios.add(nuevoUsuario);
        System.out.println("Usuario: " +nuevoUsuario.getNombre()+ " agregado");
    }

    public Usuario buscarCuenta(String numCuenta){
        for(Usuario aux: usuarios){
            if(aux.cuenta.getNumCuenta().equals(numCuenta)){
                return aux;
            }
        }
        return null<
    }
}

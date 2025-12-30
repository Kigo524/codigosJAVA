package Banco;

import java.util.ArrayList;

public class Banco {
    //atributos
    public String nombreBanco;
    public ArrayList<Usuario> usuarios;

    //metodos
    public Banco(String nombreBanco){
        this.nombreBanco = nombreBanco;
        this.usuarios = new ArrayList<Usuario>(); //para saber que es una lista
    }

    public void agregarUsuario(Usuario nuevoUsuario){
        usuarios.add(nuevoUsuario);
        System.out.println("Usuario: " +nuevoUsuario.getNombre()+ " agregado");
    }

    public Usuario buscarCuenta(String numeroABuscar){
        for(Usuario aux: usuarios){
            //obtiene el numero de cuenta del usuario actual y compara
            if(aux.getCuenta().getNumCuenta().equals(numeroABuscar)){
                return aux;
            }
        }
        return null;//si no lo encuentra
    }
}

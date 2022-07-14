/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import java.util.ArrayList;
import java.util.List;
import modelo.Equipo;
import modelo.Jugador;

/**
 *
 * @author Adrian
 */
public class JugadorServicio implements IJugador {
    private List<Jugador> listJugador;
    
    public JugadorServicio()
    {
        listJugador= new ArrayList<>();
    }

    @Override
    public Jugador crear(Jugador jugador) 
    {
        if (exist(jugador.getCodigo()) == false)
        {
            this.listJugador.add(jugador);
            return jugador;
        }   
        else{
            throw new RuntimeException("Ya existe un jugador con ese código");
        }        
    }

    @Override
    public List<Jugador> listar() {
        return this.listJugador;
    }

  @Override
    public Jugador modificar(int codigoJugador, Jugador jugadorNuevo) {
        if (exist(codigoJugador) == true)
        {
            var posicion=this.buscarPosicion(this.buscarPorCodigo(codigoJugador));
            this.listar().get(posicion).setCedula(jugadorNuevo.getCedula());
            this.listar().get(posicion).setNacionalidad(jugadorNuevo.getNacionalidad());
            this.listar().get(posicion).setEdad(jugadorNuevo.getEdad());
            this.listar().get(posicion).setDorsal(jugadorNuevo.getDorsal());        
            this.listar().get(posicion).setNombre(jugadorNuevo.getNombre());
            this.listar().get(posicion).setPosicion(jugadorNuevo.getPosicion());
            return jugadorNuevo;
        }
        else
        {
            throw new RuntimeException("No se ha encontrado un jugador con ese código");
        }

    }

    @Override
    public Jugador eliminar(int codigoJugador) {
        if (exist(codigoJugador) == true)
        {
        Jugador jugador=this.buscarPorCodigo(codigoJugador);
        var posicion=this.buscarPosicion(jugador);
        this.listar().remove(posicion);
        return jugador;
        }
        else
        {
            throw new RuntimeException("No se ha encontrado un jugador con ese código");
        }
    }

    @Override
    public Jugador buscarPorCodigo(int codigoJugador) {
        Jugador jugador=null;
        for(var b:this.listJugador){
            if(codigoJugador==b.getCodigo()){
                jugador=b;
                break;
            }
        }
        return jugador;
    }

    @Override
    public int buscarPosicion(Jugador jugador) {
         int posicion=-1;
        for(var b:this.listJugador){
            posicion++;
            if(b.getCodigo()==jugador.getCodigo()){
                break;
            }
        }
        return posicion;
    }
    
    private boolean exist(int codigo)
    {
        boolean result = false;
        for (Jugador e : listJugador)
        {
            if (e.getCodigo() == codigo)
            {
                result = true;
                break;
            }
        }
        return result;
    }
}

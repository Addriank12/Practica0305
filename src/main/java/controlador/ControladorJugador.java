/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Servicio.EquipoServicio;
import Servicio.JugadorServicio;
import java.util.List;
import modelo.Equipo;
import modelo.Jugador;

/**
 *
 * @author Adrian
 */
public class ControladorJugador {
    private final JugadorServicio jugadorServicio = new JugadorServicio();
    private static ControladorEquipo controladorEquipo = new ControladorEquipo();
    public Jugador crear(String[] params){
        Jugador jugador = new Jugador(Integer.valueOf(params[6]),params[0], params[1], Integer.valueOf(params[2]), params[3], Integer.valueOf(params[4]),params[5],controladorEquipo.listar().get(Integer.valueOf(params[7])));
        this.jugadorServicio.crear(jugador);
        return jugador;  
    }
    
    public Jugador eliminar(String arg)
    {
        return this.jugadorServicio.eliminar(Integer.valueOf(arg));
    }
    
     public Jugador buscarJugador(String arg){
        return this.jugadorServicio.buscarPorCodigo(Integer.valueOf(arg));
    }
     public Jugador modificar(String [] params){
        Jugador jugadorNuevo = new Jugador(Integer.valueOf(params[6]),params[0], params[1], Integer.valueOf(params[2]), params[3], Integer.valueOf(params[4]),params[5],controladorEquipo.listar().get(Integer.valueOf(params[7]))); 
        this.jugadorServicio.modificar(Integer.valueOf(params[6]), jugadorNuevo);
        return jugadorNuevo;
    }
    
    public List<Jugador> listar()
    {
        return this.jugadorServicio.listar();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Servicio.EquipoServicio;
import Servicio.JugadorServicio;
import java.io.IOException;
import java.util.List;
import modelo.Equipo;
import modelo.Jugador;

/**
 *
 * @author Adrian
 */
public class ControladorJugador {
    private static JugadorServicio jugadorServicio;
    private static ControladorEquipo controladorEquipo = new ControladorEquipo();
    
    public ControladorJugador() throws IOException
    {
        jugadorServicio = new JugadorServicio();
    }
    
   
    public Jugador crear(String[] params) throws IOException{
        Jugador jugador = new Jugador(Integer.valueOf(params[6]),params[0], params[1], Integer.valueOf(params[2]), params[3], Integer.valueOf(params[4]),params[5],controladorEquipo.listar().get(Integer.valueOf(params[7])));
        this.jugadorServicio.crear(jugador, true);
        return jugador;  
    }
    
    public Jugador eliminar(String arg) throws IOException
    {
        return this.jugadorServicio.eliminar(Integer.valueOf(arg));
    }
    
     public Jugador buscarJugador(String arg){
        return this.jugadorServicio.buscarPorCodigo(Integer.valueOf(arg));
    }
     public Jugador modificar(String [] params) throws IOException{
        Jugador jugadorNuevo = new Jugador(Integer.valueOf(params[6]),params[0], params[1], Integer.valueOf(params[2]), params[3], Integer.valueOf(params[4]),params[5],controladorEquipo.listar().get(Integer.valueOf(params[7]))); 
        this.jugadorServicio.modificar(Integer.valueOf(params[6]), jugadorNuevo);
        return jugadorNuevo;
    }
    
    public List<Jugador> listar() throws IOException
    {
        return this.jugadorServicio.listar();
    }
}

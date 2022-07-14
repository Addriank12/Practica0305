/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Servicio.PartidoServicio;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import modelo.Equipo;
import modelo.Partido;

/**
 *
 * @author Adrian
 */
public class ControladorPartido {
    private final PartidoServicio partidoServicio = new PartidoServicio();
    private static ControladorEquipo controladorEquipo = new ControladorEquipo();
    //controladorEquipo.listar().get(Integer.valueOf(params[7])
    public Partido crear(String[] params){
        Date fecha;
        try {
             var fechaStrings = params[3].split("/");
             fecha = new Date(Integer.parseInt(fechaStrings[0]),Integer.parseInt(fechaStrings[1]) , Integer.parseInt(fechaStrings[2]));   
        } catch (Exception e) {
            throw new RuntimeException("Fecha Invalida");
        }
           
        Partido partido = new Partido(Integer.valueOf(params[6]),fecha, Integer.valueOf(params[0]), params[1], params[2], controladorEquipo.listar().get(Integer.valueOf(params[4])), controladorEquipo.listar().get(Integer.valueOf(params[5])));
        this.partidoServicio.crear(partido);
        return partido;
    }
    
    public Partido buscarPartido(String arg){
        return this.partidoServicio.buscarPorCodigo(Integer.valueOf(arg));
    }
    
    public Partido eliminar(String arg)
    {
        return this.partidoServicio.eliminar(Integer.valueOf(arg));
    }
    
     public Partido modificar(String [] params){
        var fechaStrings = params[3].split("/");
        Date fecha = new Date(Integer.parseInt(fechaStrings[0]),Integer.parseInt(fechaStrings[1]) , Integer.parseInt(fechaStrings[2]));       
        Partido partidoNuevo = new Partido(Integer.valueOf(params[6]),fecha, Integer.valueOf(params[0]), params[1], params[2], controladorEquipo.listar().get(Integer.valueOf(params[4])), controladorEquipo.listar().get(Integer.valueOf(params[5])));
        this.partidoServicio.modificar(Integer.valueOf(params[6]), partidoNuevo);
        return partidoNuevo;
    }
    
    
    public List<Partido> listar()
    {
        return this.partidoServicio.listar();
    }
}

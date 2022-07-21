/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import Servicio.EquipoServicio;
import java.util.List;
import modelo.Equipo;
/**
 *
 * @author Adrian
 */
public class ControladorEquipo
{
    private static final EquipoServicio equipoServicio = new EquipoServicio();
    
    public Equipo crear(String[] params){
        Equipo equipo = new Equipo(Integer.valueOf(params[5]), params[0], Integer.valueOf(params[1]), params[2], params[3], Integer.valueOf(params[4]));
        this.equipoServicio.crear(equipo);
        return equipo;
    }
    
    public Equipo buscarEquipo(String arg){
        return this.equipoServicio.buscarPorCodigo(Integer.valueOf(arg));
    }
    
    public Equipo eliminar(String arg)
    {
        return this.equipoServicio.eliminar(Integer.valueOf(arg));
    }
    
    public int buscarPosicion(Equipo equipo)
    {
        return this.equipoServicio.buscarPosicion(equipo);
    }
    
     public Equipo modificar(String [] args){
        Equipo equipoNuevo = new Equipo(Integer.valueOf(args[5]), args[0], Integer.valueOf(args[1]), args[2], args[3], Integer.valueOf(args[4]));       
        this.equipoServicio.modificar(Integer.valueOf(args[5]), equipoNuevo);
        return equipoNuevo;
    }  
    
    public List<Equipo> listar()
    {
        return this.equipoServicio.listar();
    }
    
    public int count()
    {
        return this.equipoServicio.count();
    }
}

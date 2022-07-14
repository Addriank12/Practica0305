/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import modelo.Equipo;

/**
 *
 * @author Adrian
 */
public class EquipoServicio implements IEquipo {
    private List<Equipo> listEquipo;
    
    public EquipoServicio()
    {
        listEquipo= new ArrayList<>();
    }
    @Override
    public Equipo crear(Equipo equipo) {
        if (exist(equipo.getCodigo(), equipo.getNombre()) == false)
        {
            this.listEquipo.add(equipo);
            return equipo;
        }
        else
        {
            throw new RuntimeException("Ya existe un equipo con este código.");
        }        
    }

    @Override
    public List<Equipo> listar() {
        return this.listEquipo;
    }

    @Override
    public Equipo modificar(int codigoEquipo, Equipo equipoNuevo) {
        if (exist(codigoEquipo) == true)
        {
            var posicion=this.buscarPosicion(this.buscarPorCodigo(codigoEquipo));
            this.listar().get(posicion).setConfederacion(equipoNuevo.getConfederacion());
            this.listar().get(posicion).setNombre(equipoNuevo.getNombre());
            this.listar().get(posicion).setGastos(equipoNuevo.getGastos());
            this.listar().get(posicion).setPropietario(equipoNuevo.getPropietario());
            this.listar().get(posicion).setnJugadores(equipoNuevo.getnJugadores());         
            return equipoNuevo;
        }
        else
        {
            throw new RuntimeException("No se ha encontrado un equipo con ese código");
        }
        
    }

    @Override
    public Equipo eliminar(int codigoEquipo) {
        if (exist(codigoEquipo) == true)
        {
        Equipo equipo=this.buscarPorCodigo(codigoEquipo);
        var posicion=this.buscarPosicion(equipo);
        this.listar().remove(posicion);
        return equipo;
        }
        else
        {
            throw new RuntimeException("No se ha encontrado un equipo con ese código");
        }
    }

    @Override
    public Equipo buscarPorCodigo(int codigoEquipo) {
        Equipo equipo=null;
        for(var b:this.listEquipo){
            if(codigoEquipo==b.getCodigo()){
                equipo=b;
                break;
            }
        }
        return equipo;
    }

    @Override
    public int buscarPosicion(Equipo equipo) {
         int posicion=-1;
        for(var b:this.listEquipo){
            posicion++;
            if(b.getCodigo()==equipo.getCodigo()){
                break;
            }
        }
        return posicion;
    }

    @Override
    public int count() {
        return listEquipo.size();
    }
    
    public boolean exist(int codigo)
    {
        boolean result = false;
        for (Equipo e : listEquipo)
        {
            if (e.getCodigo() == codigo)
            {
                result = true;
                break; 
            }            
        }
        return result;
    }
    public boolean exist(int codigo, String nombre)
    {
        boolean result = false;
        for (Equipo e : listEquipo)
        {
            if (e.getCodigo() == codigo)
            {
                result = true;
                break; 
            }
            else if (e.getNombre().equals(nombre))
            {
                result  = true;
                break;
            }
        }
        return result;
    }
    

 
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import java.util.ArrayList;
import java.util.List;
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
        this.listEquipo.add(equipo);
        return equipo;
    }

    @Override
    public List<Equipo> listar() {
        return this.listEquipo;
    }

    @Override
    public Equipo modificar(int codigoEquipo, Equipo equipoNuevo) {
      var posicion=this.buscarPosicion(this.buscarPorCodigo(codigoEquipo));
        this.listar().get(posicion).setConfederacion(equipoNuevo.getConfederacion());
        this.listar().get(posicion).setNombre(equipoNuevo.getNombre());
        this.listar().get(posicion).setGastos(equipoNuevo.getGastos());
        this.listar().get(posicion).setPropietario(equipoNuevo.getPropietario());
         this.listar().get(posicion).setnJugadores(equipoNuevo.getnJugadores());
         
        return equipoNuevo;

    }

    @Override
    public Equipo eliminar(int codigoEquipo) {
        Equipo equipo=this.buscarPorCodigo(codigoEquipo);
        var posicion=this.buscarPosicion(equipo);
        this.listar().remove(posicion);
        return equipo;
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

 
    
}

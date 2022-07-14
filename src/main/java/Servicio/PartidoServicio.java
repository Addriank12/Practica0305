/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import java.util.ArrayList;
import java.util.List;
import modelo.Partido;

/**
 *
 * @author Adrian
 */
public class PartidoServicio implements IPartido
{
    private List<Partido> listPartido;
    public PartidoServicio()
    {
        listPartido =new ArrayList<>();
    }

    @Override
    public Partido crear(Partido partido) {
         if (partido.getVisitante()== partido.getLocal())
            {
                throw new RuntimeException("El equipo local y visitante no pueden ser iguales");
            }  
        if (exist(partido.getCodigo()) == false)
        {
            this.listPartido.add(partido);
            return partido;
        }
        else{
            throw new RuntimeException("Ya existe un partido con ese código");
        }
        
    }

    @Override
    public List<Partido> listar() {
        return this.listPartido;
    }
    
      @Override
    public Partido modificar(int codigoPartido, Partido partidoNuevo) {
        if (exist(codigoPartido) == true)
        {
        var posicion=this.buscarPosicion(this.buscarPorCodigo(codigoPartido));
        this.listar().get(posicion).setArbitro(partidoNuevo.getArbitro());
        this.listar().get(posicion).setFecha(partidoNuevo.getFecha());
        this.listar().get(posicion).setDuracion(partidoNuevo.getDuracion());
        this.listar().get(posicion).setLocal(partidoNuevo.getLocal());        
        this.listar().get(posicion).setSede(partidoNuevo.getSede());
        this.listar().get(posicion).setVisitante(partidoNuevo.getVisitante());
        return partidoNuevo;
        }
        else
        {
            throw new RuntimeException("No se ha encontrado un jugador con ese código");
        }
    }

    @Override
    public Partido eliminar(int codigoPartido) {
        if (exist(codigoPartido) == true)
        {
        Partido partido=this.buscarPorCodigo(codigoPartido);
        var posicion=this.buscarPosicion(partido);
        this.listar().remove(posicion);
        return partido;
        }
        else
        {
            throw new RuntimeException("No se ha encontrado un jugador con ese código");
        }
    }

    @Override
    public Partido buscarPorCodigo(int codigoPartido) {
        Partido partido=null;
        for(var b:this.listPartido){
            if(codigoPartido==b.getCodigo()){
                partido=b;
                break;
            }
        }
        return partido;
    }

    @Override
    public int buscarPosicion(Partido partido) {
         int posicion=-1;
        for(var b:this.listPartido){
            posicion++;
            if(b.getCodigo()==partido.getCodigo()){
                break;
            }
        }
        return posicion;
    }
    
    private boolean exist(int codigo)
    {
        boolean result = false;
        for (Partido e : listPartido)
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

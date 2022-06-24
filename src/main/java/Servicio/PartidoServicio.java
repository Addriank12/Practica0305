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
        this.listPartido.add(partido);
        return partido;
    }

    @Override
    public List<Partido> listar() {
        return this.listPartido;
    }
    
      @Override
    public Partido modificar(int codigoJugador, Partido partidoNuevo) {
      var posicion=this.buscarPosicion(this.buscarPorCodigo(codigoJugador));
        this.listar().get(posicion).setArbitro(partidoNuevo.getArbitro());
        this.listar().get(posicion).setFecha(partidoNuevo.getFecha());
        this.listar().get(posicion).setDuracion(partidoNuevo.getDuracion());
        this.listar().get(posicion).setLocal(partidoNuevo.getLocal());        
        this.listar().get(posicion).setSede(partidoNuevo.getSede());
        this.listar().get(posicion).setVisitante(partidoNuevo.getVisitante());
        return partidoNuevo;

    }

    @Override
    public Partido eliminar(int codigoPartido) {
        Partido partido=this.buscarPorCodigo(codigoPartido);
        var posicion=this.buscarPosicion(partido);
        this.listar().remove(posicion);
        return partido;
    }

    @Override
    public Partido buscarPorCodigo(int codigoPartido) {
        Partido jugador=null;
        for(var b:this.listPartido){
            if(codigoPartido==b.getCodigo()){
                jugador=b;
                break;
            }
        }
        return jugador;
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
}

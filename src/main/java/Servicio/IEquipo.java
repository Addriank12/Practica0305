/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servicio;

import java.io.IOException;
import java.util.List;
import modelo.Equipo;

/**
 *
 * @author Adrian
 */
public interface IEquipo {
    public Equipo crear(Equipo equipo);
    public List<Equipo> listar() throws IOException;
    public Equipo modificar(int codigoEquipo, Equipo equipoNuevo) throws IOException;
    public Equipo eliminar(int codigoEquipo) throws IOException;
    public Equipo buscarPorCodigo(int codigoEquipo);
    public int buscarPosicion(Equipo equipo);
    public int count() throws IOException;   
}

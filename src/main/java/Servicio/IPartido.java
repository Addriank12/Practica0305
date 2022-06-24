/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servicio;

import java.util.List;
import modelo.Partido;

/**
 *
 * @author Adrian
 */
public interface IPartido {
    public Partido crear(Partido partido);
    public List<Partido> listar();
      public Partido modificar(int codigoBarco, Partido barcoNuevo);
    public Partido eliminar(int codigoBarco);
    public Partido buscarPorCodigo(int codigoBarco);
    public int buscarPosicion(Partido barco);
}

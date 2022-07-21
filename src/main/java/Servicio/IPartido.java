/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servicio;

import java.io.IOException;
import java.util.List;
import modelo.Partido;

/**
 *
 * @author Adrian
 */
public interface IPartido {
    public Partido crear(Partido partido);
    public List<Partido> listar() throws IOException;
    public Partido modificar(int codigoBarco, Partido barcoNuevo) throws IOException;
    public Partido eliminar(int codigoBarco) throws IOException;
    public Partido buscarPorCodigo(int codigoBarco);
    public int buscarPosicion(Partido barco);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servicio;

import java.io.IOException;
import java.util.List;
import modelo.Jugador;

/**
 *
 * @author Adrian
 */
public interface IJugador {
    public Jugador crear(Jugador jugador, boolean rl);
    public List<Jugador> listar() throws IOException;
    public Jugador modificar(int codigoBarco, Jugador barcoNuevo) throws IOException;
    public Jugador eliminar(int codigoBarco) throws IOException;
    public Jugador buscarPorCodigo(int codigoBarco);
    public int buscarPosicion(Jugador barco);
}

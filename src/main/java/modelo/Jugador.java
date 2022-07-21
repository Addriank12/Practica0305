/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author Adrian
 */
public class Jugador implements Serializable{
    private int codigo;
    private String nombre;
    private String nacionalidad;
    private int dorsal;
    private String posicion;
    private int edad;
    private String cedula;
    private Equipo equipo;

    public Jugador(int codigo, String nombre, String nacionalidad, int dorsal, String posicion, int edad, String cedula, Equipo equipo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.dorsal = dorsal;
        this.posicion = posicion;
        this.edad = edad;
        this.cedula = cedula;
        this.equipo = equipo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Jugador{" + "codigo=" + codigo + ", nombre=" + nombre + ", nacionalidad=" + nacionalidad + ", dorsal=" + dorsal + ", posicion=" + posicion + ", edad=" + edad + ", cedula=" + cedula + ", equipo=" + equipo + '}';
    }

    
    
    
}

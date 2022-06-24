/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author Adrian
 */
public class Partido
{
    private int codigo;
    private Date fecha;
    private int duracion;
    private String sede;
    private String arbitro;
    private Equipo local;
    private Equipo visitante;

    public Partido(int codigo, Date fecha, int duracion, String sede, String arbitro, Equipo local, Equipo visitante) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.duracion = duracion;
        this.sede = sede;
        this.arbitro = arbitro;
        this.local = local;
        this.visitante = visitante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getArbitro() {
        return arbitro;
    }

    public void setArbitro(String arbitro) {
        this.arbitro = arbitro;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }

    @Override
    public String toString() {
        return "Partido{" + "codigo=" + codigo + ", fecha=" + fecha + ", duracion=" + duracion + ", sede=" + sede + ", arbitro=" + arbitro + ", local=" + local + ", visitante=" + visitante + '}';
    }

    
}

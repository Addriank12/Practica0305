/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Equipo;
import modelo.Jugador;

/**
 *
 * @author Adrian
 */
public class JugadorServicio implements IJugador {
    private List<Jugador> listJugador;
    private String folder;
    
    public JugadorServicio() throws IOException
    {
        folder = "C:/Equipo";
        listJugador= new ArrayList<>();
        listJugador = listar();

    }

    @Override
    public Jugador crear(Jugador jugador, boolean rl) 
    {
        try {
            if (exist(jugador.getCodigo()) == false)
            {
                String path = folder + "/Jugador.txt";
                ObjectOutputStream archivo = null;
                try {
                    archivo = new ObjectOutputStream(new FileOutputStream(path,true));
                    archivo.writeObject(jugador);
                    archivo.close();
                } catch (IOException e) {
                    archivo.close();
                }
                if (rl == true) this.listJugador = listar();
                return jugador;
            }
            else
            {
                throw new RuntimeException("Ya existe un jugador con este código.");
            }
        } catch (IOException ex) {
            Logger.getLogger(EquipoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (RuntimeException e)
        {
            throw new RuntimeException("Ya existe un jugador con este código.");
        }
        return jugador;        
    }

    @Override
    public List<Jugador> listar() throws IOException{
        String path = folder + "/Jugador.txt";  
        if (new File(path).exists() == true)
        {
            var jugadorList = new ArrayList<Jugador>();        
            FileInputStream file = new FileInputStream(path);
            ObjectInputStream archivo = null;
            try{
                while(file.available()>0)
                {
                    archivo = new ObjectInputStream(file);
                    Jugador computador = (Jugador) archivo.readObject(); 
                    jugadorList.add(computador);
                }    
                if (archivo != null) archivo.close();            
                file.close();
            }catch(IOException e){
                archivo.close();
                file.close();
            } catch (ClassNotFoundException ex) {        
                Logger.getLogger(EquipoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return jugadorList; 
        }
        else{
            return null;
        }
    }

  @Override
    public Jugador modificar(int codigoJugador, Jugador jugadorNuevo) throws IOException{
        
        if (exist(codigoJugador) == true)
        {
            
            var jugadores = listar();         
            var posicion=this.buscarPosicion(this.buscarPorCodigo(codigoJugador));
            jugadores.get(posicion).setCedula(jugadorNuevo.getCedula());
            jugadores.get(posicion).setNacionalidad(jugadorNuevo.getNacionalidad());
            jugadores.get(posicion).setEdad(jugadorNuevo.getEdad());
            jugadores.get(posicion).setDorsal(jugadorNuevo.getDorsal());        
            jugadores.get(posicion).setNombre(jugadorNuevo.getNombre());
            jugadores.get(posicion).setPosicion(jugadorNuevo.getPosicion());            
            listJugador = jugadores;
            replaceFile();
            return jugadorNuevo;            
        }
        else
        {
            throw new RuntimeException("No se ha encontrado un equipo con ese código");
        }      

    }
    
       public void replaceFile() throws IOException
    {
        String file_name = folder + "/Jugador.txt";
        Path path = Paths.get(file_name);
        try {
            Files.delete(path);
            for (int i = 0; i < listJugador.size(); i++)
            {
            crear(listJugador.get(i), false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        listJugador = listar();        
    }

    @Override
    public Jugador eliminar(int codigoJugador) throws IOException{
        if (exist(codigoJugador) == true)
        {
        Jugador equipo=this.buscarPorCodigo(codigoJugador);
        var posicion=this.buscarPosicion(equipo);        
        listJugador.remove(posicion);
            replaceFile();
        return equipo;
        }
        else
        {
            throw new RuntimeException("No se ha encontrado un equipo con ese código");
        }
    }

    @Override
    public Jugador buscarPorCodigo(int codigoJugador) {
        Jugador jugador=null;
        for(var b:this.listJugador){
            if(codigoJugador==b.getCodigo()){
                jugador=b;
                break;
            }
        }
        return jugador;
    }

    @Override
    public int buscarPosicion(Jugador jugador) {
         int posicion=-1;
        for(var b:this.listJugador){
            posicion++;
            if(b.getCodigo()==jugador.getCodigo()){
                break;
            }
        }
        return posicion;
    }
    
    private boolean exist(int codigo) throws IOException
    {
        var a = listar();
        if (a == null) return false;
        boolean result = false;
        for (Jugador e : a)
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

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
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Equipo;

/**
 *
 * @author Adrian
 */
public class EquipoServicio implements IEquipo {
    private List<Equipo> listEquipo;
    private String folder;
    
    public EquipoServicio() throws IOException
    {
        folder = "C:/Equipo";
        listEquipo= new ArrayList<>();
        listEquipo = listar();        
    }
    @Override
    public Equipo crear(Equipo equipo) {
        try {
            if (exist(equipo.getCodigo(), equipo.getNombre()) == false)
            {
                String path = folder + "/Equipo.txt";
                ObjectOutputStream archivo = null;
                try {
                    archivo = new ObjectOutputStream(new FileOutputStream(path,true));
                    archivo.writeObject(equipo);
                    archivo.close();
                } catch (IOException e) {
                    archivo.close();
                }
                this.listEquipo = listar();
                return equipo;
            }
            else
            {
                throw new RuntimeException("Ya existe un equipo con este código.");
            }
        } catch (IOException ex) {
            Logger.getLogger(EquipoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (RuntimeException e)
        {
            throw new RuntimeException("Ya existe un equipo con este código.");
        }
        return equipo;
    }

    @Override
    public List<Equipo> listar() throws IOException{
        String path = folder + "/Equipo.txt";  
        if (new File(path).exists() == true)
        {
           var computadorList = new ArrayList<Equipo>();        
        FileInputStream file = new FileInputStream(path);
        ObjectInputStream archivo = null;
        try{
            while(file.available()>0)
            {
                archivo = new ObjectInputStream(file);
                Equipo computador = (Equipo) archivo.readObject(); 
                computadorList.add(computador);
            }    
            if (archivo != null) archivo.close();            
            file.close();
        }catch(IOException e){
            archivo.close();
            file.close();
        } catch (ClassNotFoundException ex) {        
            Logger.getLogger(EquipoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return computadorList; 
        }
        else{
            return null;
        }
        
    }

    @Override
    public Equipo modificar(int codigoEquipo, Equipo equipoNuevo) throws IOException{
        if (exist(codigoEquipo) == true)
        {
            var equipos = listar();
            var posicion=this.buscarPosicion(this.buscarPorCodigo(codigoEquipo));
            equipos.get(posicion).setConfederacion(equipoNuevo.getConfederacion());
            equipos.get(posicion).setNombre(equipoNuevo.getNombre());
            equipos.get(posicion).setGastos(equipoNuevo.getGastos());
            equipos.get(posicion).setPropietario(equipoNuevo.getPropietario());
            equipos.get(posicion).setnJugadores(equipoNuevo.getnJugadores());   
            listEquipo = equipos;
            replaceFile();
            return equipoNuevo;            
        }
        else
        {
            throw new RuntimeException("No se ha encontrado un equipo con ese código");
        }
        
    }
    
    public void replaceFile() throws IOException
    {
        String file_name = folder + "/Equipo.txt";
        Path path = Paths.get(file_name);
        try {
            Files.delete(path);
            for (int i = 0; i < listEquipo.size(); i++)
            {
            crear(listEquipo.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        listEquipo = listar();        
    }

    @Override
    public Equipo eliminar(int codigoEquipo) throws IOException{
        if (exist(codigoEquipo) == true)
        {
        Equipo equipo=this.buscarPorCodigo(codigoEquipo);
        var posicion=this.buscarPosicion(equipo);        
        listEquipo.remove(posicion);
            replaceFile();
        return equipo;
        }
        else
        {
            throw new RuntimeException("No se ha encontrado un equipo con ese código");
        }
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
        if (listEquipo == null)
        {
            return 0;
        }
        else{
        return listEquipo.size();
        }
    }
    
    public boolean exist(int codigo) throws IOException
    {
        var a = listar();
        if (a == null) return false;
        boolean result = false;
        for (Equipo e : a)
        {
            if (e.getCodigo() == codigo)
            {
                result = true;
                break; 
            }            
        }
        return result;
    }
    public boolean exist(int codigo, String nombre) throws IOException
    {
        var a = listar();
        if (a == null) return false;
        boolean result = false;
        for (Equipo e : a)
        {
            if (e.getCodigo() == codigo)
            {
                result = true;
                break; 
            }
            else if (e.getNombre().equals(nombre))
            {
                result  = true;
                break;
            }
        }
        return result;
    }
    

 
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import modelo.Partido;

/**
 *
 * @author Adrian
 */
public class PartidoServicio implements IPartido
{
    private List<Partido> listPartido;
    private String folder;
    public PartidoServicio() throws IOException
    {
        folder = "C:/Equipo";
        listPartido= new ArrayList<>();
        listPartido = listar();
    }

    @Override
    public Partido crear(Partido partido, boolean rl) {
         try {
            if (exist(partido.getCodigo()) == false)
            {
                String path = folder + "/Partido.txt";
                ObjectOutputStream archivo = null;
                try {
                    archivo = new ObjectOutputStream(new FileOutputStream(path,true));
                    archivo.writeObject(partido);
                    archivo.close();
                } catch (IOException e) {
                    archivo.close();
                }
                if (rl == true) this.listPartido = listar();
                return partido;
            }
            else
            {
                throw new RuntimeException("Ya existe un partido con este código.");
            }
        } catch (IOException ex) {
            Logger.getLogger(EquipoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (RuntimeException e)
        {
            throw new RuntimeException("Ya existe un partido con este código.");
        }
        return partido;        
    }

    @Override
    public List<Partido> listar() throws IOException {
        String path = folder + "/Partido.txt";  
        if (new File(path).exists() == true)
        {
           var computadorList = new ArrayList<Partido>();        
        FileInputStream file = new FileInputStream(path);
        ObjectInputStream archivo = null;
        try{
            while(file.available()>0)
            {
                archivo = new ObjectInputStream(file);
                Partido computador = (Partido) archivo.readObject(); 
                computadorList.add(computador);
            }    
            if (archivo != null) archivo.close();            
            file.close();
        }catch(IOException e){
            archivo.close();
            file.close();
        } catch (ClassNotFoundException ex) {        
            Logger.getLogger(PartidoServicio.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return computadorList; 
        }
        else{
            return null;
        }
    }
    
      @Override
    public Partido modificar(int codigoPartido, Partido partidoNuevo) throws IOException {
        
        if (exist(codigoPartido) == true)
        {
            var partidos = listar();
            var posicion=this.buscarPosicion(this.buscarPorCodigo(codigoPartido));
            partidos.get(posicion).setArbitro(partidoNuevo.getArbitro());
            partidos.get(posicion).setFecha(partidoNuevo.getFecha());
            partidos.get(posicion).setDuracion(partidoNuevo.getDuracion());
            partidos.get(posicion).setLocal(partidoNuevo.getLocal());        
            partidos.get(posicion).setSede(partidoNuevo.getSede());
            partidos.get(posicion).setVisitante(partidoNuevo.getVisitante());  
            listPartido = partidos;
            replaceFile();
            return partidoNuevo;            
        }
        else
        {
            throw new RuntimeException("No se ha encontrado un partido con ese código");
        }        
    }
    
    public void replaceFile() throws IOException
    {
        String file_name = folder + "/Partido.txt";
        Path path = Paths.get(file_name);
        try {
            Files.delete(path);
            for (int i = 0; i < listPartido.size(); i++)
            {
            crear(listPartido.get(i), false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        listPartido = listar();        
    }

    @Override
    public Partido eliminar(int codigoPartido) throws IOException {
         if (exist(codigoPartido) == true)
        {
        Partido partido=this.buscarPorCodigo(codigoPartido);
        var posicion=this.buscarPosicion(partido);        
        listPartido.remove(posicion);
            replaceFile();
        return partido;
        }
        else
        {
            throw new RuntimeException("No se ha encontrado un partido con ese código");
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
    
    private boolean exist(int codigo) throws IOException
    {
        var a = listar();
        if (a == null) return false;
        boolean result = false;
        for (Partido e : a)
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


package com.mycompany.practica_05;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;


public class Gestion {
    
    
    private ArrayList<Medico> listamedicos;
    
    
    public void Gestion(){
        listamedicos = new ArrayList<>();
        
    }
     
    public  void crearMedico() {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del Médico:    ");
        int codigounico = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del Médico:    "));
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del Médico:    "));
        int telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el teléfono del Médico:    "));
        
    String[] especialidades = {"Pediatria", "Cardiologia", "Oncologia", "Neurologia"}; 
    int especialidadLista = JOptionPane.showOptionDialog(null, "Seleccione una especialidad",
            "Especialidad", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, especialidades, especialidades[0]);    
       
    Especialidad especialidad = Especialidad.values()[especialidadLista];
    
    Medico nuevoMedico = new Medico(nombre, especialidad, codigounico, edad, telefono);
    
    JOptionPane.showMessageDialog(null, "Médico creado exitosamente.");
    
      
    this.listamedicos.add(nuevoMedico);
    
    }
  
    public void editarMedico(){
    int codigoopcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código del Médico a editar:    "));
    Medico medico = buscarmedicocodigo(codigoopcion);
    
    if (medico !=null){
        String nombrenuevo = JOptionPane.showInputDialog("Ingrese el nuevo nombre del medico:    ");
        int edadnueva = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva edad del medico:    "));
        int telefononuevo = Integer.parseInt(JOptionPane.showInputDialog("Ingreseel nuevo telefono del medico:    "));
        
       String[] especialidades = {"Pediatria", "Cardiologia", "Oncologia", "Neurologia"}; 
    int especialidadLista = JOptionPane.showOptionDialog(null, "Seleccione una especialidad",
            "Especialidad", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, especialidades, especialidades[0]);
    
    medico.setNombre(nombrenuevo);
    medico.setEdad(edadnueva);
    medico.setTelefono(telefononuevo);
    medico.setEspecialidad(Especialidad.values()[especialidadLista]);
    
        JOptionPane.showMessageDialog(null,"Medico actualizado correctamente");
    }else{
        JOptionPane.showMessageDialog(null,"No se encontro medico,ingrese otro codigo");
    }
    }
    
    private Medico buscarmedicocodigo(int codigo) {
        for (Medico medico : this.listamedicos) {
            if (medico.getCodigo_unico() == codigo) {
                return medico;
            }
        }
        return null;
    }
    
    
}

    

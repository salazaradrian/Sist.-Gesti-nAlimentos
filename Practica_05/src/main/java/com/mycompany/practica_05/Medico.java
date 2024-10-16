
package com.mycompany.practica_05;


public class Medico {
    
    private String nombre;
    private Especialidad especialidad;
    private int codigo_unico;
    private int edad;
    private int telefono;

    public Medico(String nombre, Especialidad especialidad, int codigo_unico, int edad, int telefono) {
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.codigo_unico = codigo_unico;
        this.edad = edad;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public int getCodigo_unico() {
        return codigo_unico;
    }

    public void setCodigo_unico(int codigo_unico) {
        this.codigo_unico = codigo_unico;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Medico{" + "nombre=" + nombre + ", especialidad=" + especialidad + ", codigo_unico=" + codigo_unico + ", edad=" + edad + ", telefono=" + telefono + '}';
    }
  
    
    
}

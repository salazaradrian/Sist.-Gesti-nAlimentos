package com.mycompany.sist.gestionalimentos;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Alimentos {

    private int id;
    private String nombre;
    private String tipo;
    private double calorias;
    private double precio;
    private Estado estado;

    //CREAR ALIMENTO
    public Alimentos(String nombre, String tipo, double calorias, double precio, Estado estado) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.calorias = calorias;
        this.precio = precio;
        this.estado = estado;
    }

    //MODIFICAR ALIMENTO
    public Alimentos(int id, String nombre, String tipo, double calorias, double precio, Estado estado) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.calorias = calorias;
        this.precio = precio;
        this.estado = estado;
    }

    public Alimentos(int id) {
        this.id = id;
    }

    public void agregar() {
        
        if (!validarDatos()) {
            return;
        }
        
        Conexion conexion = new Conexion();

        String sql = "INSERT INTO alimentos (Nombre, Tipo, Calorias, Precio, Estado) VALUES (?, ?, ?, ?, ?)";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.nombre);
            cs.setString(2, this.tipo);
            cs.setDouble(3, this.calorias);
            cs.setDouble(4, this.precio);
            cs.setString(5, this.estado.toString());

            cs.execute();

            JOptionPane.showMessageDialog(null, "El registro se ha guardado de manera exitosa");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar el registro");
            System.out.println("Error Consulta: " + ex.toString());
        } finally {
            conexion.desconectar();
        }
    }

    public static DefaultTableModel consultar() {

        Conexion conexion = new Conexion();
        DefaultTableModel modelo = new DefaultTableModel() {

            // Hacer que la tabla no sea editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("Calorias");
        modelo.addColumn("Precio");
        modelo.addColumn("Estado");

        String datos[] = new String[6];
        try {
            Statement stmt = conexion.conectar().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM alimentos");

            while (rs.next()) {
                datos[0] = String.valueOf(rs.getInt("ID"));
                datos[1] = rs.getString("Nombre");
                datos[2] = rs.getString("Tipo");
                datos[3] = String.valueOf(rs.getDouble("Calorias"));
                datos[4] = "$" + String.valueOf(rs.getDouble("Precio"));
                datos[5] = rs.getString("Estado");

                modelo.addRow(datos);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar los registros");
            System.out.println("Error Consulta: " + ex.toString());
        } finally {
            conexion.desconectar();
        }

        return modelo;
    }

    public void editar() {
        
        if (!validarDatos()) {
            return;
        }

        Conexion conexion = new Conexion();

        String sql = "UPDATE alimentos SET Nombre = ?, tipo = ?, Calorias = ?, precio = ?, estado = ? WHERE id = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setString(1, this.nombre);
            cs.setString(2, this.tipo);
            cs.setDouble(3, this.calorias);
            cs.setDouble(4, this.precio);
            cs.setString(5, this.estado.toString());
            cs.setInt(6, this.id);

            cs.execute();

            JOptionPane.showMessageDialog(null, "El registro se a editado de manera exitosa");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al editar el registros");
            System.out.println("Error Consulta: " + ex.toString());
        } finally {
            conexion.desconectar();
        }
    }

    public void eliminar() {
        Conexion conexion = new Conexion();

        String sql = "DELETE FROM alimentos WHERE id = ?";

        try {
            CallableStatement cs = conexion.conectar().prepareCall(sql);

            cs.setInt(1, this.id);

            cs.execute();

            JOptionPane.showMessageDialog(null, "El resistro se a eliminado de manera exitosa");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registros");
            System.out.println("Error Consulta: " + ex.toString());
        } finally {
            conexion.desconectar();
        }
    }

    public boolean validarDatos() {
        if (nombre == null) {
            JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío.");
            return false;
        }
        if (tipo == null) {
            JOptionPane.showMessageDialog(null, "El tipo no puede estar vacío.");
            return false;
        }
        if (calorias < 0) {
            JOptionPane.showMessageDialog(null, "Las calorías no pueden ser negativas.");
            return false;
        }
        if (precio <= 0) {
            JOptionPane.showMessageDialog(null, "El precio debe ser un valor mayor a 0.");
            return false;
        }

        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}

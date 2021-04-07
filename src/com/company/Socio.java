package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Socio {

    private String nombre;
    private String telefono;
    private String documento;
    private int sede;
    private int plan;

    private String dbName = "gimnasio";
    private String dbUser = "root";
    private String dbPwd = "Ada2020+";

    public Socio(String nombre, String telefono, String documento, int sede, int plan) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.documento = documento;
        this.sede = sede;


        try {
            setPlan(plan);
        } catch (DatosIncorrectosException e) {
            System.out.println(e.getMessage());
            this.plan = 3;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    public Socio() throws DatosIncorrectosException {
        this.nombre = "";
        this.telefono = "";
        this.documento = "";
        this.sede = 0;
        this.plan = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getSede() {
        return sede;
    }

    public void setSede(int sede) {
        this.sede = sede;
    }

    public int getPlan() {
        return plan;
    }

    public void setPlan(int plan) throws DatosIncorrectosException, SQLException {
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos(dbName, dbUser, dbPwd);
        String nombre = this.getNombre().toUpperCase().substring(0, 1);
        String consulta = "SELECT id FROM gimnasio.planes WHERE nombre LIKE '%promo%' ";
        ResultSet resultados = conexionBaseDeDatos.consultar(consulta);

        if (resultados != null) {
            while (resultados.next()) {
                int id =  resultados.getInt("id");

                if (plan == id && !(nombre.startsWith("A") || nombre.startsWith("B") ||
                        nombre.startsWith("C") || nombre.startsWith("D"))) {
                    throw new DatosIncorrectosException("No se puede crear este socio xq su nombre no inicia con A,B,C o D por defecto se le agregara el plan mensual.");
                }
            }
        }


        this.plan = plan;
    }
}

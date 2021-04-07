package com.company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Gimnasio {

    private String dbName = "gimnasio";
    private String dbUser = "root";
    private String dbPwd = "Ada2020+";

    public void agregarSocio(Socio socio) {
        String nombre = socio.getNombre();
        String telefono = socio.getTelefono();
        String documento = socio.getDocumento();
        int sucursal = socio.getSede();
        int plan = socio.getPlan();

        boolean isInsertado = validarDocumento(documento);
        System.out.println(isInsertado);
        if (!isInsertado) {
            ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos(dbName, dbUser, dbPwd);
            String sql = "INSERT INTO socios (nombre, telefono, documento, idSucursal, plan) VALUES ('" +
                    nombre + "','" + telefono + "','" + documento + "','" + sucursal + "','" + plan + "');";
            boolean respuesta = false;
            try {
                respuesta = conexionBaseDeDatos.insertar(sql);
            } catch (SQLException e) {
                System.out.println("No se pudo agregar al socio.");
            } finally {
                conexionBaseDeDatos.cerrar();
            }
        } else {
            System.out.println("No se puede agregar este socio porque ya existe uno con ese documento");
        }
    }

    public void buscarYMostrarSocioSede(String sql) {
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos(dbName, dbUser, dbPwd);
        ResultSet resultados = conexionBaseDeDatos.consultar(sql);
        try {
            mostrarResultadosSocioSede(resultados);
        } catch (SQLException e) {
            System.out.println("No se encontraron resultados.ñ");
        } finally {
            conexionBaseDeDatos.cerrar();
        }
    }

    public void buscarYMostrarSocioPlan(String sql) {
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos(dbName, dbUser, dbPwd);
        ResultSet resultados = conexionBaseDeDatos.consultar(sql);
        try {
            mostrarResultadosSocioPlan(resultados);
        } catch (SQLException e) {
            System.out.println("No se encontraron resultados.");
        } finally {
            conexionBaseDeDatos.cerrar();
        }
    }

    private void mostrarResultadosSocioSede(ResultSet resultados) throws SQLException {
        if (resultados != null) {
            while (resultados.next()) {
                System.out.println(" Nombre: " + resultados.getString("socios.nombre") + " Nombre de Sucursal: " + resultados.getString("sucursales.nombre") + " Id de sucursal: " + resultados.getString("sucursales.id"));
            }
        }
    }

    private void mostrarResultadosSocioPlan(ResultSet resultados) throws SQLException {
        if (resultados != null) {
            while (resultados.next()) {
                System.out.println(" Nombre: " + resultados.getString("socios.nombre") + " Nombre del plan: " + resultados.getString("planes.nombre") + " Id del plan: " + resultados.getString("planes.id"));
            }
        }
    }

    public void listarSociosDeSede(int sucursalId) {
        buscarYMostrarSocioSede("SELECT socios.nombre, sucursales.nombre, sucursales.id FROM socios INNER JOIN gimnasio.sucursales ON socios.idSucursal= sucursales.id WHERE sucursales.id = " + sucursalId);
    }

    public void listarSociosDePlan(int idPlan) {
        buscarYMostrarSocioPlan("SELECT socios.nombre, planes.nombre, planes.id FROM socios INNER JOIN gimnasio.planes ON planes.id= socios.plan WHERE planes.id = " + idPlan);
    }

    public boolean validarDocumento(String documento) {
        ConexionBaseDeDatos conexionBaseDeDatos = new ConexionBaseDeDatos(dbName, dbUser, dbPwd);
        String consulta = "SELECT documento FROM socios WHERE documento =" + documento;
        ResultSet resultados = conexionBaseDeDatos.consultar(consulta);

        if (resultados != null) {
            try {
                return resultados.next();
            } catch (SQLException throwables) {
                System.out.println(throwables.getMessage());
                return false;
            }
        }
        return false;
    }
}

package com.example.cardalm;

public class Vehiculo {
    public int IdVehiculo;
    public String Marca;
    public int IdFabricante;
    public String Modelo;
    public int AnioVehiculo;
    public int Cilindraje;
    public String Combustible;

    public Vehiculo() {
    }

    public int getIdVehiculo() {
        return IdVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        IdVehiculo = idVehiculo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public int getIdFabricante() {
        return IdFabricante;
    }

    public void setIdFabricante(int idFabricante) {
        IdFabricante = idFabricante;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public int getAnioVehiculo() {
        return AnioVehiculo;
    }

    public void setAnioVehiculo(int anioVehiculo) {
        AnioVehiculo = anioVehiculo;
    }

    public int getCilindraje() {
        return Cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        Cilindraje = cilindraje;
    }

    public String getCombustible() {
        return Combustible;
    }

    public void setCombustible(String combustible) {
        Combustible = combustible;
    }
}

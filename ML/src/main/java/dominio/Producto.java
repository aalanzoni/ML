/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;
/**
 *
 * @author Andres Lanzoni
 */


public class Producto{
    private Long id;
    private int sucursal;
    private String codigo;
    private String nombre;
    private String barra;
    private String nombreML;
    private String descripcion_corta;
    private String descripcion_larga;
    private int estado;//1 = OK
    private float precio;
    private float porciva;
    private float precio_con_iva;
    private float precio_promocion;
    private String moneda;
    private int categoria_pub;
    private int stock_min;
    private int stock_max;
    private int stock_real;
    private int stock_negativo;
    private String color;
    private String marca;
    private String modelo;
    
    public Producto(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBarra() {
        return barra;
    }

    public void setBarra(String barra) {
        this.barra = barra;
    }

    public String getNombreML() {
        return nombreML;
    }

    public void setNombreML(String nombreML) {
        this.nombreML = nombreML;
    }

    public String getDescripcion_corta() {
        return descripcion_corta;
    }

    public void setDescripcion_corta(String descripcion_corta) {
        this.descripcion_corta = descripcion_corta;
    }

    public String getDescripcion_larga() {
        return descripcion_larga;
    }

    public void setDescripcion_larga(String descripcion_larga) {
        this.descripcion_larga = descripcion_larga;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getPoriva() {
        return porciva;
    }

    public void setPoriva(float porciva) {
        this.porciva = porciva;
    }

    public float getPrecio_con_iva() {
        return precio_con_iva;
    }

    public void setPrecio_con_iva(float precio_con_iva) {
        this.precio_con_iva = precio_con_iva;
    }

    public float getPrecio_promocion() {
        return precio_promocion;
    }

    public void setPrecio_promocion(float precio_promocion) {
        this.precio_promocion = precio_promocion;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public int getCategoria_pub() {
        return categoria_pub;
    }

    public void setCategoria_pub(int categoria_pub) {
        this.categoria_pub = categoria_pub;
    }

    public int getStock_min() {
        return stock_min;
    }

    public void setStock_min(int stock_min) {
        this.stock_min = stock_min;
    }

    public int getStock_max() {
        return stock_max;
    }

    public void setStock_max(int stock_max) {
        this.stock_max = stock_max;
    }

    public int getStock_real() {
        return stock_real;
    }

    public void setStock_real(int stock_real) {
        this.stock_real = stock_real;
    }

    public int getStock_negativo() {
        return stock_negativo;
    }

    public void setStock_negativo(int stock_negativo) {
        this.stock_negativo = stock_negativo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}

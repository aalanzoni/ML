/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table; 

/**
 *
 * @author Andres Lanzoni
 */

@Entity
@Table(name="Producto")
public class Producto implements Serializable  {
    @Id
    @Column(name="id_producto")
    @GeneratedValue( generator = "generador_propietario_hibernate_increment" )
    @org.hibernate.annotations.GenericGenerator(
        name = "generador_propietario_hibernate_increment",
        strategy = "increment" 
    ) 
    private Long id;
    
    @Column(name="sucursal_producto")
    private int sucursal;
    
    @Column(name="codigo_producto")
    private String codigo;
    
    @Column(name="nombre_producto")
    private String nombre;
    
    @Column(name="barra_producto")
    private String barra;
    
    @Column(name="nombreML_producto")
    private String nombreML;
    
    @Column(name="descripcion_corta_producto")
    private String descripcion_corta;    
    
    @Column(name="descripcion_larga_producto")
    private String descripcion_larga;
    
    @Column(name="estado_producto")
    private int estado;//1 = OK
    
    @Column(name="precio_producto")
    private float precio;
    
    @Column(name="porciva_producto")
    private float porciva;
    
    @Column(name="precio_con_iva_producto")
    private float precio_con_iva;
    
    @Column(name="precio_promocion_producto")
    private float precio_promocion;
    
    @Column(name="moneda_producto")
    private String moneda;
    
    @Column(name="codcate_pub_producto")
    private String codigo_categoria_pub;
    
    @Column(name="nombcate_pub_producto")
    private String nombre_categoria_pub;
    
    @Column(name="stock_min_producto")
    private int stock_min;
    
    @Column(name="stock_max_producto")
    private int stock_max;
    
    @Column(name="stock_real_producto")
    private int stock_real;
    
    @Column(name="stock_negativo_producto")
    private int stock_negativo;
    
    @Column(name="color_producto")
    private String color;
    
    @Column(name="marca_producto")
    private String marca;
    
    @Column(name="modelo_producto")
    private String modelo;
    
    public Producto(){
        super();
    }

    public Producto(int sucursal, String codigo, String nombre) {
        this.sucursal = sucursal;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
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

    public String getCodigo_categoria_pub() {
        return codigo_categoria_pub;
    }

    public void setCodigo_categoria_pub(String codigo_categoria_pub) {
        this.codigo_categoria_pub = codigo_categoria_pub;
    }

    public String getNombre_categoria_pub() {
        return nombre_categoria_pub;
    }

    public void setNombre_categoria_pub(String nombre_categoria_pub) {
        this.nombre_categoria_pub = nombre_categoria_pub;
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


package crearFicheroConDom;

/**
 * @author alumnotd
 */
public class Coche {
    
    int id;
    String marca,modelo;
    int precio;

    public Coche() {
    }

    public Coche(int id, String marca, String modelo, int precio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Coche{" + "id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
}

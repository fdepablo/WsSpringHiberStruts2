package es;

public class VendedorCliente {
    
    private String nombreVendedor;
    private String nombreCliente;

    //Constructor para hibernate
    public VendedorCliente(String nv, String nc){
        nombreVendedor = nv;
        nombreCliente = nc;
    }
    
    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    
}

package ACT_1;

public class Producto {
	private String nombre;
	private double precio;
	private int cantidadStock;
	private String cat;
	
	public Producto(String n, double p, int s, String c) {
		this.nombre = n;
		this.precio = p;
		this.cantidadStock = s;
		this.cat = c;
	}
	
	public String getNombre() {return nombre;}
	public double getPrecio() {return precio;}
	public int getStock() {return cantidadStock;}
	public String getCategoria() {return cat;}
	
	public void setNombre(String nn) {nombre = nn;}
	public void setPrecio(double pp) {precio = pp;}
	public void setCantidadStock(int ss) {cantidadStock = ss;}
	public void setCategoria(String cc) {cat = cc;}
	
	@Override
	public String toString() {
		return "NOMBRE: "+nombre+" | PRECIO: "+precio+" | STOCK: "+cantidadStock+" | CATEGORIA: "+cat;
	}
}

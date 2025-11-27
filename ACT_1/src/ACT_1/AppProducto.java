package ACT_1;
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class AppProducto extends JFrame{
	private ArrayList<Producto> productos;
	
	public AppProducto() {
		super("Gestión de Producto");
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		productos = new ArrayList<>();
		productos.add(new Producto("Manzana", 2.5, 50, "Fruta"));
		productos.add(new Producto("Leche", 4.2, 30, "Lacteo"));
		productos.add(new Producto("Arroz", 3.0, 100, "Granos"));
		
		
		JTextField txtNombre = new JTextField(15);
		JTextField txtPrecio = new JTextField(15);
		JTextField txtStock = new JTextField(15);
		JTextField txtCategoria = new JTextField(15);
		
		JButton btnActualizar = new JButton("Actualizar Producto");
        JLabel lblInfo = new JLabel("Ingrese los datos del producto.");
		
		JTextArea areaInfo = new JTextArea(6, 25);
		areaInfo.setEditable(false);
		areaInfo.setText("INGRESE LOS DATOS DEL PRODUCTO");
		
		add(new JLabel("NOMBRE: "));
		add(txtNombre);
		add(new JLabel("PRECIO: "));
		add(txtPrecio);
		add(new JLabel("STOCK: "));
		add(txtStock);
		add(new JLabel("CATEGORIA: "));
		add(txtCategoria);
		
		add(btnActualizar);
		add(areaInfo);
        add(lblInfo);
		
		btnActualizar.addActionListener(e ->{
			String buscar = txtNombre.getText();
			boolean encontrado = false;
			
			for(Producto p : productos) {
				if(p.getNombre().equals(buscar)) {
					try {
						p.setPrecio(Double.parseDouble(txtPrecio.getText()));
						p.setCantidadStock(Integer.parseInt(txtStock.getText()));
						p.setCategoria(txtCategoria.getText());
						
						lblInfo.setText(p.toString());
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(this, "Datos inválidos, verifique todos los campos");
					}
					
					encontrado = true;
					break;
				}
			}
			
			if(encontrado) {
				JOptionPane.showMessageDialog(this, "PRODUCTO ENCONTRADO");
			}else {
				JOptionPane.showMessageDialog(this, "EL PRODUCTO NO SE PUDO ENCONTRAR");
			}

		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AppProducto();
	}
}

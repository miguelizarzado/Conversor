package conversor;

import javax.swing.JOptionPane;

import conversor.clases.Distancias;
import conversor.clases.Monedas;

public class Conversor {
	
	public static double convertirMonedas(Monedas origen, Monedas destino, double cantidad) {
		  
		double valorDestino = destino.multiplicar(cantidad);
		double valorOrigen = origen.getValor();
		double resultado = valorDestino / valorOrigen;
		return resultado;
		  
	}
	
	public static double convertirDistancias(Distancias origen, Distancias destino, double cantidad) {
		  
		double valorDestino = destino.multiplicar(cantidad);
		double valorOrigen = origen.getValor();
		double resultado = valorDestino / valorOrigen;
		return resultado;
		  
	}

	public static void main(String[] args) {
		
		//----------------MONEDAS----------------------
		Monedas dolar = new Monedas("dolar", "USD", 1);
		Monedas euro = new Monedas("euro", "EUR", 0.91);
		Monedas libra = new Monedas("libra", "GBP", 0.79);
		Monedas yen = new Monedas("yen", "JPY", 144.70);
		Monedas won = new Monedas("won", "KRW", 1193.13);
		Monedas peso = new Monedas("peso", "COP", 3957.97);
		
		//----------------DISTANCIAS----------------------
		Distancias kilometro = new Distancias ("kilometro", "km", 0.001);
		Distancias metro = new Distancias ("metro", "m", 1);
		Distancias centimetro = new Distancias ("centimetro", "cm", 1);
		Distancias milimetro = new Distancias ("milimetro", "mm", 1000);
		
		boolean repetir = true;
		
		while(repetir) {
		
			String[] tipo = {"Conversor de Divisas", "Conversor de distancias"}; 
			String seleccion = (String) JOptionPane.showInputDialog(
					null, 
					"Elige tu conversor", 
					"Conversor", 
					JOptionPane.YES_NO_CANCEL_OPTION,
					null, tipo,
				    tipo[0]
				    );
	
			if (seleccion == tipo[0]) {
				String[] divisa1 = {"USD", "EUR", "GBP", "JPY", "KRW", "COP"}; 
				String origen = (String)JOptionPane.showInputDialog(
						null, 
						"Elige la moneda que deseas convertir", 
						"Divisa actual", 
						JOptionPane.YES_NO_CANCEL_OPTION,
						null, divisa1,
					    divisa1[0]
					    );
				String[] divisa2 = {"USD", "EUR", "GBP", "JPY", "KRW", "COP"}; 
				String destino = (String)JOptionPane.showInputDialog(
						null, 
						"Elige la nueva moneda", 
						"Divisa destino", 
						JOptionPane.YES_NO_CANCEL_OPTION,
						null, divisa2,
					    divisa2[1]
					    );
				
				double cantidad = 0;
				boolean valido = false;
				
				while (!valido) {
				  try {
				    cantidad = Double.parseDouble(JOptionPane.showInputDialog(null,
									"Ingresa la cantidad de " + origen + " que desea convertir en "
				    + destino, "Ingresa cantidad", 1));
				    valido = true;
				  } catch (NumberFormatException e) {
				    JOptionPane.showMessageDialog(null, "Ingresa solo valores numéricos", "Error",
				    		JOptionPane.ERROR_MESSAGE);
				  }
				}
				
				Monedas moneda1 = new Monedas("", "", 0);
				switch (origen) {
					case "USD":
						moneda1 = dolar;
						break;
					case "EUR":
						moneda1 = euro;
						break;
					case "GBP":
						moneda1 = libra;
						break;
					case "JPY":
						moneda1 = yen;
						break;
					case "KRW":
						moneda1 = won;
						break;
					case "COP":
						moneda1 = peso;
						break;
				}
				Monedas moneda2 = new Monedas("", "", 0);
				switch (destino) {
					case "USD":
						moneda2 = dolar;
						break;
					case "EUR":
						moneda2 = euro;
						break;
					case "GBP":
						moneda2 = libra;
						break;
					case "JPY":
						moneda2 = yen;
						break;
					case "KRW":
						moneda2 = won;
						break;
					case "COP":
						moneda2 = peso;
						break;
				}
				
				double resultado = convertirMonedas(moneda1, moneda2, cantidad);
				
				String resultadoFormateado = String.format("%.2f", resultado);
				
				JOptionPane.showMessageDialog(null, cantidad + " " + origen
				+ " convertidos en " + destino + " da un total de " +
						resultadoFormateado + " " + destino, "Resultado", 1);
				
			}else if(seleccion == tipo[1]) {
				
				String[] distancia1 = {"KM", "M", "CM", "MM"}; 
				String origen = (String)JOptionPane.showInputDialog(
						null, 
						"Elige la medida que deseas convertir", 
						"Medida actual", 
						JOptionPane.YES_NO_CANCEL_OPTION,
						null, distancia1,
					    distancia1[0]
					    );
				String[] distancia2 = {"KM", "M", "CM", "MM"}; 
				String destino = (String)JOptionPane.showInputDialog(
						null, 
						"Elige la medida a la que deseas convertir", 
						"Medida convertida", 
						JOptionPane.YES_NO_CANCEL_OPTION,
						null, distancia2,
					    distancia2[1]
					    );
				
				double cantidad = 0;
				boolean valido = false;
				
				while (!valido) {
				  try {
				    cantidad = Double.parseDouble(JOptionPane.showInputDialog(null,
									"Ingresa la cantidad de " + origen + " que desea convertir en "
				    + destino, "Ingresa cantidad", 1));
				    valido = true;
				  } catch (NumberFormatException e) {
				    JOptionPane.showMessageDialog(null, "Ingresa solo valores numéricos", "Error",
				    		JOptionPane.ERROR_MESSAGE);
				  }
				}
				
				Distancias medida1 = new Distancias("", "", 0);
				
				switch (origen) {
					case "KM":
						medida1 = kilometro;
						break;
					case "M":
						medida1 = metro;
						break;
					case "CM":
						medida1 = centimetro;
						break;
					case "MM":
						medida1 = milimetro;
						break;
				}
				Distancias medida2 = new Distancias("", "", 0);
				switch (destino) {
				case "KM":
					medida2 = kilometro;
					break;
				case "M":
					medida2 = metro;
					break;
				case "CM":
					medida2 = centimetro;
					break;
				case "MM":
					medida2 = milimetro;
					break;
				}
				
				double resultado = convertirDistancias(medida1, medida2, cantidad);
				
				String resultadoFormateado = String.format("%.2f", resultado);
				
				JOptionPane.showMessageDialog(null, cantidad + " " + origen
				+ " convertidos en " + destino + " da un total de " +
						resultadoFormateado + " " + destino, "Resultado", 1);
							
			}
			
			int respuesta = JOptionPane.showConfirmDialog ( null, "¿Quieres hacer otra conversión?",
					"Selecciona una opción", JOptionPane.YES_NO_OPTION);
			
			if (respuesta == JOptionPane.NO_OPTION) {
				repetir = false;
			}
			
		}
		
		JOptionPane.showMessageDialog(null, "Creado por:\nMiguel Lizarzado", "Creador", 1);
				
	}
	
}

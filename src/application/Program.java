package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Exception.MinhasException;
import model.entities.Reservas;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Numero do Quarto: ");
			int numero = sc.nextInt();
			System.out.println("Data do Check-In: (dd/MM/yyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Data do Check-Out: (dd/MM/yyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservas reservas = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reservas);
	
			System.out.println();
			System.out.println("Digite dados para atualizar a reserva: ");
			System.out.println("Data do Check-In: (dd/MM/yyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data do Check-Out: (dd/MM/yyy): ");
			checkOut = sdf.parse(sc.next());
	
			reservas.updateDates(checkIn, checkOut);
				System.out.println("Reserva: " + reservas);
		}
		catch(ParseException e) {
			System.out.println("Invalid o formato da data!");
		}
		catch(MinhasException e) {
			System.out.println("Erro na reserva: " +e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Erro inesperado");
		}
		sc.close();

	}

}

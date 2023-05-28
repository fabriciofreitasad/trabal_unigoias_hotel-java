package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservas;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Numero do Quarto: ");
		int numero = sc.nextInt();
		System.out.println("Data do Check-In: (dd/MM/yyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Data do Check-Out: (dd/MM/yyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: a data de check-out deve ser após a data de check-in");
		}
		else {
			Reservas reservas = new Reservas(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reservas);
			
			System.out.println();
			System.out.println("Digite dados para atualizar a reserva: ");
			System.out.println("Data do Check-In: (dd/MM/yyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Data do Check-Out: (dd/MM/yyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date agora = new Date();
			if(checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro na reserva: as datas de reserva para atualização devem ser datas futuras");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: a data de check-out deve ser após a data de check-in");
			}
			
			reservas.updateDates(checkIn, checkOut);
			System.out.println("Reserva: " + reservas);
		}

		sc.close();

	}

}

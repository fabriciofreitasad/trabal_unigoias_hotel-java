package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservas {
	private Integer quartoNumero;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservas(Integer quartoNumero, Date checkIn, Date checkOut) {
		this.quartoNumero = quartoNumero;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getQuartoNumero() {
		return quartoNumero;
	}

	public void setQuartoNumero(Integer quartoNumero) {
		this.quartoNumero = quartoNumero;
	}

	public Date getCheckIn() {
		return checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Quarto: " 
				+ quartoNumero 
				+ ", check-In: " 
				+ sdf.format(checkIn)
				+ ", check-Out: " 
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+" Noites";
	}
	
	

}

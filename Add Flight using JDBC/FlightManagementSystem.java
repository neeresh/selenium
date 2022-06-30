import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class FlightManagementSystem {
	
	public boolean addFlight(Flight flightObj) {
		
		try {
			
			Connection conn = DB.getConnection();
			PreparedStatement statement = conn.prepareStatement("insert into flight "
					+ "values (?, ?, ?, ?, ?)");
			
			statement.setLong(1, flightObj.getFlightId());
			statement.setString(2, flightObj.getSource());
			statement.setString(3, flightObj.getDestination());
			statement.setLong(4, flightObj.getNoOfSeats());
			statement.setLong(5, (long) flightObj.getFlightFare());
			
			int rowsAffected = statement.executeUpdate();
			
			if(rowsAffected > 0) {
				return true;
				
			}else {
				return false;
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		return false;
		
	}
	
	
}


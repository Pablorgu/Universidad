import java.io.*;
import java.util.*;
import java.sql.*;

import com.microsoft.sqlserver.jdbc.*;


public class principal 
{

	public static void main(String[] args) throws SQLException{
        SQLServerDataSource datasource = new SQLServerDataSource();
        datasource.setIntegratedSecurity(true);
        datasource.setServerName("localhost");
        datasource.setPortNumber(1433);
        datasource.setDatabaseName("rediam");
        Connection connection = datasource.getConnection();
        
        cargaMontes(connection);
        Consulta_A(connection);
        Consulta_B(connection);
        Consulta_C(connection);
        System.out.println("Ejecución Finalizada");
 }

	public static void cargaMontes(Connection connection) 
	{		
		try {
		    Statement statement = connection.createStatement();

		    String line = "";
		    BufferedReader bufferedReader = new BufferedReader(new FileReader("montes.txt"));

		    while((line = bufferedReader.readLine()) != null) {
		        try (Scanner scanner = new Scanner(line)) {
		            scanner.useDelimiter(";");
		            while (scanner.hasNext()) {
		            	int CODIGO_MONTE = scanner.nextInt();
						String COD_PROVINCIA = scanner.next();
						String ESPACIO_NATURAL = scanner.next();
						int SUPERFICIE = scanner.nextInt();
						int NUMERO_MONTES = scanner.nextInt();
						
						statement.executeUpdate("INSERT INTO dbo.Montes VALUES ('"+CODIGO_MONTE+"','"+COD_PROVINCIA+"','"+ESPACIO_NATURAL+"','"+SUPERFICIE+"','"+NUMERO_MONTES+"');");
					}
		        }
		    }
		    bufferedReader.close();
		    statement.close();
		} catch (Exception e) {
		    // Manejo de excepciones (no se hace nada en este caso)
		}


	}
	
	public static void Consulta_A(Connection connection) throws SQLException
	{
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT p.Provincia, ESPACIO_NATURAL, SUPERFICIE FROM dbo.Montes m JOIN dbo.Provincias p ON m.COD_PROVINCIA = p.Codigo where SUPERFICIE>10000;");
		String provinciaActual = "";
		while(resultSet.next()) {
		    if(!provinciaActual.equalsIgnoreCase(resultSet.getString("Provincia"))) {
		        System.out.println("ESPACIOS NATURALES CON MAS DE 10000m2 de "+resultSet.getString("Provincia"));
		    }
		    provinciaActual = resultSet.getString("Provincia");
		    String espacioNatural = resultSet.getString("ESPACIO_NATURAL");
		    double superficie = resultSet.getDouble("SUPERFICIE");
		    System.out.println("\t"+espacioNatural+"  "+superficie);
		}
		statement.close();

	}
	public static void Consulta_B(Connection connection) throws SQLException
	{
		Statement statement = connection.createStatement();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Código de Provincia: ");
		String codigoProvincia = scanner.next();
		ResultSet resultSet = statement.executeQuery("SELECT p.Provincia, ESPACIO_NATURAL, SUPERFICIE, NUMERO_MONTES FROM dbo.Montes m JOIN dbo.Provincias p on m.COD_PROVINCIA = p.Codigo where p.Codigo='" + codigoProvincia + "'");
		String provinciaActual = "";
		while(resultSet.next()) {
		    if(!provinciaActual.equalsIgnoreCase(resultSet.getString("Provincia"))) {
		        System.out.println("ESPACIOS NATURALES DE "+resultSet.getString("Provincia"));
		    }
		    provinciaActual = resultSet.getString("Provincia");
		    String espacioNatural = resultSet.getString("ESPACIO_NATURAL");
		    double superficie = resultSet.getDouble("SUPERFICIE");
		    int numeroMontes = resultSet.getInt("NUMERO_MONTES");
		    System.out.println(espacioNatural + " " + superficie + " " + numeroMontes);
		}
		statement.close();

	}
	
	public static void Consulta_C(Connection connection) throws SQLException
	{
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("SELECT p.Provincia, sum(SUPERFICIE), sum(NUMERO_MONTES) FROM dbo.Montes m JOIN dbo.Provincias p on m.COD_PROVINCIA = p.Codigo GROUP BY p.Provincia");
		String provinciaActual = "";
		while(resultSet.next()) {
		    provinciaActual = resultSet.getString("Provincia");
		    double sumaSuperficie = resultSet.getDouble(2);
		    int sumaNumeroMontes = resultSet.getInt(3);
		    System.out.println("PROVINCIA: " + provinciaActual + "\nTOTAL SUPERFICIE: " + sumaSuperficie + "\nTOTAL NUMERO MONTES: " + sumaNumeroMontes);
		}
		statement.close();

	}
}

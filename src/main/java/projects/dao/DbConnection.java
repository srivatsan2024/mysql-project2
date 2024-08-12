package projects.dao;

public class DbConnection {
	private static String Host = "localhost";
	private static String Password = "projects";
	private static int Port = 3306;
	private static String Schema = "projects";
	private static String User = "projects";
	
	public static DbConnection () {
		String uri = "jdbc:mysql://localhost:3306/testdb?allowPublicKeyRetrieval=true&useSSL=true";
		String username = "project";
		String password = "Passw0rd";
		
		
        try {
            Connection connection = DriverManager.getConnection(uri, username, password);
            System.out.println("Connection successful!");
            return connection;
        } catch (SQLException e) {
            System.err.println("Failed to establish a connection to the database.");
            throw new DbException("Unable to connect to the database", e);
        }
			
		
	}
}

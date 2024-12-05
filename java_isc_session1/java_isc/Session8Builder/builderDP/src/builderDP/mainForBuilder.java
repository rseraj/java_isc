package builderDP;

public class mainForBuilder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			ConnectionForBuilder connection = new ConnectionForBuilder.Builder()
                .Url("http://google.com")
                .port("8080")
                .user("Rey")
                .pass("password123")
                .timeout(5000)
                .build();

            System.out.println("Connection successfully created!");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

	}

}

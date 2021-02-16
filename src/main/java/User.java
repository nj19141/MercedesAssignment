import java.net.InetAddress;

public class User {
	    private Long userID;
		private String firstName;
	    private String lastName;
	    private Long carID;
	    private String email;
	    private InetAddress IPAddress;

	    
	    public User(Long userID, String firstName, String lastName, Long carID, String email, InetAddress iPAddress) {
			this.userID = userID;
			this.firstName = firstName;
			this.lastName = lastName;
			this.carID = carID;
			this.email = email;
			IPAddress = iPAddress;
		}

		public InetAddress getIPAddress() {
			return IPAddress;
		}

		public void setIPAddress(InetAddress iPAddress) {
			IPAddress = iPAddress;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public Long getUserID() {
			return userID;
		}

		public void setUserID(Long userID) {
			this.userID = userID;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Long getCarID() {
			return carID;
		}

		public void setCarID(Long carID) {
			this.carID = carID;
		}
}
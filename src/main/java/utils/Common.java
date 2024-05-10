package utils;

import java.util.Random;

public class Common { 
	
	public String generateRandomEmail() {
        String email = "test" + System.currentTimeMillis() + "@test.com";
        return email;
    }
	
	public String generateRandomPassword() {
		String password = "paSS" + System.currentTimeMillis() + "5%7&";
		return password;
		}
	
	public String generateRandomFirstName() {
		String FirstName = "Test"+ System.currentTimeMillis();
		return FirstName;
		}
	
	public String generateRandomLastName() {
		String LastName = "Testing" + System.currentTimeMillis();
		return LastName;
		}
	
	public String generateRandomNewAddress() {
		String NewAddress = "Address" + System.currentTimeMillis();
		return NewAddress;
	}
	
	public String generateRandomNewCity() {
		String NewCity = "City" + System.currentTimeMillis();
		return NewCity;
	}
	
	    public void main(String[] args) {
	        Random rand = new Random();

	        // Generate 5 random numbers
	        for (int i = 0; i < 5; i++) {
	            int randomZip = rand.nextInt(); // Generates a random number
	            System.out.println(randomZip);
	        }
	    }
}





	



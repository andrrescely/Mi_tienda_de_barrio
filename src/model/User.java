package model;

public class User {

    private String name;
    private String address;
    private String phoneNumber;

    // Constructor
    public User(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    // Determinar si el usuario tiene una dirección específica
    public boolean hasSpecificAddress(String specificAddress) {
        return address.equals(specificAddress);
    }

    // Verificar si el número de teléfono contiene un cierto dígito
    public boolean phoneNumberContainsDigit(char digit) {
        return phoneNumber.contains(String.valueOf(digit));
    }

    // Getters y setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

package org.Perfekta_Produkter_AB;


public class Person {

    private static int counter = 100; // Static counter for generating unique IDs
    private String id;
    private String name;
    private String gender;

    public Person(String name, String gender) {
        this.id = generateUniqueID();
        this.name = name;
        this.gender = gender;
    }

    private String generateUniqueID() {
        return "P" + counter++;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

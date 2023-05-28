import java.time.LocalDate;

public class Person {
    private String name;
    private String address;
    private String phone;
    private LocalDate birthdate;


    Person(String name, String address, String phone, LocalDate birthdate){
        this.name= name;
        this.address=address;
        this.phone=phone;
        this.birthdate= birthdate;
    }

    public String getName(){
        return name;
    }
    public String getAddress(){
        return address;
    }
    public String getPhone(){
        return phone;
    }
    public LocalDate getBirthDate(){
        return birthdate;
    }

    public void setName(String name){
        this.name=name;
    }
    public void setAddress(String name){
        this.address=address;
    }
    public void setPhone(String name){
        this.phone=phone;
    }
    public void setBirthdate(LocalDate birthdate){
        this.birthdate=birthdate;
    }

    @Override
    public String toString(){
        return "Name: "+name+"\nAddress: "+address+"\nPhone: "+phone+"\nBirth Date: "+birthdate;
    }


    
}

package dlte.proj1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Stud {
    private int reg_no;
    private String name;
    private int age ,pincode,address_id;
    private String email, street, city;
    private Integer door_no;
    public Stud(int reg_no, String name, int age, String email, String address, int door_no, String street, String city, int pincode,int address_id) {
        this.reg_no = reg_no;
        this.name = name;
        this.age = age;
        this.email = email;
        this.door_no=door_no;
        this.street=street;
        this.city=city;
        this.pincode=pincode;
        this.address_id=address_id;
    }

    @Override
    public String toString() {
        return "Stud{" +
                "reg_no=" + reg_no +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", pincode=" + pincode +
                ", address_id=" + address_id +
                ", email='" + email + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", door_no=" + door_no +
                '}';
    }

    public int getReg_no() {
        return reg_no;
    }

    public void setReg_no(int reg_no) {
        this.reg_no = reg_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getDoor_no() {
        return door_no;
    }

    public void setDoor_no(Integer door_no) {
        this.door_no = door_no;
    }
}

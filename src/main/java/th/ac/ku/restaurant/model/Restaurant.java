package th.ac.ku.restaurant.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Restaurant {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;

    @Id
    @GeneratedValue(generator = "UUID")
    @Type(type = "org.hibernate.type.UUIDCharType")
    @Column(columnDefinition = "CHAR(36)")
    private UUID id;

    private String name;
    private String address;
    private String phone;
    private int numSeats; //จำนวนที่นั่ง

    // ไม่ต้องมี Constructor เพราะ JSON ต้องการ default Constructor


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        // ควรจะ set ข้อมูลที่ต้องการเก็บตั้งแต่ตรงนี้
        if (name != null)
            this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }
}

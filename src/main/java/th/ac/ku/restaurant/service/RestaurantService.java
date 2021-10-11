package th.ac.ku.restaurant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import th.ac.ku.restaurant.model.Restaurant;
import th.ac.ku.restaurant.repository.RestaurantRepository;

import java.util.List;
import java.util.UUID;

@Service
public class RestaurantService {

    // inject obj นี้มาให้ service โดยอัตโนมัติ
    @Autowired
    private RestaurantRepository repository;

    // ดึงข้อมูลทั้งหมดมาเป็น list มันมีเมธอทนี้จาก JPA ทำให้โดยอัตโนมัติ
    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    public Restaurant create(Restaurant restaurant) {
        // ถ้าไม่มีตอน save จะสร้าง id ให้ ถ้ามี id เก่า มันจะอัพเดทค่าให้
        repository.save(restaurant);
        return restaurant;
    }

    // สร้างการค้นหาด้วย id
    public Restaurant getRestaurant(UUID id) {
        return repository.findById(id).get();
    }

    public Restaurant update(UUID id, Restaurant requestBody) {
        Restaurant record = repository.findById(id).get();
        // พอได้เรคคอร์ดมาก็มาอัพเดททีละอัน แต่ถ้าแน่ใจว่าข้อมูลที่เข้ามาครบถ้วน ก็ save ทีเดียวไปเลย
        if (requestBody.getName() != null)
                record.setName(requestBody.getName());

        if (requestBody.getAddress() != null)
            record.setAddress(requestBody.getAddress());

        if (requestBody.getPhone() != null)
            record.setPhone(requestBody.getPhone());

        if (requestBody.getNumSeats() > 0)
            record.setNumSeats(requestBody.getNumSeats());

        repository.save(record);

        // ไม่ต้อง return ก็ได้ แต่นี้เอาไว้ดูเฉย ๆ
        return record;
    }

    public Restaurant delete(UUID id) {
        Restaurant record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }

}


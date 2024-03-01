import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import model.*;

import java.util.Arrays;
import java.util.List;

public class DataLoader {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("test1");
    EntityManager em = emf.createEntityManager();
    EntityTransaction transaction = em.getTransaction();

    public void loadData() {

        // Address
        Address address1 = new Address();
        address1.setCity("Fairfield");
        address1.setState("IA");
        address1.setStreet("58 E Burlington Ave");
        address1.setZip("52556");

        Address address2 = new Address();
        address2.setZip("52641");
        address2.setState("IA");
        address2.setStreet("301 E Washington St");
        address2.setCity("Mount Pleasant");

        //Owner
        Person person1 = new Person();
        person1.setName("Jack");
        person1.setAge(32);
        person1.setAddress(address2);

        Person person2 = new Person();
        person2.setAge(28);
        person2.setName("Jill");
        person1.setAddress(address1);

        // Relator
        Realtor realtor1 = new Realtor();
        realtor1.setNoOfEmployees(23L);

        Realtor realtor2 = new Realtor();
        realtor2.setNoOfEmployees(10L);

        // House
        House house1 = new House();
        house1.setCost(500000D);
        house1.setAddress(address1);
        house1.setName("BurlingtonHouse");
        house1.setRealtor(realtor1);

        House house2 = new House();
        house2.setName("LakeViewHouse");
        house2.setCost(436346D);
        house2.setAddress(address2);
        house2.setRealtor(realtor2);


        transaction.begin();
        em.persist(address1);
        em.persist(address2);
        em.persist(house1);
        em.persist(house2);
        em.persist(person1);
        em.persist(person2);
        em.persist(realtor1);

        transaction.commit();
    }

}

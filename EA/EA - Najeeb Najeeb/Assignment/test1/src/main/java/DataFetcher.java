import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import model.Address;
import model.House;
import model.Owner;
import model.Realtor;

import java.util.List;

public class DataFetcher {

    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("test1");
    public static EntityManager em = emf.createEntityManager();
    public static EntityTransaction transaction = em.getTransaction();


    public void getAllHouseInMarketRealtorGreatherThan10() {
        System.out.println("Query 1 Result");

        String stringQuery = "SELECT h FROM House h JOIN Realtor r WHERE r.noOfEmployees > 10 ";

        Query query = em.createQuery(stringQuery);

        List<House> houseList = query.getResultList();
        System.out.println(houseList);
    }

    public void returnHouseUsingCriteria() {
        System.out.println("Query 2 Result");
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<House> criteriaQuery =criteriaBuilder.createQuery(House.class);
        Root<House> houseRoot =criteriaQuery.from(House.class);

        criteriaQuery.select(houseRoot);

        Join<House, Realtor> realtorJoin =houseRoot.join("realtor");
        Join<House, Address> addressJoin = houseRoot.join("address");

        Predicate realtorEmp = criteriaBuilder.le(realtorJoin.get("noOfEmployees"),10);

        Predicate houseCost = criteriaBuilder.ge(houseRoot.get("cost"), 500000);

        Predicate city = criteriaBuilder.equal(addressJoin.get("state"), "IA");

        Predicate finalPredicate = criteriaBuilder.and(realtorEmp, houseCost, city);

        criteriaQuery.where(finalPredicate);

        Query query = em.createQuery(criteriaQuery);
        List<House> houseList = query.getResultList();

        System.out.println(houseList);
    }

    public void getAllOwner() {
        System.out.println("Query 3 Result");
        String stringQuery = "select distinct o.name from Owner o join Address a " +
                "join House h join Realtor r where h.cost > 120000";
        Query query = em.createQuery(stringQuery, Owner.class);
        List<Owner> ownerList = query.getResultList();
        System.out.println(ownerList);
    }
}

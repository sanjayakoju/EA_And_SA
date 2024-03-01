import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        System.out.println("App Start");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test1");

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        DataLoader dataLoader = new DataLoader();
        dataLoader.loadData();

        DataFetcher dataFetcher = new DataFetcher();
        dataFetcher.getAllHouseInMarketRealtorGreatherThan10();
        dataFetcher.returnHouseUsingCriteria();
        dataFetcher.getAllOwner();


        System.out.println("App Stop");
    }
}

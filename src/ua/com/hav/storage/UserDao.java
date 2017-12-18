package ua.com.hav.storage;

import org.springframework.stereotype.Component;
import ua.com.hav.model.User;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Random;

/**
 * Created by sunny on 18.12.17
 */
@Component
public class UserDao {

    private int i;
    private EntityManagerFactory emf;
    private EntityManager em;

    @PostConstruct
    private void init() {
        emf = Persistence.createEntityManagerFactory("z15");
        em = emf.createEntityManager();
    }

    //    private List<User> userList = new ArrayList<User>(){{
//            add(new User("USER", "user", "123"));
//            add(new User("ADMIN", "admin", "333"));
//    }};

    public boolean add(User user) {
        int size = em.createQuery("FROM User u WHERE u.login = :login").setParameter("login", user.getLogin()).getResultList().size();
        if (size == 0) {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            return true;
        }
//        boolean present = userList.stream().filter(u -> u.getLogin().equals(user.getLogin())).findAny().isPresent();
//        if (!present) {
//            userList.add(user);
//            return true;
//        }
        return false;
    }

//    public void remove(User user) {
//        userList.removeIf(u -> u.getLogin().equals(user.getLogin()));
//    }

    public List<User> findAll() {
        return em.createQuery("FROM User", User.class).getResultList();
//        return userList.stream().collect(toList());
    }

//    public boolean login(User user) {
//        return userList.stream()
//                .filter(u -> u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword()))
//                .findAny()
//                .isPresent();
//    }

    public User findByLogin(String login) {
        List<User> list = em.createQuery("FROM User u WHERE u.login = :login", User.class).setParameter("login", login).getResultList();
        return list.size() == 1 ? list.get(0) : null;
//        Optional<User> user = userList.stream().filter(u -> u.getLogin().equals(login)).findAny();
//        return user.isPresent() ? user.get() : null;
    }

    public User findRandom() {
        Random r = new Random();
        List<User> userList = findAll();
        User user = userList.get(r.nextInt(userList.size()));
        return user;
    }
}

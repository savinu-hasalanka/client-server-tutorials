package tute02;

public class UserProcessor implements Runnable {
//    private UserValidator userValidator;
    private UserDataStore userDataStore;
    private final Object lock;
    private String name;
    private int age;

    public UserProcessor(UserDataStore userDataStore, Object lock, String name, int age) {
//        this.userValidator = new UserValidator();
        this.userDataStore = userDataStore;
        this.lock = lock;
        this.name = name;
        this.age = age;
    }

    @Override
    public void run() {
        synchronized (lock) {
            if (UserValidator.isValidAge(age)) {
                System.out.println("Processing ...");
                userDataStore.addUser(new User(name, age));
            } else {
                System.out.println("Invalid age.");
            }
        }
    }
}

package tute02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserDataStore userDataStore = new UserDataStore();
        List<Thread> threads = new ArrayList<>();
        Object lock = new Object();

        boolean addMore = true;
        while (addMore) {
            System.out.print("Enter Name: ");
            String name = scanner.next();

            System.out.print("Enter Age: ");
            int age = scanner.nextInt();

            scanner.nextLine();

            UserProcessor userProcessor = new UserProcessor(userDataStore, lock, name, age);

            Thread thread = new Thread(userProcessor);
            threads.add(thread);
            thread.start();

            System.out.println("Add another? (yes/no)");
            addMore = scanner.nextLine().trim().equalsIgnoreCase("yes");
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("--- All Users in DataStore ---");
        System.out.println(userDataStore.getAllUsers());
    }
}

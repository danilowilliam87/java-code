package org.treinamento.generics;

import org.treinamento.automacao.utils.LocalDateUtil;

import java.io.File;
import java.time.LocalDateTime;
import java.util.*;

public class Exercicio1 {

    private static int totalUsers = 0;
    private static final String pathFile = "C:\\temp\\in.txt";
    private static final File file = new File(pathFile);

    public static void readFile(){
        Set<User> users = new HashSet<>();
        List<User> listUsers = new ArrayList<>();
        try (Scanner sc = new Scanner(file)){
            while (sc.hasNextLine()){
                String[] data = sc.nextLine().split(" ");
                String userName = data[0];
                LocalDateTime accessDate = LocalDateUtil.parseWithTimeZone(data[1]);
                User users1 = new User(userName, accessDate);
                users.add(users1);
                listUsers.add(users1);
            }

            if (!users.isEmpty()){
                totalUsers = users.size();
            }

            System.out.println("Total Access : " + totalUsers);
            users.forEach(System.out::println);

            Collections.sort(listUsers);
            System.out.println("lista de usuários ordenadas");
            listUsers.forEach(System.out::println);

        }catch (Exception e){
            System.err.println("Erro ao ler arquivo : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        readFile();
    }
}

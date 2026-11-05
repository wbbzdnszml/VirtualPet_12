package main.java.com.pet;

import java.io.*;

public class PetIO {
    // 保存宠物信息到文件
    public static void savePet(Pet pet, String filePath) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
            pw.println(pet.getName());
            pw.println(pet.getHunger());
            pw.println(pet.getHappy());
            pw.println(pet.getHealth());
            System.out.println("✅ 宠物存档成功！");
        } catch (IOException e) {
            System.out.println("❌ 存档失败：" + e.getMessage());
        }
    }

    // 从文件读取宠物
    public static Pet loadPet(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            return null;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String name = br.readLine();
            int hunger = Integer.parseInt(br.readLine());
            int happy = Integer.parseInt(br.readLine());
            int health = Integer.parseInt(br.readLine());
            Pet pet = new Pet(name);
            pet.setHunger(hunger);
            pet.setHappy(happy);
            pet.setHealth(health);
            return pet;
        } catch (Exception e) {
            System.out.println("❌ 读档失败，新建宠物");
            return null;
        }
    }
}


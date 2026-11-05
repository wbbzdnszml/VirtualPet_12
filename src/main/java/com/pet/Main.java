package main.java.com.pet;

import java.util.Scanner;

public class Main {
    // 存档文件，会生成在项目根目录
    public static final String SAVE_FILE = "pet_save.txt";
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pet myPet = PetIO.loadPet(SAVE_FILE);

        if (myPet == null) {
            System.out.print("没有找到存档，给你的宠物起名字：");
            String petName = scanner.nextLine();
            myPet = new Pet(petName);
        } else {
            System.out.println("🎉 成功读取存档！欢迎回来照顾 " + myPet.getName());
        }

        while (true) {
            myPet.showStatus();
            System.out.println("\n===== 操作菜单 =====");
            System.out.println("1｜查看状态");
            System.out.println("2｜喂食");
            System.out.println("3｜陪它玩耍");
            System.out.println("4｜睡觉休息");
            System.out.println("5｜洗澡清洁");
            System.out.println("0｜退出并保存");
            System.out.print("请输入你的选择：");

            int op;
            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("❌ 请输入合法数字！");
                continue;
            }
            op = scanner.nextInt();

            if (op == 0) {
                PetIO.savePet(myPet, SAVE_FILE);
                System.out.println("👋 已经保存，下次再见！");
                break;
            }
            switch (op) {
                case 1:
                    System.out.println("📋 查看状态完成");
                    break;
                case 2:
                    myPet.feed();
                    System.out.println("🍚 你给宠物喂了食物！");
                    myPet.timePass();
                    break;
                case 3:
                    myPet.play();
                    System.out.println("🎈 和宠物开心玩耍！");
                    myPet.timePass();
                    break;
                case 4:
                    myPet.sleep();
                    System.out.println("💤 宠物躺下睡觉啦！");
                    myPet.timePass();
                    break;
                case 5:
                    myPet.bath();
                    System.out.println("🛁 洗完香香澡！");
                    myPet.timePass();
                    break;
                default:
                    System.out.println("❌ 没有这个选项，请重新输入！");
            }
        }
        scanner.close();
    }
}

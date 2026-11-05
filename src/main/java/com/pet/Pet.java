package main.java.com.pet;

public class Pet {
    private String name;
    private int hunger;    // 饥饿 0吃饱，100极饿
    private int happy;     // 开心 0低落，100超开心
    private int health;    // 健康 0生病，100很健康
    private int clean; // 干净度，0很脏，100干净

    public Pet(String name) {
        this.name = name;
        hunger = 40;
        happy = 60;
        health = 80;
        clean = 60;

    }

    // 喂食
    public void feed() {
        hunger -= 20;
        happy += 5;
        checkBoundary();
    }

    // 玩耍
    public void play() {
        happy += 20;
        hunger += 12;
        checkBoundary();
    }

    // 睡觉
    public void sleep() {
        health += 15;
        happy += 8;
        hunger += 8;
        checkBoundary();
    }

    // 洗澡

    public void bath() {
    clean += 30;
    checkBound();
}

    public void bath() {
    clean += 30;
    happy += 20;
    checkBoundary();
}


    // 时间流逝：每次做完一件事自动触发
    public void timePass() {
        hunger += 6;
        happy -= 4;
        // 饥饿很高或者很不开心，扣健康
        if (hunger >= 80 || happy <= 20) {
            health -= 8;
        }
        checkBoundary();
    }

    // 限制数值 0~100
    private void checkBoundary() {
        if (hunger < 0) hunger = 0;
        if (hunger > 100) hunger = 100;
        if (happy < 0) happy = 0;
        if (happy > 100) happy = 100;
        if (health < 0) health = 0;
        if (health > 100) health = 100;
    }

    public void showStatus() {
        System.out.println("\n======== 【" + name + "】 ========");
        System.out.println("饥饿值：" + hunger);
        System.out.println("开心值：" + happy);
        System.out.println("健康值：" + health);
        if (health <= 0) {
            System.out.println("🥺 宠物生病了！快好好照顾它！");
        } else if (hunger >= 85) {
            System.out.println("⚠ 肚子咕咕叫，急需喂食！");
        } else if (happy <= 20) {
            System.out.println("😔 它闷闷不乐，陪它玩一会儿吧");
        } else if (health >= 90 && happy >= 80) {
            System.out.println("✨ 宠物现在状态超棒！");
        }
    }
    public String getName() {
        return name;
    }

    public int getHunger() {
        return hunger;
    }

    public int getHappy() {
        return happy;
    }

    public int getHealth() {
        return health;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
        checkBoundary();
    }

    public void setHappy(int happy) {
        this.happy = happy;
        checkBoundary();
    }

    public void setHealth(int health) {
        this.health = health;
        checkBoundary();
    }

}

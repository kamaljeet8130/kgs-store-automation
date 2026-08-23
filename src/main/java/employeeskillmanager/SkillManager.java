package employeeskillmanager;

import java.util.Scanner;

public class SkillManager {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SkillService service = new SkillService();

        while (true) {

            System.out.println();
            System.out.println("==============================");
            System.out.println("     EMPLOYEE SKILL MANAGER");
            System.out.println("==============================");
            System.out.println("1. Add Skill");
            System.out.println("2. View Skills");
            System.out.println("3. Check Skill");
            System.out.println("4. Remove Skill");
            System.out.println("5. Remove Skills By Category");
            System.out.println("6. Clear Skills");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("Skill name : ");
                    String name = scanner.nextLine();
                    System.out.println("Skill Category: ");
                    String category = scanner.nextLine();
                    if(service.addSkill(new Skill(name,category)))
                        System.out.println("skill added successfully");
                    break;

                case 2:
                    System.out.println("\nAvailable Skills: ");
                    if(service.isEmpty()){
                        System.out.println("No skills available.");
                    }else{
                        service.displaySkills();
                    }
                    break;

                case 3:
                    System.out.println("Enter Skill name: ");
                    String skillName = scanner.nextLine();
                    System.out.println("Enter category: ");
                    String skillCategory = scanner.nextLine();

                    Skill skill = new Skill(skillName,skillCategory);
                    if(service.containSkill(skill))
                        System.out.println("Skill Already exists");
                    else
                        System.out.println("Skill does not exist.");
                    break;
                case 4:
                    System.out.print("Enter skill name: ");
                    String removeName = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String removeCategory = scanner.nextLine();
                    Skill removeSkill = new Skill(removeName, removeCategory);
                    if (service.removeSkill(removeSkill)) {
                        System.out.println("Skill removed successfully.");
                    } else {
                        System.out.println("Skill not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter category: ");
                    String categoryToFind = scanner.nextLine();
                    int removedCount = service.removeSkillByCategory(categoryToFind);
                    System.out.println(
                            removedCount + " skill(s) removed."
                    );
                    break;

                case 6:
                    service.clearSkills();
                    System.out.println("All skills cleared");
                    break;

                case 7:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Enter valid input!");
            }
        }
    }
}
package employeeskillmanager;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SkillService {
    private final Set<Skill> skills = new HashSet<>();

    public boolean addSkill(Skill skill){
        return skills.add(skill);
    }
    public boolean containSkill(Skill skill){
        return skills.contains(skill);
    }
    public boolean removeSkill(Skill skill){
        return skills.remove(skill);
    }
    public int getSkillCount(){
        return skills.size();
    }
    public boolean isEmpty(){
        return skills.isEmpty();
    }
    public void clearSkills(){
        skills.clear();
    }
    public void displaySkills(){
        for(Skill skill : skills){
            System.out.println(skill);
        }
    }
    public int removeSkillByCategory(String category){
        int removedCount = 0;
        Iterator<Skill> iterator = skills.iterator();
        while (iterator.hasNext()){
            Skill skill =iterator.next();
            if(skill.getCategory().equalsIgnoreCase(category)){
                iterator.remove();
                removedCount++;
            }
        }
        return removedCount;
    }
}

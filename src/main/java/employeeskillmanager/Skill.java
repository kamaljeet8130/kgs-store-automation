package employeeskillmanager;

import java.util.Objects;

public class Skill {
    private String name;
    private String category;

    public Skill(String name,String category){
        this.name = name;
        this.category = category;
    }
    public String getName(){
        return name;
    }
    public String getCategory(){
        return category;
    }

    @Override
    public String toString() {
        return name + "( "+ category + " )";
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(!(obj instanceof Skill)){
            return false;
        }
        Skill skill = (Skill) obj;
        return name.equals(skill.name) && category.equals(skill.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,category);
    }
}
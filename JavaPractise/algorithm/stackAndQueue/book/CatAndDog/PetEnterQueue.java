package algorithm.stackAndQueue.book.CatAndDog;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 */

public class PetEnterQueue {
    private Pet pet;
    private int count;

    public PetEnterQueue(Pet pet,int count){
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet(){
        return this.pet;
    }

    public int getCount(){
        return this.count;
    }

    public String getEnterPetType(){
        return this.pet.getPetType();
    }

}

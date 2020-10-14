package algorithm.stackAndQueue.book.CatAndDog;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Demo class
 *
 * @author xinghao
 * @date 2020/
 */

public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private int count;
    public DogCatQueue(){
        dogQ = new LinkedList<PetEnterQueue>();
        catQ = new LinkedList<PetEnterQueue>();
        this.count = 0;
    }
    public void add(Pet pet){
        if(pet.getPetType().equals("dog")){
            dogQ.add(new PetEnterQueue(pet,this.count++));
        }else if(pet.getPetType().equals("cat")){
            catQ.add(new PetEnterQueue(pet,this.count++));
        }else {
            throw new RuntimeException("error");
        }
    }
    public Pet pollAll(){
        if(!dogQ.isEmpty()&&!catQ.isEmpty()){
            if(dogQ.peek().getCount()<catQ.peek().getCount()){
                return dogQ.poll().getPet();
            }else{
                return catQ.poll().getPet();
            }
        }else if (!dogQ.isEmpty()){
            return dogQ.poll().getPet();
        }else if (!catQ.isEmpty()){
            return catQ.poll().getPet();
        }
        else {
            throw new RuntimeException("empty queue");
        }
    }
    public Dog pollDog(){
        if(!dogQ.isEmpty()){
            return (Dog) dogQ.poll().getPet();
        }else {
            throw new RuntimeException("empty dog");
        }
    }
    public Cat pollCat(){
        if(!catQ.isEmpty()){
            return (Cat) catQ.poll().getPet();
        }else {
            throw new RuntimeException("empty cat");
        }
    }
    public boolean isEmpty(){
        return dogQ.isEmpty()&&catQ.isEmpty();
    }
    public boolean isDogEmpty(){
        return dogQ.isEmpty();
    }
    public boolean isCatEmpty(){
        return catQ.isEmpty();
    }
}

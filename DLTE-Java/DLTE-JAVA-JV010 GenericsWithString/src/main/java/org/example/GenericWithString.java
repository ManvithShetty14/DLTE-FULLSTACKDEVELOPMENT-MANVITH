package org.example;
import java.util.Scanner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
public class GenericWithString {

    public static void main(String[] args) {
        Generics<String> items = new Generics<String>();
        items.add();
        items.replacing();
    }


}
@Data
@NoArgsConstructor
@AllArgsConstructor
class Generics <T>{
    Scanner sc=new Scanner(System.in);
    private T[] objects;
    public T[] getObjects(){
        return objects;
    }
    public void setObjects(){
        this.objects=objects;
    }

    public void add(T[] data){
        for(int index=0;index<=objects.length; index++){
            if(objects[index]=="null")
            {
                objects[index] = data;
            }
        }
    }
    public void replacing()
    {
        System.out.println("Enter the string to be replaced and the replacement");
        String str= (String) sc.toString();
        String replace= (String) sc.toString();
        for (int index=0;index<=0;index++)
        {
            if(objects[index])
        }


    }

}

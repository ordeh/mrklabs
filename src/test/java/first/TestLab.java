package first;

import org.testng.annotations.Test;

public class TestLab {

    private String testWord = "ВРЕМЕНА МЕНЯЮТСЯ";
    private Integer [] xCode = {1,3,2,4};
    private Integer [] yCode = {4,3,2,1};

    @Test
    public void first(){
        Lab1 lab1 = new Lab1(xCode, yCode, testWord);
        lab1.encrypt();
    }

    @Test
    public void second(){
        String testWord = "ВЕДОМОСТЬ";
        Integer [] arr = {6,1,8,7,5,3,2,9,4};
        for (Integer anArr : arr) {
            Integer x = anArr - 1;
            char word = testWord.charAt(x);
            x = x+1;
            System.out.println("Index" + x + " and word " + word);
        }
    }

    @Test
    public void third(){
        
    }
}
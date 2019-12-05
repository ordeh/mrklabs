import org.testng.annotations.Test;

public class TestLab {

    private String testWord = "ВРЕМЕНА МЕНЯЮТСЯ";
    private Integer [] xCode = {1,3,2,4};
    private Integer [] yCode = {4,3,2,1};

    @Test
    public void labTest(){
        Lab1 lab1 = new Lab1(xCode, yCode, testWord);
        lab1.encrypt();
    }
}
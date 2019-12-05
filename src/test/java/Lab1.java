import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lab1 {

    private String testWord;
    private String [] lines;
    private Integer [] xCode;
    private Integer [] yCode;

    Lab1(Integer[] xCode, Integer[] yCode, String testWord){
        this.xCode = xCode;
        this.yCode = yCode;
        this.testWord = testWord;
        this.lines = separete();
    }

    List<Table> encrypt(){
        return encryptByColumn();
    }

    private List<Table> encryptByColumn(){
        List<Table> tables = encryptByLines();
        List<Table> resultTable = new ArrayList<>();
        List<Table> tableContainer = new ArrayList<>();
        for (Integer integer : xCode) {
            for (Table table : tables) {
                if (table.getY().equals(integer)) {
                    tableContainer.add(table);
                }
            }
        }
        for (int index : xCode) {
            List<Table> targetTable = tableContainer.stream().filter(i -> i.getX().equals(index)).collect(Collectors.toList());
            targetTable.sort(Table.COMPARE_BY_COUNT);
            resultTable.addAll(targetTable);
        }
        Collections.sort(resultTable);
        System.out.println("RESULT table 3");
        for (Table table : resultTable){
            System.out.println(table);
        }
        return resultTable;
    }

    private List<Table> encryptByLines(){
        List<Table> tables = inputTable();
        List<Table> resultTable = new ArrayList<>();
        List<Table> tableContainer = new ArrayList<>();
        for (int u = 0; u < xCode.length; u++){
            for (Table table : tables) {
                if (table.getY().equals(yCode[u])) {
                    tableContainer.add(table);
                }
            }
        }
        for (int index : yCode) {
            List<Table> targetTable = tableContainer.stream().filter(i -> i.getY().equals(index)).collect(Collectors.toList());
            Collections.sort(targetTable);
            resultTable.addAll(targetTable);
        }
        System.out.println("RESULT table 2");
        for (Table table : resultTable){
            System.out.println(table);
        }
        return resultTable;
    }

    private List<Table> inputTable(){
        List<Table> tables = new ArrayList<>();
        for (int u = 0; u< lines.length; u ++){
            int size = lines[u].length();
            for (int r = 0; r < size; r++){
                char symbol = lines[u].charAt(r);
                Table table = new Table();
                table.setValue(symbol);
                table.setX(xCode[r]);
                table.setY(yCode[u]);
                tables.add(table);
            }
        }
        System.out.println("RESULT table 1");
        for (Table table : tables){
            System.out.println(table);
        }
        return tables;
    }

    private String [] separete(){
        return testWord.split("(?<=\\G....)");
    }
}

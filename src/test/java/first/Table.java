package first;

import java.util.Comparator;

import lombok.Data;

@Data
public class Table implements Comparable< Table >{

    private char value;

    private Integer x;

    private Integer y;

    @Override
    public int compareTo(Table o) {
        return this.getX().compareTo(o.getX());
    }

    public static final Comparator<Table> COMPARE_BY_COUNT = new Comparator<Table>() {
        @Override
        public int compare(Table lhs, Table rhs) {
            return lhs.getY() - rhs.getY();
        }
    };
}

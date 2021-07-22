package Object;

public class TraceObj{
    int index_i,index_j;
    int type_number;
    int rotate;

    public TraceObj(int i,int j,int type_number, int rotate){
        this.index_i = i;
        this.index_j = j;
        this.type_number = type_number;
        this.rotate = rotate;
    }

    public void printObj(){
        System.out.print("i : " + index_i + " j : " + index_j + " type_number : " + type_number+" rotate : "+ rotate +"\n");
    }
}
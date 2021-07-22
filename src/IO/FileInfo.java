package IO;

public class FileInfo {

    private final String fileName = "./PuzzleInfo/03_doberman.txt";
    private final int block_kind = 7;
    private int puzzleNum;
    private int logicArraySize;

    public FileInfo(){
        this.puzzleNum = 0;
        this.logicArraySize = 0;
    }

    public int getBlock_kind() {
        return block_kind;
    }

    public int getPuzzleNum() {
        return puzzleNum;
    }

    public void setPuzzleNum(int puzzleNum) {
        this.puzzleNum = puzzleNum;
        if(puzzleNum > 0){
            this.logicArraySize = block_kind + puzzleNum - 1;
        }
    }

    public int getLogicArraySize() {
        return logicArraySize;
    }

    public String getFileName() {
        return fileName;
    }
}

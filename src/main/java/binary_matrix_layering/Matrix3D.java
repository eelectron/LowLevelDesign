package binary_matrix_layering;

import java.util.*;

class Matrix3D {
    private Map<Integer, Set<Cell>> filledCells;
    private TreeSet<Node> treeSet;
    public Matrix3D(int n) {
        filledCells = new HashMap<>();
        treeSet = new TreeSet<>(new NodeComparator());

        for(int i = 0; i < n; i++){
            filledCells.put(i, new HashSet<>());
            treeSet.add(new Node(i, filledCells.get(i)));
        }
    }

    public void setCell(int x, int y, int z) {
        filledCells.putIfAbsent(x, new HashSet<>());
        Set<Cell> cells = filledCells.get(x);
        Cell cell = new Cell(y, z);

        // remove old node from treeSet
        Node oldNode = new Node(x, cells);
        treeSet.remove(oldNode);

        // add new cell
        cells.add(cell);

        // add updated node back to treeSet
        Node newNode = new Node(x, cells);
        treeSet.add(newNode);
    }

    public void unsetCell(int x, int y, int z) {
        Set<Cell> cells = filledCells.get(x);
        if(cells == null) return;

        Cell cell = new Cell(y, z);
        // remove old node from treeSet
        Node oldNode = new Node(x, cells);
        treeSet.remove(oldNode);

        // remove cell
        cells.remove(cell);

        // add updated node back to treeSet
        Node newNode = new Node(x, cells);
        treeSet.add(newNode);
    }

    public int largestMatrix() {
        Node node = treeSet.last();
        return node.index;
    }
}

class Cell {
    int r, c;

    Cell(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return r == cell.r && c == cell.c;
    }

    public int hashCode(){
        return Objects.hash(r, c);
    }
}

class Node{
    int index;
    Set<Cell> cells;
    Node(int index, Set<Cell> cells){
        this.index = index;
        this.cells = cells;
    }
}

class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b) {
        if(a.cells.size() != b.cells.size()){
            return a.cells.size() - b.cells.size();
        }
        return a.index - b.index;
    }
}

/**
 * Your Matrix3D object will be instantiated and called as such:
 * Matrix3D obj = new Matrix3D(n);
 * obj.setCell(x,y,z);
 * obj.unsetCell(x,y,z);
 * int param_3 = obj.largestMatrix();
 */

/**
 * @(#)VerticeTest.java
 *
 *
 * @author 
 * @version 1.00 2015/5/29
 */

public class VerticeTest {
        
    /**
     * Creates a new instance of <code>VerticeTest</code>.
     */
    public VerticeTest() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Vertice testVert = new Vertice(0,1,1);
        Vertice testVer2 = new Vertice(0,1,1);
        
        System.out.println(testVert.equals(testVer2));
    }
}

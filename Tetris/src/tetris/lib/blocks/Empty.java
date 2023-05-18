package tetris.lib.blocks;

/**
 *
 * @author berna
 */
public class Empty extends Block {

    public Empty() {
        super('.');
    }
    /**
     * 
     * @return 
     */
    @Override
    public Block getClone(){
        return new Empty();
    }

    public static void main(String[] args) {
        Empty e = new Empty();
        //to string
        System.out.println("e = " + e);
        //clone
        Block e2 = e.getClone();
        System.out.println("e2 = " + e2.getClass());
    }

}

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\quimey.arozarena\\Desktop\\cv_formato_glb.doc");

        BehaviourController bc = new BehaviourController();
        boolean rta = bc.moveToTopeIfFileIsInList();
        System.out.println(rta);
    }

}

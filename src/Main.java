import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;

public class Main extends SimpleApplication {

    public static void main(String[] args) {
        System.out.println("Starting jMonkeyEngine ...");
        Main app = new Main();
        app.start();
    }


    @Override
    public void simpleInitApp() {
        //addSphereToOrigin();

        cam.setLocation(new Vector3f(0f, 0f, 15f));


        Box body = new Box(1f,1f, 1f);
        Geometry geom = new Geometry("Box", body);
        geom.setLocalTranslation(0,0,0);
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Red);
        geom.setMaterial(mat);

        Vector3f left = new Vector3f(body.getXExtent()/2 + 1, body.getYExtent()/2, body.getZExtent()/2);
        Box leftFoot = new Box(left, 0.5f, 0.5f, 0.5f);
        Geometry leftGeo = new Geometry("Box", leftFoot);

        Material mat2 = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat2.setColor("Color", ColorRGBA.White);
        leftGeo.setMaterial(mat2);

        rootNode.attachChild(geom);
        rootNode.attachChild(leftGeo);
    }



    private void addSphereToOrigin(){
        Sphere sph = new Sphere(3,100,10);
        Geometry sphereGeom = new Geometry("Sphere", sph);
        sphereGeom.setLocalTranslation(0,0,0);

        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        material.setColor("Color", ColorRGBA.Red);
        sphereGeom.setMaterial(material);
        rootNode.attachChild(sphereGeom);
    }
}

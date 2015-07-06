import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by forando on 13.11.14.
 */
public class Main {
    public static void main(String[] args){
        test7();
    }

    private static void test1(){
        List rawList = new ArrayList();
        List<String> genList = new ArrayList<String>();
        rawList = genList;
        rawList.add(8);
        String s = genList.get(0);
    }

    /*
    This method fails because someType object was created without
    any type bounding. If so, SomeType class, when instantiating
    someType object has deleted all "Generics marks" in it's
    methods
     */
    private static void test2(){
        SomeType someType = new SomeType();
        List<String> list = Arrays.asList("value");
        /*calling wrong method*/
        someType.test(list);
    }
    /*
    This is the right way to instantiate someType object
     */
    private static void test3(){
        SomeType<?> someType = new SomeType<Object>();
        List<String> list = Arrays.asList("value");
        /*calling correct method*/
        someType.test(list);
    }

    private static void test4(){
        List<String> lstr = new ArrayList<String>();
        List<Object> lobj = new ArrayList<Object>();
        /*next line throws Compile Error if you uncomment it*/
        //lobj = lstr;

        /*
        Previous line is big "no no" cause if it was
        accepted  then next lines will cause trouble
        during RunTime
         */
         lobj.add(new Object());
        String s = lstr.get(0);
    }

    private static void test5(){
        List<String> stringList = new ArrayList<String>();
        List<Object> objectList = new ArrayList<Object>();
        print(stringList);
        /*next line causes Compile Error if you uncomment it*/
        //print(objectList);
    }

    private static void print(Collection<String> list){
        for (String string : list){
            System.out.println(string);
        }
    }

    private static void test6(){
        List<Camera> cameras = new ArrayList<Camera>();
        Camera camera = new Camera("camera1", 200, 720);
        cameras.add(camera);
        boolean result = camera.find(cameras, camera);
        System.out.println(result);

        /*
        next line shows the difference between find and findStronglyTyped
        methods if you uncomment them
         */
        result = camera.find(cameras, new Phone("phone1", 600, "Nexus"));

        //result = camera.findStronglyTyped(cameras, new Phone("phone1", 600, "Nexus"));
        List<Phone> phones = new ArrayList<Phone>();
        Phone phone = new Phone("phone1", 550, "LG");
        phones.add(phone);
        result = camera.findStronglyTyped(phones, phone);

        System.out.println(result);
    }

    private static void test7(){
        Camera camera1 = new Camera("camera1", 200, 720);
        Camera camera2 = new Camera("camera2", 300, 1920);
        Phone phone1 = new Phone("phone1", 550, "LG");
        Product product = new Product("prod1", 300) {
            @Override
            int subCompare(Product p) {
                return 0;
            }

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };

        camera1.compareTo(camera2);
        camera1.subCompare(camera2);

        //camera1.compareTo(product);
        //camera1.compareTo(phone1);
        //camera1.subCompare(phone1);
    }
}

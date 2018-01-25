package annotationsTask;


public class Test2 {
    @AccessMarker(Roles.SUPPORT)
    public String field3;
    @AccessMarker(Roles.SUPPORT)
    public long field4;


    public Test2(){

    }


    public Test2(String field3, long field4) {
        this.field3 = field3;
        this.field4 = field4;
    }

    @AccessMarker(Roles.DEV)
    public void method1 (String arg){

    }

    public void method1 (int arg){

    }

    @AccessMarker(Roles.SUPPORT)
    public boolean method2 (){
        return false;
    }


}

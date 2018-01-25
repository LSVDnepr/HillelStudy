package annotationsTask;



@AccessMarker(Roles.DEV)
public class Test1 {
    private int field1;
    private String field2;


    public Test1 (){

    }


    public Test1(int field1, String field2) {
        this.field1 = field1;
        this.field2 = field2;
    }


    @AccessMarker(Roles.QA)
    public int getField1() {
        return field1;
    }


    @AccessMarker(Roles.ADMIN)
    public void setField1(int field1) {
        this.field1 = field1;
    }


    @AccessMarker(Roles.QA)
    public String getField2() {
        return field2;
    }

    @AccessMarker(Roles.ADMIN)
    public void setField2(String field2) {
        this.field2 = field2;
    }




}

package reflectiontask;

public class UserData {
/*
 3. Создать свой класс с приватным полем и публичным.
	3.1. Динамически изменить значение приватного поля.
	3.2. Все вывести на экран.(оба типа полей до и после модификации)
 */

    private int userId;
    public String nameToShow;
    private String login;
    private String password;
    private static int nextId = 1;

    public UserData(String nameToShow, String login, String password) {
        if (nameToShow == null || nameToShow.length() == 0) throw new IllegalArgumentException("Illegal name value=" + nameToShow);
        if (login == null || login.length() == 0) throw new IllegalArgumentException("Illegal login value=" + login);
        if (password == null || password.length() == 0)
            throw new IllegalArgumentException("Illegal password value=" + password);

        userId = nextId++;
        this.nameToShow=nameToShow;
        this.login=login;
        this.password=password;
        System.out.println("User registered successfully!");
    }


    public int getUserId() {
        return userId;
    }

    public String getNameToShow() {
        return nameToShow;
    }

    /*public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }*/

    public void setNameToShow(String nameToShow) {
        this.nameToShow = nameToShow;
    }



    /*private void setLogin(String login) {
        this.login = login;
    }

    private void setPassword(String password) {
        this.password = password;
    }*/

    @Override
    public String toString() {
        return "UserData: " + "userId=" + userId + ", nameToShow=" + nameToShow;
    }

    private String getFullInfo(){
        return "UserData: " + "userId=" + userId + ", nameToShow=" + nameToShow+", login="+login+", password="+password;
    }
}





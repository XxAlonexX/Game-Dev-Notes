public class Greeter{
    public void sayHello(){
        System.out.print("Hello!");
    }
}
public class Launcher{
    public static void main(){
        Greeter greta = new Greeter();
        greta.sayHello();
    }
}
# Extending a Class
Extending a class will decrease redundancy by creating reusable code. One of the way to accomplish that is Oops Concept inheritance: the creating of new class based on existing class.
```java
public class Person{
    String name;
    int HP;
    public void attack(Person Other)
    {
        //Attack Code Here
    }

// Extend the Person Class as Follows:
public class Wizard extends Person{
    int MP;
    public void castSpell(String SpellName)
    {
        // Spell Code Here
    }
  }
}
// Then if we were to create instances of this classes;
Person percy = new Person();
Wizard Merlin = new Wizard();

```
Then, commands such as `merlin.MP += 10 and merlin.castSpell("Fireball")` are valid, as well as commands involving fields and methods of the base class, such as `merlin.HP -= 3 and merlin.attack( percy )`. However, the object called percy can only use the fields and methods of the person class. Code such as `percy.HP += 5` will compile, but `percy.castSpell("lighting")` will result in an error when the file is compiled.
# Static Methods and Driver Classes
By default, the methods of a class are called by instances of that class. However, a method can also be declared to be static, meaning that it is called form the class directly (rather than an instance). Whether a method should be instance-based or class-based (static) depends on how the method is used and what data requires.
An instance-based method usually depends on the internal data stored in that instance. For example, every String object has a method called `CharAt` which takes an integer as a input and returns the character stored  that position in the string. If we create two string object as follows:
```java
String player1 = "Lee";
String player2 = "Dan ";
```
then the expression `player1.chartAt(1)`. return the character `e`, while, `player2.charAt(1)` returns the character `a`. The value returned by this method depends on the data stored in that instance, and thus `charAt()` is most assuredly and instance-based method.
# The Life Cycle of Video Game
- Startup: During this stage, any files needed (such as images or sounds ) are loaded game objects are created, and when values are initialized.
- The Game Loop: The stage which continuously repeated while the game is running and this contains following three sub stages:
- Process Input: The programming check out if the player performed any action in order to interact with the game such as pressing keyboard, moving mouse, moving joystick etc.
- Update: Performs tasks that involve the state of the game world and the entities within it. This could include change the positions of the character according the user input or physic simulation, performing Collison detection to determine when two entities come in contact with each other and can be performed in response. or selection actions for the non player character.
- Render: 


![[Life_Cycle_Of_Game.jpg]]
## Interfaces
Informally, you can think of an interface as a kind of contract that other classes can promise to fulfill,
As a simple example, let's say that you write a `Player` class, which contains a method named `TalkTo` that is used to interact with the object in the environment. The `talkTo` method takes a single input, called `creature.
```java
creature.speak();
```


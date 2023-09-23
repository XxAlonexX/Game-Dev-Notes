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

import attacks.SpecialAttacks.SweetKiss;
import ru.ifmo.se.pokemon.*;
import java.lang.*;

public class Pokemons {
    public static void main(String args[]) {
        Battle b = new Battle();
        Pokemon p1 = new Togepi("тогепи", 1);
        Pokemon p2 = new Togetic("Хищник", 1);
        Pokemon p3 = new Togekiss("eldest", 1);
        b.addAlly(p3);
        b.addAlly(p1);
        b.addFoe(p2);
        b.go();
    }
}
//ddsdsd

class Facade extends PhysicalMove {
    public Facade() {
        super(Type.NORMAL, 70, 100);
    }
    @Override
    protected String describe(){
        return "attacks with Facade";
    }
}

class Confide extends StatusMove {
    public Confide() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected String describe(){
        return "attacks with Confide";
    }
    @Override
    protected void applyOppEffects(Pokemon p) {
        p.setMod(Stat.SPECIAL_ATTACK, -1);
        super.applyOppEffects(p);
    }

}

class Roost extends StatusMove {
    public Roost() { super(Type.FLYING, 0, 0);}

    @Override
    protected String describe(){
        return "attacks with Roost";
    }
    @Override
    protected void applySelfEffects(Pokemon p) {
        Effect e = new Effect().stat(Stat.HP, 42);
        p.addEffect(e);
        super.applySelfEffects(p);
    }
}
//Todo
class DragonRush extends PhysicalMove {
    public DragonRush() {
        super(Type.DRAGON, 100, 75);
    }
}
//Todo


class Yveltal extends Pokemon {
    public Yveltal(String name, int level) {
        super (name, level);
        setStats(126,131,95,131,98,99);
        setType(Type.DARK, Type.FLYING);
        setMove(new DragonRush(), new Swagger(), new Roost(), new Facade());
    }
}


class Togepi extends Pokemon {
    public Togepi(String name, int level) {
        super (name, level);
        setStats(35, 20, 65, 40, 65, 20);
        setType(Type.FAIRY);
        setMove(new Facade(), new Confide());
    }
}


class Togetic extends Togepi {
    public Togetic(String name, int level) {
        super(name, level);
        setStats(55, 40, 85, 80, 105, 40);
        setType(Type.FAIRY, Type.FLYING);
        addMove(new SweetKiss());
    }
}

class Togekiss extends Togetic {
    public Togekiss(String name, int level) {
        super(name, level);
        setStats(85, 50, 95, 120, 115, 80);
        setType(Type.FAIRY, Type.FLYING);
        addMove(new Roost());
    }
}

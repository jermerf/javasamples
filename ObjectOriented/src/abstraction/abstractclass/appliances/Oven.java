package abstraction.abstractclass.appliances;

import abstraction.abstractclass.Pluggable;

public abstract class Oven implements Pluggable {
    @Override
    public int getProngs() {
        return 3;
    }

    public abstract int getVoltage();
}

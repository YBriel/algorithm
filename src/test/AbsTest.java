package test;

/**
 * Author： yuzq
 * Description:
 * Date: 2020/1/31   8:23
 */
public abstract class AbsTest {

    private float power;

    private String unit = "V";

    public AbsTest(float power) {
        this.power = power;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}

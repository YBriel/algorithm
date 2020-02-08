package thread;

/**
 * @Author： yuzq
 * @Description:
 * @Date: 2020/1/2   9:27
 */
public enum CountryEnum {
    ONE(1, "齐", "哈哈"),
    THREE(3, "燕",null),
    TWO(2, "楚", "出国");
/*
    THREE(3, "燕"),
    FOUR(4,"韩"),
    FIVE(5,"赵"),
    SIX(6,"魏");
*/

    private Integer retcode;
    private String retMsg;
    private String msg;

    public Integer getRetcode() {
        return retcode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public String getMsg() {
        return msg;
    }

    CountryEnum(Integer retcode, String retMsg, String msg) {
        this.retcode = retcode;
        this.msg = msg;
        this.retMsg = retMsg;
    }

        public static CountryEnum forEachCountry(int index) {
            CountryEnum[] values = CountryEnum.values();
            for (CountryEnum countryEnum : values) {
                if (index == countryEnum.retcode) {
                    return countryEnum;
                }
            }
            return null;
        }
/*    public static CountryEnum forEachCountry1(int index) {

        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum value : values) {
            if(index==value.retcode){
                return value;
            }
        }return null;
    }*/

    public static void main(String[] args) {
/*        System.out.println(CountryEnum.ONE);
        System.out.println(CountryEnum.ONE.retcode);
        System.out.println(CountryEnum.ONE.retMsg);
        System.out.println(CountryEnum.ONE.msg);
        System.out.println(CountryEnum.ONE);*/
        System.out.println(CountryEnum.THREE.msg == null ? "sss" : CountryEnum.THREE.msg);
        System.out.println(CountryEnum.TWO.msg == null ? "sss" : CountryEnum.TWO.msg);
    }
}

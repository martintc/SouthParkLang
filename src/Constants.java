public enum Constants {

    TREEFIDDY,
    NOT_A_CONSTANT;

    public static Constants getConstantsToken (String s) {
        switch (s) {
            case "treeFiddy" :
                return Constants.TREEFIDDY;
            default :
                return Constants.NOT_A_CONSTANT;
        }
    }

    public static String getValueOfConstant (Constants c) {
        if (c == Constants.TREEFIDDY) {
            return "350";
        } else {
            return null;
        }
    }
    
}
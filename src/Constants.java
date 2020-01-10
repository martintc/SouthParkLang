public enum Constants {

    TREEFIFTY,
    NOT_A_CONSTANT;

    public Constants getConstantsToken (String s) {
        switch (s) {
            case "treeFifty" :
                return TREEFIFTY;
            default :
                return NOT_A_CONSTANT;
        }
    }

    public String getValueOfConstant (Constants c) {
        if (c == Constants.TREEFIFTY) {
            return "350";
        } else {
            return null;
        }
    }
    
}
package com.curou.oa.vo.response;

import com.curou.oa.models.LmRegistrationCode;

public class LmRegistrationCodeRes extends LmRegistrationCode {

    private String proName;

    private String cardName;

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
}

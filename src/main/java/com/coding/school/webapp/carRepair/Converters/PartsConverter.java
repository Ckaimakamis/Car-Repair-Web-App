package com.coding.school.webapp.carRepair.Converters;

import com.coding.school.webapp.carRepair.Domain.Parts;
import com.coding.school.webapp.carRepair.Model.PartsForm;

public class PartsConverter {

    public static Parts buildPartsObject(PartsForm partsForm) {
        Parts parts = new Parts();
        parts.setCost(partsForm.getCost());
        parts.setType(partsForm.getType());

        return parts;
        }


        private static Parts.PartsType partsTypeConverter(String type){
        Parts.PartsType partsType = null;
        switch (type){
            case "TIRES":
                partsType = Parts.PartsType.TIRES;
                break;
            case "BRAKES":
                partsType = Parts.PartsType.BRAKES;
                break;
            case "FENDER":
                partsType = Parts.PartsType.FENDER;
                break;
            case "WINDOWS":
                partsType = Parts.PartsType.WINDOWS;
                break;
        }
        return partsType;
    }
}

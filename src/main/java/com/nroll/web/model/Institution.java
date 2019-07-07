package com.nroll.web.model;

import com.nroll.web.model.enums.InstitutionType;

public class Institution extends AbstractModel{
    private final String name;
    private final InstitutionType institutionType;

    public Institution(int id, String name, InstitutionType institutionType) {
        super(id);
        this.name = name;
        this.institutionType = institutionType;
    }
}

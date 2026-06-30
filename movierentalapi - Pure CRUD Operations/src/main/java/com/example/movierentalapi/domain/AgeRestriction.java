package com.example.movierentalapi.domain;

public enum AgeRestriction
{
    G("General: All ages admitted."),
    PG("Parental Guidance: Some material may not be suitable for children."),
    PG13("Parents Strongly Cautioned: Some material may be inappropriate for children under 13."),
    R("Restricted: Anyone under 17 requires an accompanying parent or adult guardian."),
    NC17("Adults Only: No one 17 and under admitted.");

    private final String meaning;

    AgeRestriction(String meaning)
    {
        this.meaning = meaning;
    }

    public String getMeaning()
    {
        return meaning;
    }
}

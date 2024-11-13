package org.jihad.hunters_leagues.exception;

public class SpeciesNotFoundException extends RuntimeException {
    public SpeciesNotFoundException() {
        super("Species not found");
    }
}

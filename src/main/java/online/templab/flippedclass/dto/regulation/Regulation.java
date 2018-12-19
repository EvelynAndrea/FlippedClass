package online.templab.flippedclass.dto.regulation;

import online.templab.flippedclass.dto.TeamDTO;

/**
 * @author Cesare
 */
public interface Regulation {

    /**
     * Use regulation to validate a team's structure.
     *
     * @param team the team that need validating
     * @return whether the team passed the validating.
     */
    boolean validate(TeamDTO team);

    /**
     * Get the regulation's msg if validation does not pass.
     *
     * @return the error message.
     */
    String getErrorMsg();
}

package model;

import integration.DBPortal;
import shared.ApplicationDTO;
import shared.DateDTO;
import shared.ExperienceDTO;

public class Application {
    DBPortal portal;

    /**
     *  Constructor for the Application class.
     *
     * @param   portal  a DBPortal object(Database Portal). The model communicates only with DBPortal in the Integration layer.
     */
    public Application(DBPortal portal){this.portal = portal;}

    /**
     *  This method is called from the Control layer when a someone is trying to register a new application.
     *
     * It returns a boolean, an Exception if there was an error with the application. True if it was successfully sent to the integration layer.
     *
     * It returns an Exception if the userID does not exist, using userIDExists(String UserID).
     * It returns an Exception if An experience has a competence that does not exist, using competenceExist(String competence)
     * It returns an Exception if two availabilities contain the same starting date.
     *
     * if none of the above occur, it sends the Experience list and the Availability list (along with the userID) to
     * the integration layer, and then returns true.
     *
     * @param   application  An ApplicationDTO(Person Data Transfer Object), which contains all necessary data for an application.
     * @return  boolean  Exception if error, true if successful registration of application
     */
    public boolean registerApplication(ApplicationDTO application) throws ErrorHandling.RegisterApplicationExeption{
        if(!portal.userIDExist(application.getUserID()))
            throw new ErrorHandling.RegisterApplicationExeption("Invalid UserID!");
        for(ExperienceDTO to : application.getExperience()){
            if (!portal.competenceExist(to.getName()))
                    throw new ErrorHandling.RegisterApplicationExeption("This competence does not exist!");
        }
        int i = 1;
        for (DateDTO to : application.getAvailabilities()){
            i++;
            for (DateDTO to1 : application.getAvailabilities().subList(i,application.getAvailabilities().size())){
                if(to1.getStart().equals(to.getStart()))
                    throw new ErrorHandling.RegisterApplicationExeption("Invalid Availabilities!");
            }
        }
        portal.competenceListToDB(application.getUserID(),application.getExperience());
        portal.avalabilityListToDB(application.getUserID(), application.getAvailabilities());
        return true;
    }
}

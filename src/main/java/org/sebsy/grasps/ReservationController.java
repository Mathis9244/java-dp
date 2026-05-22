package org.sebsy.grasps;

import org.sebsy.grasps.beans.Client;
import org.sebsy.grasps.beans.Reservation;
import org.sebsy.grasps.beans.TypeReservation;
import org.sebsy.grasps.daos.ClientDao;
import org.sebsy.grasps.daos.TypeReservationDao;

import java.time.LocalDateTime;

/**
 * Contrôleur GRASP : coordonne la création d'une réservation sans porter
 * les responsabilités d'expert (calcul du total) ni de pure fabrication (dates).
 */
public class ReservationController {

	private final ClientDao clientDao = new ClientDao();
	private final TypeReservationDao typeReservationDao = new TypeReservationDao();
	private final ConvertisseurDate convertisseurDate = new ConvertisseurDate();

	public Reservation creerReservation(Params params) {
		String identifiantClient = params.getIdentifiantClient();
		String dateReservationStr = params.getDateReservation();
		String typeReservation = params.getTypeReservation();
		int nbPlaces = params.getNbPlaces();

		LocalDateTime dateReservation = convertisseurDate.toLocalDateTime(dateReservationStr);
		Client client = clientDao.extraireClient(identifiantClient);
		TypeReservation type = typeReservationDao.extraireTypeReservation(typeReservation);

		Reservation reservation = new Reservation(dateReservation);
		reservation.setNbPlaces(nbPlaces);
		reservation.setClient(client);
		reservation.calculerTotal(type);

		client.getReservations().add(reservation);
		return reservation;
	}
}

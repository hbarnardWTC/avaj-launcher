/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   AircraftFactory.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hbarnard <wingarkorin@gmail.com>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/21 14:59:07 by hbarnard          #+#    #+#             */
/*   Updated: 2020/08/21 14:59:07 by hbarnard         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package aircraft;

import simulation.Coordinates;

public abstract class AircraftFactory{

	public static Flyable newAircraft(String type,
									  String name,
									  int longitude,
									  int latitude,
									  int height)
	{
		Coordinates coordinates = new Coordinates(longitude, latitude, height);

		if (type.toLowerCase().trim().equals("baloon")){
			return new Baloon(name, coordinates);
		} else if (type.toLowerCase().trim().equals("helicopter")){
			return new Helicopter(name, coordinates);
		} else if (type.toLowerCase().trim().equals("jetplane")){
			return new JetPlane(name ,coordinates);
		}
		return null;
	}
}
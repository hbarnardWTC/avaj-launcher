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

public abstract class AircraftFactory{

	public static Flyable newAircraft(String type,
									  String name,
									  int longitude,
									  int latitude,
									  int height)
	{
		return null;
	}
}
/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   JetPlane.java                                      :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hbarnard <wingarkorin@gmail.com>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/21 14:59:02 by hbarnard          #+#    #+#             */
/*   Updated: 2020/08/21 14:59:02 by hbarnard         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package aircraft;

import simulation.Coordinates;
import simulation.WeatherTower;

public class JetPlane extends Aircraft implements Flyable{

	private WeatherTower weatherTower;

	public JetPlane(String name, Coordinates coordinates){
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		String message = "Jetplane#" + super.name + "(" + super.id + ")" + "has registered.";
		//Don't use sout, does some weird stuff
		System.out.println(message);
	}
}
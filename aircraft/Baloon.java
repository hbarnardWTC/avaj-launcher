/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Baloon.java                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hbarnard <wingarkorin@gmail.com>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/21 14:58:57 by hbarnard          #+#    #+#             */
/*   Updated: 2020/08/21 14:58:57 by hbarnard         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package aircraft;

import simulation.Coordinates;
import simulation.WeatherTower;

public class Baloon extends Aircraft implements Flyable{

	private WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates){
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		String message = "Baloon#" + super.name + "(" + super.id + ")" + "has registered.";
		//Don't use sout, does some weird stuff
		System.out.println(message);
	}
}
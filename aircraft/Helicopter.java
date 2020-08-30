/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Helicopter.java                                    :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hbarnard <wingarkorin@gmail.com>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/21 14:58:59 by hbarnard          #+#    #+#             */
/*   Updated: 2020/08/21 14:58:59 by hbarnard         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package aircraft;

import simulation.Coordinates;
import simulation.WeatherTower;

public class Helicopter extends Aircraft implements Flyable{

	private WeatherTower weatherTower;

	public Helicopter(String name, Coordinates coordinates){
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN")) {
			this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): is zooming through the skies! Now where is my promised minigun?");
		} else if (weather.equals("RAIN")) {
			this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): is not to have the side doors left open for wild yeehaws.");
		} else if (weather.equals("FOG")) {
			this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): is possibly upside down. Proooobably fine. Probably.");
		} else if (weather.equals("SNOW")) {
			this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): has very fast spinny thing on top. Like an ice beyblade");
		} else {
			System.out.println("THE HELICOPTER IS STUCK IN AN ANOMALOUS WORMHOLE! IT IS STUCK AND WE ARE DOOOMMMMEED");
			return;
		}

        if (this.coordinates.getHeight() == 0)
        {
			System.out.println(	"Helicopter#" + this.name + "(" + this.id + "): has safely landed at " + 
								getLandingCoordinates(coordinates) +
								". Now to go stick my hand into the spinny thing at the back");
            this.weatherTower.unregister(this);
            System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower. Only one hand lost");
        }
	}

	private String getLandingCoordinates(Coordinates coordinates){
		String landing ="Longitude: " + Integer.toString(coordinates.getLongitude()) + " Latitude: " + Integer.toString(coordinates.getLatitude()); 
		return landing;
	}

	@Override
	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		String message = "Helicopter#" + super.name + "(" + super.id + ")" + "has registered.";
		//Don't use sout, does some weird stuff
		System.out.println(message);
	}
}
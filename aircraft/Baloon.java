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
import simulation.Printer;
import simulation.WeatherTower;

public class Baloon extends Aircraft implements Flyable{

	private WeatherTower weatherTower;

	public Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN")) {
			this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
			Printer.addLine("Baloon#" + this.name + "(" + this.id + "): is floating away! It shall be naught but a speck soon!");
		} else if (weather.equals("RAIN")) {
			this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
			Printer.addLine("Baloon#" + this.name + "(" + this.id + "): is sopping wet. A baloon in the rain? Who authorised this??");
		} else if (weather.equals("FOG")) {
			this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
			Printer.addLine("Baloon#" + this.name + "(" + this.id + "): is unknown. Can't see the a thing.");
		} else if (weather.equals("SNOW")) {
			this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
			Printer.addLine("Baloon#" + this.name + "(" + this.id + "): is going down! TOO FAST DOWN TOO FASTT UGGGGGGHHHHHHH");
		} else {
			Printer.addLine("THE BALOON IS STUCK IN AN ANOMALOUS WORMHOLE! IT IS STUCK AND WE ARE DOOOMMMMEED");
			return;
		}

        if (this.coordinates.getHeight() == 0)
        {
			Printer.addLine("Baloon#" + this.name + "(" + this.id + "): has safely landed at " + 
								getLandingCoordinates(coordinates) +
								". The terror of being a BALLOON is over!");
            this.weatherTower.unregister(this);
            Printer.addLine("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower. Good riddance!");
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
		String message = "Baloon#" + super.name + "(" + super.id + ")" + "has registered.";
		//Don't use sout, does some weird stuff
		Printer.addLine(message);
	}
}
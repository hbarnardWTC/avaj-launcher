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

import simulation.Printer;
import simulation.Coordinates;
import simulation.WeatherTower;

public class JetPlane extends Aircraft implements Flyable{

	private WeatherTower weatherTower;

	public JetPlane(String name, Coordinates coordinates){
		super(name, coordinates);
	}

	@Override
	public void updateConditions() {
		String weather = weatherTower.getWeather(this.coordinates);
		if (weather.equals("SUN")) {
			this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
			Printer.addLine("Jetplane#" + this.name + "(" + this.id + "): is flying smoothly! So why do I need this parachute?");
		} else if (weather.equals("RAIN")) {
			this.coordinates = new Coordinates(coordinates.getLongitude() , coordinates.getLatitude() + 5, coordinates.getHeight());
			Printer.addLine("Jetplane#" + this.name + "(" + this.id + "): is forbidden from having spooky stuff stored on board");
		} else if (weather.equals("FOG")) {
			this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
			Printer.addLine("Jetplane#" + this.name + "(" + this.id + "): is doing loopedy loops. In fog. Where is that parachute...");
		} else if (weather.equals("SNOW")) {
			this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
			Printer.addLine("Jetplane#" + this.name + "(" + this.id + "): is haunted! A ghost stole the parachutes!!!");
		} else {
			Printer.addLine("THE HELICOPTER IS STUCK IN AN ANOMALOUS WORMHOLE! IT IS STUCK AND WE ARE DOOOMMMMEED");
			return;
		}

        if (this.coordinates.getHeight() == 0)
        {
			Printer.addLine("Jetplane#" + this.name + "(" + this.id + "): has safely landed at " + 
								getLandingCoordinates(coordinates) +
								". Hire an exorcist");
            this.weatherTower.unregister(this);
            Printer.addLine("Tower says: Jetplane#" + this.name + "(" + this.id + ") unregistered from weather tower. Cancel the exorcist. Fire Jim. Who keeps hiring him???");
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
		String message = "Jetplane#" + super.name + "(" + super.id + ")" + "has registered.";
		//Don't use sout, does some weird stuff like below
		//SourceToHTMLConverter
		Printer.addLine(message);
	}
}
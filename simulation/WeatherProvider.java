/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   WeatherProvider.java                               :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hbarnard <wingarkorin@gmail.com>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/21 14:59:13 by hbarnard          #+#    #+#             */
/*   Updated: 2020/08/21 14:59:13 by hbarnard         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package simulation;

public class WeatherProvider {
	private static WeatherProvider weatherProvider;
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	public WeatherProvider(){
	}

	public static WeatherProvider getProvider() {
		return weatherProvider;
	}
	
	public static String getCurrentWeather(Coordinates coordinates) {
		int result = Math.abs(coordinates.getLatitude() - coordinates.getLongitude() + coordinates.getHeight()) % 4;
		return weather[result];
	}
}
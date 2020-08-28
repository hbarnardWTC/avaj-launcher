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
	private static String weather;

	public WeatherProvider(){

	}

	public static WeatherProvider getProvider() {
		return weatherProvider;
	}
	public static String getCurrentWeather(Coordinates coordinates) {
		return weather;
	}
}
/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   WeatherTower.java                                  :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hbarnard <wingarkorin@gmail.com>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/21 14:59:16 by hbarnard          #+#    #+#             */
/*   Updated: 2020/08/21 14:59:16 by hbarnard         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package simulation;

public class WeatherTower extends Tower{
	
	public String getWeather(Coordinates coordinates){
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	//Apparently no mod is package private? So weird
	void changeWeather(){
		this.conditionsChanged();
	}
}
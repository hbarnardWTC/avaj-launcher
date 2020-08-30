/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   Coordinates.java                                   :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: hbarnard <wingarkorin@gmail.com>           +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2020/08/21 14:59:09 by hbarnard          #+#    #+#             */
/*   Updated: 2020/08/21 14:59:09 by hbarnard         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

package simulation;

public class Coordinates{

	//variables
	private int longitude;
	private int latitude;
	private int height;

	//constructor
	public Coordinates(int longitude, int latitude, int height){
		if (height <= 0) {
			this.height = 0;
		} else if (height > 100) {
			this.height = 100;
		} else {
			this.height = height;
		}

		if (latitude <= 0) {
			this.latitude = 0;
		} else {
			this.latitude = latitude;
		}
		
		if (longitude <= 0) {
			this.longitude = 0;
		} else {
			this.longitude = longitude;
		}
	}

	//getters
	public int getHeight(){
		return height;
	}

	public int getLatitude(){
		return latitude;
	}

	public int getLongitude(){
		return longitude;
	}
}
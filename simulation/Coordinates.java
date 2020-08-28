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
		this.height = height;
		this.latitude = latitude;
		this.longitude = longitude;
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